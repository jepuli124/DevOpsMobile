package com.example.bfksupportapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bfksupportapp.classes.Bestia;
import com.example.bfksupportapp.classes.DataEntry;
import com.example.bfksupportapp.classes.DataStorage;
import com.example.bfksupportapp.classes.Herba;
import com.example.bfksupportapp.classes.Morbus;

import java.util.ArrayList;
import java.util.Objects;

public class ReadDataActivity extends AppCompatActivity {


    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read_data);
        ImageView returnImg = findViewById(R.id.ReadDataReturn);
        if(getIntent().hasExtra("key")){
            Bundle bundle = getIntent().getExtras();
            String extra = bundle.getString("key");
            Toast.makeText(this, extra, Toast.LENGTH_SHORT).show();
            if(Objects.equals(extra, "Player Characters")){
                recyclerView = findViewById(R.id.ReadDataRecycleView);
                recyclerView.setLayoutManager(new LinearLayoutManager(this));
                recyclerView.setAdapter(new DataEntryAdapter(getApplicationContext(), DataStorage.getInstance().getInventory()));
            } else if (Objects.equals(extra, "NPC:s")) {
                recyclerView = findViewById(R.id.ReadDataRecycleView);
                recyclerView.setLayoutManager(new LinearLayoutManager(this));
                recyclerView.setAdapter(new DataEntryAdapter(getApplicationContext(), DataStorage.getInstance().getInventory()));
            } else if (Objects.equals(extra, "Bestia")) {
                ArrayList<DataEntry> bestiaEntries = new ArrayList<>();
                for (DataEntry entry: DataStorage.getInstance().getInventory()) {
                    if(entry instanceof Bestia){
                        bestiaEntries.add(entry);
                    }
                }

                recyclerView = findViewById(R.id.ReadDataRecycleView);
                recyclerView.setLayoutManager(new LinearLayoutManager(this));
                recyclerView.setAdapter(new DataEntryAdapter(getApplicationContext(), bestiaEntries));
            } else if (Objects.equals(extra, "Herba")) {
                ArrayList<DataEntry> herbaEntries = new ArrayList<>();
                for (DataEntry entry: DataStorage.getInstance().getInventory()) {
                    if(entry instanceof Herba){
                        herbaEntries.add(entry);
                    }
                }
                recyclerView = findViewById(R.id.ReadDataRecycleView);
                recyclerView.setLayoutManager(new LinearLayoutManager(this));
                recyclerView.setAdapter(new DataEntryAdapter(getApplicationContext(), herbaEntries));
            } else if (Objects.equals(extra, "Morbus")) {
                ArrayList<DataEntry> morbusEntries = new ArrayList<>();
                for (DataEntry entry: DataStorage.getInstance().getInventory()) {
                    if(entry instanceof Morbus){
                        morbusEntries.add(entry);
                    }
                }
                recyclerView = findViewById(R.id.ReadDataRecycleView);
                recyclerView.setLayoutManager(new LinearLayoutManager(this));
                recyclerView.setAdapter(new DataEntryAdapter(getApplicationContext(), morbusEntries));
            } else if (Objects.equals(extra, "Instrumenta")) {
                recyclerView = findViewById(R.id.ReadDataRecycleView);
                recyclerView.setLayoutManager(new LinearLayoutManager(this));
                recyclerView.setAdapter(new DataEntryAdapter(getApplicationContext(), DataStorage.getInstance().getInventory()));
            } else if (Objects.equals(extra, "Attributum")) {
                recyclerView = findViewById(R.id.ReadDataRecycleView);
                recyclerView.setLayoutManager(new LinearLayoutManager(this));
                recyclerView.setAdapter(new DataEntryAdapter(getApplicationContext(), DataStorage.getInstance().getInventory()));
            } else if (Objects.equals(extra, "Materia")) {
                recyclerView = findViewById(R.id.ReadDataRecycleView);
                recyclerView.setLayoutManager(new LinearLayoutManager(this));
                recyclerView.setAdapter(new DataEntryAdapter(getApplicationContext(), DataStorage.getInstance().getInventory()));
            } else if (Objects.equals(extra, "Fabula")) {
                recyclerView = findViewById(R.id.ReadDataRecycleView);
                recyclerView.setLayoutManager(new LinearLayoutManager(this));
                recyclerView.setAdapter(new DataEntryAdapter(getApplicationContext(), DataStorage.getInstance().getInventory()));
            } else {
                recyclerView = findViewById(R.id.ReadDataRecycleView);
                recyclerView.setLayoutManager(new LinearLayoutManager(this));
                recyclerView.setAdapter(new DataEntryAdapter(getApplicationContext(), DataStorage.getInstance().getInventory()));
            }


        } else {
            recyclerView = findViewById(R.id.ReadDataRecycleView);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
            recyclerView.setAdapter(new DataEntryAdapter(getApplicationContext(), DataStorage.getInstance().getInventory()));
        }

        returnImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                Intent intent = new Intent(ReadDataActivity.this, DataActivity.class);
                startActivity(intent);
            }
        });
    }


}