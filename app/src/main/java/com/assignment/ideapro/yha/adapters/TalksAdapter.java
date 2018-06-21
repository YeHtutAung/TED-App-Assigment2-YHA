package com.assignment.ideapro.yha.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.assignment.ideapro.yha.R;
import com.assignment.ideapro.yha.data.data.vos.TalksVO;
import com.assignment.ideapro.yha.delegates.ITedTalkDelegate;
import com.assignment.ideapro.yha.viewholders.TalksViewHolder;
import java.util.ArrayList;
import java.util.List;

public class TalksAdapter extends RecyclerView.Adapter<TalksViewHolder> {
    private ITedTalkDelegate mDelegate;
    private List<TalksVO> mTalkList;

    public TalksAdapter(ITedTalkDelegate tedDelegate) {
        mDelegate = tedDelegate;
        this.mTalkList = new ArrayList<>();
    }

    @Override
    public TalksViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.view_holder_talks, parent, false);

        return new TalksViewHolder(view, mDelegate);
    }

    @Override
    public void onBindViewHolder(TalksViewHolder holder, int position) {
        holder.setmTalk(mTalkList.get(position));
    }

    @Override
    public int getItemCount() {
        return mTalkList.size();
    }

    public void setTalkList(List<TalksVO> mTalkList) {
        this.mTalkList = mTalkList;
        notifyDataSetChanged();
    }
}
