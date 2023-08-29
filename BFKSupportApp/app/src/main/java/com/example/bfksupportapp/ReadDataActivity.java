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
import com.example.bfksupportapp.classes.EffectStorage;
import com.example.bfksupportapp.classes.Fabula;
import com.example.bfksupportapp.classes.Herba;
import com.example.bfksupportapp.classes.ItemTypeStorage;
import com.example.bfksupportapp.classes.MaterialStorage;
import com.example.bfksupportapp.classes.Morbus;
import com.example.bfksupportapp.classes.NPCStorage;
import com.example.bfksupportapp.classes.PerkStorage;
import com.example.bfksupportapp.classes.PlayerStorage;

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

                ArrayList<DataEntry> playerEntries = new ArrayList<>();
                for (DataEntry entry: PlayerStorage.getInstance().getInventory()) {
                    playerEntries.add((DataEntry) entry);
                }
                recyclerView = findViewById(R.id.ReadDataRecycleView);
                recyclerView.setLayoutManager(new LinearLayoutManager(this));
                recyclerView.setAdapter(new DataEntryAdapter(getApplicationContext(), playerEntries));

            } else if (Objects.equals(extra, "NPC")) {

                ArrayList<DataEntry> NPCEntries = new ArrayList<>();
                for (DataEntry entry: NPCStorage.getInstance().getInventory()) {
                    NPCEntries.add((DataEntry) entry);
                }
                recyclerView = findViewById(R.id.ReadDataRecycleView);
                recyclerView.setLayoutManager(new LinearLayoutManager(this));
                recyclerView.setAdapter(new DataEntryAdapter(getApplicationContext(), NPCEntries));

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

                ArrayList<DataEntry> itemTypeEntries = new ArrayList<>();
                for (DataEntry entry: ItemTypeStorage.getInstance().getInventory()) {
                    itemTypeEntries.add((DataEntry) entry);
                }

                recyclerView = findViewById(R.id.ReadDataRecycleView);
                recyclerView.setLayoutManager(new LinearLayoutManager(this));
                recyclerView.setAdapter(new DataEntryAdapter(getApplicationContext(),itemTypeEntries));

            } else if (Objects.equals(extra, "Attributum")) {

                ArrayList<DataEntry> attributumEntries = new ArrayList<>();
                for (DataEntry entry: PerkStorage.getInstance().getInventory()) {
                    attributumEntries.add((DataEntry) entry);
                }
                for (DataEntry entry: EffectStorage.getInstance().getInventory()) {
                    attributumEntries.add((DataEntry) entry);
                }

                recyclerView = findViewById(R.id.ReadDataRecycleView);
                recyclerView.setLayoutManager(new LinearLayoutManager(this));
                recyclerView.setAdapter(new DataEntryAdapter(getApplicationContext(), attributumEntries));

            } else if (Objects.equals(extra, "Materia")) {

                ArrayList<DataEntry> materiaEntries = new ArrayList<>();
                for (DataEntry entry: MaterialStorage.getInstance().getInventory()) {
                    materiaEntries.add((DataEntry) entry);
                }
                recyclerView = findViewById(R.id.ReadDataRecycleView);
                recyclerView.setLayoutManager(new LinearLayoutManager(this));
                recyclerView.setAdapter(new DataEntryAdapter(getApplicationContext(), materiaEntries));

            } else if (Objects.equals(extra, "Fabula")) {

                ArrayList<DataEntry> fabulaEntries = new ArrayList<>();
                for (DataEntry entry: DataStorage.getInstance().getInventory()) {
                    if(entry instanceof Fabula){
                        fabulaEntries.add(entry);
                    }
                }
                recyclerView = findViewById(R.id.ReadDataRecycleView);
                recyclerView.setLayoutManager(new LinearLayoutManager(this));
                recyclerView.setAdapter(new DataEntryAdapter(getApplicationContext(), fabulaEntries));

            } else if (Objects.equals(extra, "Omni")) {

                ArrayList<DataEntry> OmniEntries = new ArrayList<>();
                for (DataEntry entry: PlayerStorage.getInstance().getInventory()) {
                    OmniEntries.add((DataEntry) entry);
                }
                for (DataEntry entry: NPCStorage.getInstance().getInventory()) {
                    OmniEntries.add((DataEntry) entry);
                }
                for (DataEntry entry: DataStorage.getInstance().getInventory()) {
                    if(entry instanceof Bestia){
                        OmniEntries.add(entry);
                    }
                }
                for (DataEntry entry: DataStorage.getInstance().getInventory()) {
                    if(entry instanceof Herba){
                        OmniEntries.add(entry);
                    }
                }
                for (DataEntry entry: DataStorage.getInstance().getInventory()) {
                    if(entry instanceof Morbus){
                        OmniEntries.add(entry);
                    }
                }
                for (DataEntry entry: ItemTypeStorage.getInstance().getInventory()) {
                    OmniEntries.add((DataEntry) entry);
                }
                for (DataEntry entry: PerkStorage.getInstance().getInventory()) {
                    OmniEntries.add((DataEntry) entry);
                }
                for (DataEntry entry: EffectStorage.getInstance().getInventory()) {
                    OmniEntries.add((DataEntry) entry);
                }
                for (DataEntry entry: MaterialStorage.getInstance().getInventory()) {
                    OmniEntries.add((DataEntry) entry);
                }
                for (DataEntry entry: DataStorage.getInstance().getInventory()) {
                    if(entry instanceof Fabula){
                        OmniEntries.add(entry);
                    }
                }

                recyclerView = findViewById(R.id.ReadDataRecycleView);
                recyclerView.setLayoutManager(new LinearLayoutManager(this));
                recyclerView.setAdapter(new DataEntryAdapter(getApplicationContext(), OmniEntries));

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