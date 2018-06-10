package com.assignment.ideapro.yha.data.data.vos;

import java.util.ArrayList;
import java.util.List;

public class PodcastVO {
    private int podcaseId = 0;
    private String title = null;
    private String imageURL = null;
    private String descripiton = null;
    private List<SegmentVO> segmentVOs = null;

    public int getPodcaseId() {
        return podcaseId;
    }

    public String getTitle() {
        return title;
    }

    public String getImageURL() {
        return imageURL;
    }

    public String getDescripiton() {
        return descripiton;
    }

    public List<SegmentVO> getSegmentVOs() {
        if (segmentVOs == null) {
            segmentVOs = new ArrayList<>();
        }
        return segmentVOs;
    }
}
