package com.assignment.ideapro.yha.viewholders;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.assignment.ideapro.yha.delegates.ITedTalkDelegate;

public class NewsViewHolder extends RecyclerView.ViewHolder {

    private ITedTalkDelegate mDelegate;

    public NewsViewHolder(View itemView, ITedTalkDelegate delegate) {
        super(itemView);
        mDelegate = delegate;
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDelegate.onTapImage();
            }
        });
    }
}
