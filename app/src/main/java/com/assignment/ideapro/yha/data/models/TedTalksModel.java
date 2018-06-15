package com.assignment.ideapro.yha.data.models;

import com.assignment.ideapro.yha.network.HttpUrlConnectionDataAgentImpl;
import com.assignment.ideapro.yha.network.TedTalksDataAgent;

public class TedTalksModel {

    private static TedTalksModel objectInstance;
    private TedTalksDataAgent mDataAgent;
    private static final String DUMMY_ACCESS_TOKEN = "b002c7e1a528b7cb460933fc2875e916";

    private TedTalksModel() {
        mDataAgent = HttpUrlConnectionDataAgentImpl.getInstance();
    }

    public static TedTalksModel getIObjectInstance() {
        if (objectInstance == null) {
            objectInstance = new TedTalksModel();
        }
        return objectInstance;
    }

    public void loadNewsList() {
        mDataAgent.loadNewsList(1, DUMMY_ACCESS_TOKEN);
    }
}
