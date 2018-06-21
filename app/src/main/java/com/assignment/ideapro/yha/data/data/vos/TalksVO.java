package com.assignment.ideapro.yha.data.data.vos;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class TalksVO {

    @SerializedName("talk_id")
    private int talkId = 0;
    @SerializedName("title")
    private String title = null;
    @SerializedName("speaker")
    private SpeakersVO speakersVO = null;
    @SerializedName("imageUrl")
    private String imageURL = null;
    @SerializedName("durationInSec")
    private int durationInSec = 0;
    @SerializedName("description")
    private String description = null;
    @SerializedName("tag")
    private List<TagVO> tags = null;

    public int getTalkId() {
        return talkId;
    }

    public String getTitle() {
        return title;
    }

    public SpeakersVO getSpeakersVO() {
        return speakersVO;
    }

    public String getImageURL() {
        return imageURL;
    }

    public int getDurationInSec() {
        return durationInSec;
    }

    public String getDescription() {
        return description;
    }

    public List<TagVO> getTags() {
        if (tags == null) {
            tags = new ArrayList<>();
        }
        return tags;
    }
}
