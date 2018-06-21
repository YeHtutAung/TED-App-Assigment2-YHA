package com.assignment.ideapro.yha.data.data.vos;

import com.google.gson.annotations.SerializedName;

public class SpeakersVO {
    @SerializedName("speaker_id")
    private int speakerId = 0;
    @SerializedName("name")
    private String name = null;

    public int getSpeakerId() {
        return speakerId;
    }

    public String getName() {
        return name;
    }
}
