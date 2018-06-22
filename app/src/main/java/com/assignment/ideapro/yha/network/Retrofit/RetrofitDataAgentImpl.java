package com.assignment.ideapro.yha.network.Retrofit;


import com.assignment.ideapro.yha.events.ApiErrorEvent;
import com.assignment.ideapro.yha.events.SuccessGetTalksEvent;
import com.assignment.ideapro.yha.network.TedTalksDataAgent;
import com.assignment.ideapro.yha.network.responses.GetTalksResponse;
import com.assignment.ideapro.yha.utils.TedTalksConstant;

import org.greenrobot.eventbus.EventBus;
import java.util.concurrent.TimeUnit;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitDataAgentImpl implements TedTalksDataAgent {

    private static RetrofitDataAgentImpl sObjectInstatnce;

    private TalkAPI mNewsAPI;

    private RetrofitDataAgentImpl() {
        final OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(15, TimeUnit.SECONDS)
                .writeTimeout(15, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS)
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(TedTalksConstant.TED_TALK_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build();

        mNewsAPI = retrofit.create(TalkAPI.class);
    }

    public static RetrofitDataAgentImpl getInstance() {
        if (sObjectInstatnce == null) {
            sObjectInstatnce = new RetrofitDataAgentImpl();
        }
        return sObjectInstatnce;
    }


    @Override
    public void loadNewsList(int page, String accessToken) {
        Call<GetTalksResponse> loadNewsCall = mNewsAPI.loadNewList(accessToken, page);
        loadNewsCall.enqueue(new Callback<GetTalksResponse>() {
            @Override
            public void onResponse(Call<GetTalksResponse> call, Response<GetTalksResponse> response) {
                // to get object from generic type
                GetTalksResponse getNewsResponse = response.body();
                if (getNewsResponse != null && getNewsResponse.isResponseOK()) {
                    // event broadcast
                    SuccessGetTalksEvent event =  new SuccessGetTalksEvent(getNewsResponse.getTalkList());
                    EventBus.getDefault().post(event);
                } else {
                    if (getNewsResponse == null) {
                        ApiErrorEvent errorEvent = new ApiErrorEvent("Empty response in network call");
                        EventBus.getDefault().post(errorEvent);
                    } else {
                        ApiErrorEvent errorEvent = new ApiErrorEvent(getNewsResponse.getMessage());
                        EventBus.getDefault().post(errorEvent);
                    }
                }
            }

            @Override
            public void onFailure(Call<GetTalksResponse> call, Throwable t) {
                ApiErrorEvent errorEvent = new ApiErrorEvent(t.getMessage());
                EventBus.getDefault().post(errorEvent);
            }
        });
    }
}
