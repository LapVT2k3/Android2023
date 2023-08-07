package com.lapvt.myapplication.recyclerviewb1;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.lapvt.myapplication.R;

import java.util.List;

public class GroupAdapter extends RecyclerView.Adapter<GroupAdapter.GroupViewHolder> {

    private List<Group> listGroup = null;

    private OnItemClick onItemClick;

    public void setOnItemClick(OnItemClick onItemClick) {
        this.onItemClick = onItemClick;
    }

    public GroupAdapter(List<Group> listGroup) {
        this.listGroup = listGroup;
    }

    public List<Group> getListGroup() {
        return listGroup;
    }

    public void setListGroup(List<Group> listGroup) {
        this.listGroup = listGroup;
    }

    @NonNull
    @Override
    public GroupViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_group, parent, false);
        return new GroupViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GroupViewHolder holder, int position) {
        holder.setData(listGroup.get(position));

        holder.tvNameGroup.setOnClickListener(view -> {
            onItemClick.clickNameGroup(listGroup.get(position).getName());
        });

        holder.tvNumOfFans.setOnClickListener(view -> {
            onItemClick.clickNumberOfFans(listGroup.get(position).getNumOfFans() + "");
        });

        holder.tvNumOfLatestPosts.setOnClickListener(view -> {
            onItemClick.clickNumberOfLatestPosts(listGroup.get(position).getNumOfLatestPosts() + "");
        });

        holder.tvStatus.setOnClickListener(view -> {
            onItemClick.clickStatus(listGroup.get(position).getStatus());
        });

        holder.itemView.setOnClickListener(view -> {
            onItemClick.clickItem();
        });
    }

    @Override
    public int getItemCount() {
        return listGroup != null ? listGroup.size() : 0;
    }

    protected class GroupViewHolder extends RecyclerView.ViewHolder {
        private ImageView imvImage;
        private TextView tvNameGroup;
        private TextView tvNumOfFans;
        private TextView tvNumOfLatestPosts;
        private TextView tvStatus;

        public GroupViewHolder(@NonNull View itemView) {
            super(itemView);
            imvImage = itemView.findViewById(R.id.imvImage);
            tvNameGroup = itemView.findViewById(R.id.tvNameGroup);
            tvNumOfFans = itemView.findViewById(R.id.tvNumOfFans);
            tvNumOfLatestPosts = itemView.findViewById(R.id.tvNumOfLatestPosts);
            tvStatus = itemView.findViewById(R.id.tvStatus);
        }

        public void setData(Group group) {
            imvImage.setImageBitmap(group.getBitmap());
            tvNameGroup.setText(group.getName());
            tvNumOfFans.setText(group.getNumOfFans() + "K Fan");
            tvNumOfLatestPosts.setText("+" + group.getNumOfLatestPosts() + " bài viết mới nhất");
            tvStatus.setText(group.getStatus());
            if (group.getStatus().equals("NHÓM ĐÓNG")) {
                tvStatus.setTextColor(Color.parseColor("#8E8E8E"));
            } else if (group.getStatus().equals("NHÓM KÍN")) {
                tvStatus.setTextColor(Color.parseColor("#FF9500"));
            } else if (group.getStatus().equals("NHÓM MỞ")) {
                tvStatus.setTextColor(Color.parseColor("#1F9FFC"));
            }
        }
    }

    interface OnItemClick {
        void clickNameGroup(String nameGroup);
        void clickNumberOfFans(String numberOfFans);
        void clickNumberOfLatestPosts(String numberOfLatestPosts);
        void clickStatus(String status);
        void clickItem();
    }
}
