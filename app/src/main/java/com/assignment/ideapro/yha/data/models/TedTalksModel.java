package com.assignment.ideapro.yha.data.models;

import com.assignment.ideapro.yha.data.data.vos.TalksVO;
import com.assignment.ideapro.yha.events.SuccessGetTalksEvent;
import com.assignment.ideapro.yha.network.OkHttpDataAgentImpl;
import com.assignment.ideapro.yha.network.TedTalksDataAgent;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import java.util.HashMap;
import java.util.Map;

public class TedTalksModel {

    private static TedTalksModel objectInstance;
    private TedTalksDataAgent mDataAgent;
    private static final String DUMMY_ACCESS_TOKEN = "b002c7e1a528b7cb460933fc2875e916";

    private Map<Integer, TalksVO> mTalksMap;

    private TedTalksModel() {
        mTalksMap = new HashMap<>();
        //mDataAgent = HttpUrlConnectionDataAgentImpl.getInstance();
        mDataAgent = OkHttpDataAgentImpl.getInstance();
        EventBus.getDefault().register(this);
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

    public TalksVO getTalkById(int newsId) {
        return mTalksMap.get(newsId);
    }

    @Subscribe(threadMode = ThreadMode.BACKGROUND)
    public void onSuccessGetTalks(SuccessGetTalksEvent event) {
        for(TalksVO news : event.getTalksList()) {
            mTalksMap.put(news.getTalkId(), news);
        }
    }
}
