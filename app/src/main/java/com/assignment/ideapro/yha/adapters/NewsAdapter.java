package com.assignment.ideapro.yha.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.assignment.ideapro.yha.R;
import com.assignment.ideapro.yha.delegates.ITedTalkDelegate;
import com.assignment.ideapro.yha.viewholders.NewsViewHolder;

public class NewsAdapter extends RecyclerView.Adapter {
    private ITedTalkDelegate mDelegate;

    public NewsAdapter(ITedTalkDelegate tedDelegate) {
        mDelegate = tedDelegate;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {


        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.activity_newslist, parent, false);

        return new NewsViewHolder(view, mDelegate);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 15;
    }
}
