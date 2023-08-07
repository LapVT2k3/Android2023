package com.lapvt.myapplication.buoi4;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.lapvt.myapplication.R;

import java.util.List;

public class SupportAdapter extends RecyclerView.Adapter<SupportAdapter.SupportViewHolder> {
    private List<Support> supportList = null;

    public SupportAdapter(List<Support> supportList) {
        this.supportList = supportList;
    }

    public List<Support> getSupportList() {
        return supportList;
    }

    public void setSupportList(List<Support> supportList) {
        this.supportList = supportList;
    }

    @NonNull
    @Override
    public SupportViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_support, parent, false);
        return new SupportViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SupportViewHolder holder, int position) {
        holder.setData(supportList.get(position));
    }

    @Override
    public int getItemCount() {
        return supportList != null ? supportList.size() : 0;
    }

    protected static class SupportViewHolder extends RecyclerView.ViewHolder {
        private final TextView tvSupport;

        public SupportViewHolder(@NonNull View itemView) {
            super(itemView);
            tvSupport = itemView.findViewById(R.id.tvSupport);
        }

        public void setData(Support support) {
            tvSupport.setText(support.getSupport());
        }
    }
}
