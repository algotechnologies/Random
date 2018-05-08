package com.wow.app.random.holders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.wow.app.random.R;

public class MainViewHolder extends RecyclerView.ViewHolder {

    public TextView textRow;

    public MainViewHolder(View view) {
        super(view);
        textRow = (TextView) view.findViewById(R.id.text_row);
    }

}