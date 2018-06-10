package com.assignment.ideapro.yha.data.models;

public class NewsModel {

    private static NewsModel objectInstance;

    private NewsModel() {
    }

    public static NewsModel getIObjectInstance() {
        if (objectInstance == null) {
            objectInstance = new NewsModel();
        }
        return objectInstance;
    }

    public void loadNewsList() {

    }
}
