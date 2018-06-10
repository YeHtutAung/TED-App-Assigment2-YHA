package com.assignment.ideapro.yha.data.data.vos;

import java.util.ArrayList;
import java.util.List;

public class TalksVO {

    private int talkId = 0;
    private String title = null;
    private SpeakersVO speakersVO = null;
    private String imageURL = null;
    private int durationInSec = 0;
    private String description = null;
    private List<Tag> tags = null;

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

    public List<Tag> getTags() {
        if (tags == null) {
            tags = new ArrayList<>();
        }
        return tags;
    }
}
