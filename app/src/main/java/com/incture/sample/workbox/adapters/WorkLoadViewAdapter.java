package com.incture.sample.workbox.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.incture.sample.workbox.R;
import com.incture.sample.workbox.models.UserWorkLoad;

import java.util.List;

/**
 * Created by satiswardash on 24/11/17.
 */

public class WorkLoadViewAdapter extends RecyclerView.Adapter<WorkLoadViewAdapter.ViewHolder> {

    Context mContext;
    List<UserWorkLoad> mDataList;

    public WorkLoadViewAdapter(Context mContext, List<UserWorkLoad> mDataList) {
        this.mContext = mContext;
        this.mDataList = mDataList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(mContext).inflate(R.layout.list_item_layout, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.bind(position);
    }

    @Override
    public int getItemCount() {
        return mDataList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView taskNoTextView;
        TextView userNameTextView;
        TextView userGroupTextView;

        public ViewHolder(View itemView) {
            super(itemView);
            taskNoTextView = itemView.findViewById(R.id.tasknumber_textView);
            userNameTextView = itemView.findViewById(R.id.userName_textView);
            userGroupTextView = itemView.findViewById(R.id.userGroup_textView);
        }

        public void bind(int position) {

            UserWorkLoad dataItem = mDataList.get(position);

            taskNoTextView.setText(dataItem.getNoOfTasks()+"");
            userNameTextView.setText(dataItem.getUserName());

            if (dataItem.getUserGroup().contains("Everyone")){
                userGroupTextView.setText(R.string.user_group_everyone);
            }
        }
    }
}
