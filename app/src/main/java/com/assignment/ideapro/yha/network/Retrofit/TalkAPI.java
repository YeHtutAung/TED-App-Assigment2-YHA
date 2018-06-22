package com.assignment.ideapro.yha.network.Retrofit;

import com.assignment.ideapro.yha.network.responses.GetTalksResponse;
import com.assignment.ideapro.yha.utils.TedTalksConstant;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface TalkAPI {
    @FormUrlEncoded
    @POST(TedTalksConstant.API_GET_TED_TALK_LIST)
    Call<GetTalksResponse> loadNewList(
            @Field(TedTalksConstant.PARAM_ACCESS_TOKEN) String accessToken,
            @Field(TedTalksConstant.PARAM_PAGE) int page);
}
