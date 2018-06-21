package com.assignment.ideapro.yha.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.TextView;

import com.assignment.ideapro.yha.R;
import com.assignment.ideapro.yha.adapters.WatchNextAdapter;
import com.assignment.ideapro.yha.data.data.vos.TalksVO;
import com.assignment.ideapro.yha.data.models.TedTalksModel;
import com.assignment.ideapro.yha.delegates.ITedTalkDelegate;
import com.bumptech.glide.Glide;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TedTalksDeatilsActivity extends  BaseActivity implements ITedTalkDelegate {

    private WatchNextAdapter mWatchNextAdapter;
    private TalksVO mTalksVO;

    @BindView(R.id.tv_talk_details)
    TextView tvTalkDetails;

    @BindView(R.id.iv_talk_publication)
    ImageView ivTalkPublication;

    @BindView(R.id.tv_speaker_name)
    TextView tvSpeakerName;

    @BindView(R.id.tv_text_brief)
    TextView tvTextBrief;

    @BindView(R.id.tv_duration_in_sec)
    TextView tvDurationInSec;

    @BindView(R.id.tv_about_speaker_name)
    TextView tvAboutSpeakerName;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_talk_details);

        ButterKnife.bind(this);

        int talkId = getIntent().getIntExtra("talkId", 0);

        TalksVO talk = TedTalksModel.getIObjectInstance().getTalkById(talkId);
        setTalkData(talk);
        RecyclerView rvWatchNext = findViewById(R.id.rv_watch_next);
        mWatchNextAdapter = new WatchNextAdapter(talk);
        rvWatchNext.setAdapter(mWatchNextAdapter);
        rvWatchNext.setLayoutManager(new LinearLayoutManager(getApplicationContext(),
                LinearLayoutManager.VERTICAL, false));
    }

    @Override
    public void onTapImage(TalksVO talk) {
        Intent intent = new Intent(getApplicationContext(), TedTalksDeatilsActivity.class);
        startActivity(intent);
    }

    private void setTalkData(TalksVO talk) {
        this.mTalksVO = talk;
        if (talk != null) {
            Glide.with(ivTalkPublication.getContext())
                    .load(mTalksVO.getImageURL())
                    .into(ivTalkPublication);
            if (talk.getSpeakersVO() != null) {
                tvSpeakerName.setText(talk.getSpeakersVO().getName());
                tvAboutSpeakerName.setText(talk.getSpeakersVO().getName());
            }
            tvTextBrief.setText(talk.getTitle());
            tvTalkDetails.setText(talk.getDescription());
            tvDurationInSec.setText(getMinuteFromSec(talk.getDurationInSec()));
        }
    }

    private String getMinuteFromSec(int sec) {
        int hours = sec / 3600;
        int minutes = (sec % 3600) / 60;
        int seconds = sec % 60;
        if (hours == 0) {
            return String.format("%02d:%02d", minutes, seconds);
        }
        return String.format("%02d:%02d:%02d", hours, minutes, seconds);
    }

    @Override
    public void onTapFavorite(TalksVO talk) {

    }

    @Override
    public void onTapComments(TalksVO talk) {

    }

    @Override
    public void onTapSendTo(TalksVO talk) {

    }

    @Override
    public void onTapStatistics(TalksVO talk) {

    }
}
