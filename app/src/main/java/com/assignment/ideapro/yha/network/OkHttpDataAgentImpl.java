package com.assignment.ideapro.yha.network;

import android.os.AsyncTask;
import android.util.Log;
import com.assignment.ideapro.yha.events.ApiErrorEvent;
import com.assignment.ideapro.yha.events.SuccessGetTalksEvent;
import com.assignment.ideapro.yha.network.responses.GetTalksResponse;
import com.assignment.ideapro.yha.utils.TedTalksConstant;
import com.google.gson.Gson;
import org.greenrobot.eventbus.EventBus;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class OkHttpDataAgentImpl implements TedTalksDataAgent {

    private static OkHttpDataAgentImpl sObjInstance;

    private OkHttpClient mHttpClient;

    public OkHttpDataAgentImpl() {
        mHttpClient = new OkHttpClient.Builder() //1.
                .connectTimeout(15, TimeUnit.SECONDS)
                .writeTimeout(15, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS)
                .build();
    }

    public static OkHttpDataAgentImpl getInstance() {
        if (sObjInstance == null) {
            sObjInstance = new OkHttpDataAgentImpl();
        }
        return sObjInstance;
    }

    @Override
    public void loadNewsList(final int page, final String accessToken) {
        new AsyncTask<Void, Void, String>() {

            @Override
            protected String doInBackground(Void... voids) {
                RequestBody formBody = new FormBody.Builder() //2.
                        .add(TedTalksConstant.PARAM_ACCESS_TOKEN, accessToken)
                        .add(TedTalksConstant.PARAM_PAGE, String.valueOf(page))
                        .build();

                Request request = new Request.Builder() //3
                        .url(TedTalksConstant.TED_TALK_BASE_URL + TedTalksConstant.API_GET_TED_TALK_LIST)
                        .post(formBody)
                        .build();

                try {
                    Response response = mHttpClient.newCall(request).execute(); //4.
                    if (response.isSuccessful()) {
                        String responseString = response.body().string();
                        return responseString;
                    } else {
                    }
                } catch (IOException e) {
                    Log.e("", e.getMessage());
                }
                return null;
            }

            @Override
            protected void onPostExecute(String result) {
                super.onPostExecute(result);
                Gson gson = new Gson();
                GetTalksResponse talksResponse = gson.fromJson(result, GetTalksResponse.class);
                Log.d("TedTalks", "Size = " + talksResponse.getTalkList().size());

                if(talksResponse.isResponseOK()) {
                    // event broadcast
                    SuccessGetTalksEvent event =  new SuccessGetTalksEvent(talksResponse.getTalkList());
                    EventBus.getDefault().post(event);
                } else {
                    ApiErrorEvent errorEvent = new ApiErrorEvent(talksResponse.getMessage());
                    EventBus.getDefault().post(errorEvent);
                }
            }
        }.execute();
    }
}
