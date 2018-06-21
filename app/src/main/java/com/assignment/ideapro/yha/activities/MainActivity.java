package com.assignment.ideapro.yha.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import com.assignment.ideapro.yha.R;
import com.assignment.ideapro.yha.adapters.TalksAdapter;
import com.assignment.ideapro.yha.data.data.vos.TalksVO;
import com.assignment.ideapro.yha.data.models.TedTalksModel;
import com.assignment.ideapro.yha.delegates.ITedTalkDelegate;
import com.assignment.ideapro.yha.events.SuccessGetTalksEvent;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class MainActivity extends BaseActivity implements ITedTalkDelegate {

    private TalksAdapter mTalksAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);

        RecyclerView rvNews = findViewById(R.id.rv_news);
        mTalksAdapter = new TalksAdapter(this);
        rvNews.setAdapter(mTalksAdapter);
        rvNews.setLayoutManager(new LinearLayoutManager(getApplicationContext(),
                LinearLayoutManager.VERTICAL, false));

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        TedTalksModel.getIObjectInstance().loadNewsList();
    }

    @Override
    public void onTapImage(TalksVO talk) {
        Intent intent = new Intent(getApplicationContext(), TedTalksDeatilsActivity.class);
        intent.putExtra("talkId", talk.getTalkId());
        startActivity(intent);
    }

    @Override
    public void onTapFavorite(TalksVO news) {

    }

    @Override
    public void onTapComments(TalksVO news) {

    }

    @Override
    public void onTapSendTo(TalksVO news) {

    }

    @Override
    public void onTapStatistics(TalksVO news) {

    }

    @Override
    protected void onStart() {
        super.onStart();
        if (!EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().register(this);
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().unregister(this);
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onSuccessGetTalks(SuccessGetTalksEvent event) {
        Log.d("onSuccessGetTalks", "onSuccessGetTalks : " + event.getTalksList());
        mTalksAdapter.setTalkList(event.getTalksList());
    }
}
