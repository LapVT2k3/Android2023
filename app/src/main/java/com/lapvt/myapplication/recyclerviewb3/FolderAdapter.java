package com.lapvt.myapplication.recyclerviewb3;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.lapvt.myapplication.R;

import java.util.List;

public class FolderAdapter extends RecyclerView.Adapter<FolderAdapter.FolderViewHolder> {
    private List<Folder> folderList = null;
    private OnItemClick onItemClick;

    public FolderAdapter(List<Folder> folderList) {
        this.folderList = folderList;
    }

    public List<Folder> getFolderList() {
        return folderList;
    }

    public void setFolderList(List<Folder> folderList) {
        this.folderList = folderList;
    }

    public void setOnItemClick(OnItemClick onItemClick) {
        this.onItemClick = onItemClick;
    }

    @NonNull
    @Override
    public FolderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_folder, parent, false);
        return new FolderViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FolderViewHolder holder, int position) {
        holder.setData(folderList.get(position));

        holder.tvFolderName.setOnClickListener(view -> {
            onItemClick.clickName(folderList.get(position).getNameFolder());
        });

        holder.itemView.setOnClickListener(view -> {
            onItemClick.clickItem();
        });
    }

    @Override
    public int getItemCount() {
        return folderList != null ? folderList.size() : 0;
    }

    protected class FolderViewHolder extends RecyclerView.ViewHolder {
        private TextView tvFolderName;

        public FolderViewHolder(@NonNull View itemView) {
            super(itemView);
            tvFolderName = itemView.findViewById(R.id.tvFolderName);
        }

        public void setData(Folder folder) {
            tvFolderName.setText(folder.getNameFolder());
        }
    }

    interface OnItemClick {
        void clickName(String folderName);

        void clickItem();
    }
}
