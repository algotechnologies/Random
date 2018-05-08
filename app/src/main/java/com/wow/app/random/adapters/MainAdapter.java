package com.wow.app.random.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import com.wow.app.random.R;
import com.wow.app.random.holders.MainViewHolder;

public class MainAdapter extends RecyclerView.Adapter<MainViewHolder> {

    private List<String> dataArray;

    public MainAdapter( List<String> dataArray) {
        this.dataArray = dataArray;
    }

    @Override
    public MainViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_main, parent, false);
        return new MainViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MainViewHolder holder, int position) {
        holder.textRow.setText(dataArray.get(position));
    }

    @Override
    public int getItemCount() {
        return dataArray.size();
    }

}
