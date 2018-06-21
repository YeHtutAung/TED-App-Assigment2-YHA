package com.assignment.ideapro.yha.data.data.vos;

import com.google.gson.annotations.SerializedName;

public class TagVO {
    @SerializedName("tag_id")
    private int tagId = 0;
    @SerializedName("tag")
    private String tag = null;
    @SerializedName("description")
    private String description = null;

    public int getTagId() {
        return tagId;
    }

    public String getTag() {
        return tag;
    }

    public String getDescription() {
        return description;
    }
}
