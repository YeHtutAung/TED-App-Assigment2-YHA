package com.assignment.ideapro.yha.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.assignment.ideapro.yha.R;
import com.assignment.ideapro.yha.adapters.NewsAdapter;
import com.assignment.ideapro.yha.adapters.WatchNextAdapter;
import com.assignment.ideapro.yha.delegates.ITedTalkDelegate;

public class TedTalksDeatilsActivity extends  BaseActivity implements ITedTalkDelegate {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_details);

        RecyclerView rvWatchNext = findViewById(R.id.rv_watch_next);

        WatchNextAdapter watchNextAdapter = new WatchNextAdapter();
        rvWatchNext.setAdapter(watchNextAdapter);
        rvWatchNext.setLayoutManager(new LinearLayoutManager(getApplicationContext(),
                LinearLayoutManager.VERTICAL, false));
    }

    @Override
    public void onTapImage() {
        Intent intent = new Intent(getApplicationContext(), TedTalksDeatilsActivity.class);
        startActivity(intent);
    }
}
