package com.assignment.ideapro.yha.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.assignment.ideapro.yha.R;
import com.assignment.ideapro.yha.data.data.vos.TalksVO;
import com.assignment.ideapro.yha.viewholders.WatchNextViewHolder;

public class WatchNextAdapter extends RecyclerView.Adapter<WatchNextViewHolder> {

    private TalksVO mTalkVO;

    public WatchNextAdapter(TalksVO talk) {
        this.mTalkVO = talk;
    }
    @NonNull
    @Override
    public WatchNextViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.view_holder_watch_next_talks, parent, false);
        return new WatchNextViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull WatchNextViewHolder holder, int position) {
        holder.setData(mTalkVO, mTalkVO.getTags().get(position));
    }


    @Override
    public int getItemCount() {
        return mTalkVO.getTags().size();
    }
}
