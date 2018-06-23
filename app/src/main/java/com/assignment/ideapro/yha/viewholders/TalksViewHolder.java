package com.assignment.ideapro.yha.viewholders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.assignment.ideapro.yha.R;
import com.assignment.ideapro.yha.data.data.vos.TalksVO;
import com.assignment.ideapro.yha.delegates.ITedTalkDelegate;
import com.assignment.ideapro.yha.utils.CommonUtils;
import com.bumptech.glide.Glide;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TalksViewHolder extends RecyclerView.ViewHolder {

    private ITedTalkDelegate mDelegate;
    private TalksVO mTalk;

    @BindView(R.id.tv_speaker_name)
    TextView tvSpeakerName;

    @BindView(R.id.iv_publication)
    ImageView ivPublication;

    @BindView(R.id.tv_title)
    TextView tvTitle;

    @BindView(R.id.tv_duration_in_sec)
    TextView tvDurationInSec;

    public TalksViewHolder(View itemView, ITedTalkDelegate delegate) {
        super(itemView);
        ButterKnife.bind(this, itemView);
        mDelegate = delegate;
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDelegate.onTapImage(mTalk);
            }
        });
    }

    public void setmTalk(TalksVO talk) {
        this.mTalk = talk;
        if (talk != null) {
            Glide.with(itemView.getContext())
                    .load(mTalk.getImageURL())
                    .into(ivPublication);
            tvSpeakerName.setText(talk.getSpeakersVO().getName());
            tvTitle.setText(talk.getTitle());
            tvDurationInSec.setText(CommonUtils.getInstance().getMinuteFromSec(talk.getDurationInSec()));
        }
    }

//    private String getMinuteFromSec(int sec) {
//        int hours = sec / 3600;
//        int minutes = (sec % 3600) / 60;
//        int seconds = sec % 60;
//        if (hours == 0) {
//            return String.format("%02d:%02d", minutes, seconds);
//        }
//        return String.format("%02d:%02d:%02d", hours, minutes, seconds);
//    }
}
