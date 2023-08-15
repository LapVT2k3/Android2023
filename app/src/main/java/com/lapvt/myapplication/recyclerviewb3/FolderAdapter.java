package com.lapvt.myapplication.recyclerviewb3;

import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.lapvt.myapplication.R;

import java.util.List;

public class FolderAdapter extends RecyclerView.Adapter<FolderAdapter.FolderViewHolder> {
    private List<Folder> folderList = null;
    private OnItemClick onItemClick;
    private int focusedItemPosition = RecyclerView.NO_POSITION;

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

    public void setFocusedItemPosition(int focusedItemPosition) {
        this.focusedItemPosition = focusedItemPosition;
        notifyDataSetChanged();
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
            this.setFocusedItemPosition(position);
        });

        if (position == focusedItemPosition) {
            holder.edtFolderName.requestFocus();
        } else {
            holder.edtFolderName.clearFocus();
        }

        holder.imbFix.setOnClickListener(view -> {
            holder.edtFolderName.setText(folderList.get(position).getNameFolder());
            holder.edtFolderName.setVisibility(View.VISIBLE);
            holder.tvFolderName.setVisibility(View.GONE);
            holder.edtFolderName.requestFocus();
        });

        holder.edtFolderName.setOnFocusChangeListener((view, b) -> {
            if (!b) {
                String newName = holder.edtFolderName.getText().toString();
                holder.tvFolderName.setText(newName);
                holder.edtFolderName.setVisibility(View.GONE);
                holder.tvFolderName.setVisibility(View.VISIBLE);
                folderList.get(position).setNameFolder(newName);
            }
        });

        holder.imbDelete.setOnClickListener(view -> {
            onItemClick.clickDelete(position);
        });

        holder.itemView.setOnClickListener(view -> {
            this.setFocusedItemPosition(position);
        });
    }

    @Override
    public int getItemCount() {
        return folderList != null ? folderList.size() : 0;
    }

    protected class FolderViewHolder extends RecyclerView.ViewHolder {
        private final TextView tvFolderName;
        private final ImageButton imbFix;
        private final ImageButton imbDelete;
        private final EditText edtFolderName;
        public FolderViewHolder(@NonNull View itemView) {
            super(itemView);
            tvFolderName = itemView.findViewById(R.id.tvFolderName);
            imbFix = itemView.findViewById(R.id.imbFix);
            imbDelete = itemView.findViewById(R.id.imbDelete);
            edtFolderName = itemView.findViewById(R.id.edtFolderName);
        }

        public void setData(Folder folder) {
            tvFolderName.setText(folder.getNameFolder());
        }
    }

    interface OnItemClick {
        void clickName(String folderName);
        void clickDelete(int position);
    }
}
