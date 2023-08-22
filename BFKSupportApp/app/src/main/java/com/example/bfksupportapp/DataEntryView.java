package com.example.bfksupportapp;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class DataEntryView extends RecyclerView.ViewHolder {
    TextView name, desc;

    public DataEntryView(@NonNull View itemView) {
        super(itemView);
        name = itemView.findViewById(R.id.DataEntryViewName);
        desc = itemView.findViewById(R.id.DataEntryViewDesc);

    }

}