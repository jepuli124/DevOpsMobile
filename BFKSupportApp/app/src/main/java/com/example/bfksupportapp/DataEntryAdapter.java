package com.example.bfksupportapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bfksupportapp.classes.DataEntry;
import com.example.bfksupportapp.classes.DataStorage;

import java.util.ArrayList;

public class DataEntryAdapter extends RecyclerView.Adapter<DataEntryView> {

    private Context context;
    private ArrayList<DataEntry> entries = new ArrayList<DataEntry>();
    public DataEntryAdapter(Context context) {
        this.context = context;
        this.entries = DataStorage.getInstance().getInventory();
    }

    @NonNull
    @Override
    public DataEntryView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new DataEntryView(LayoutInflater.from(context).inflate(R.layout.activity_data_entry_view, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull DataEntryView holder, int position) {
        if(entries.get(position).getName() != null){
            holder.name.setText(entries.get(position).getName());
        }
        if(entries.get(position).getDescription() != null){
            holder.desc.setText(entries.get(position).getDescription());
        }

    }

    @Override
    public int getItemCount() {
        return entries.size();
    }
}