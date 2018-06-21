package com.assignment.ideapro.yha.network.responses;

import com.assignment.ideapro.yha.data.data.vos.TalksVO;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class GetTalksResponse {
    @SerializedName("code")
    private int code = 0;
    @SerializedName("message")
    private String message = null;
    @SerializedName("apiVersion")
    private String apiVesion = null;
    @SerializedName("page")
    private String page = null;
    @SerializedName("ted_talks")
    List<TalksVO> talkList = null;

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public String getApiVesion() {
        return apiVesion;
    }

    public String getPage() {
        return page;
    }

    public List<TalksVO> getTalkList() {
        if (talkList == null) {
            talkList = new ArrayList<>();
        }
        return talkList;
    }

    public boolean isResponseOK() {
        return (code == 200 && talkList != null);
    }
}
