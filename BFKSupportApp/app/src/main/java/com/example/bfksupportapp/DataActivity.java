package com.example.bfksupportapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class DataActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data);
        ImageView dataToMain = findViewById(R.id.dataToMain);
        Button dataToPlayerCharacters = findViewById(R.id.DataToPlayerCharacters);
        Button dataToNPC = findViewById(R.id.DataToNPC);
        Button dataToBestia = findViewById(R.id.DataToBestia);
        Button dataToHerba = findViewById(R.id.DataToHerba);
        Button dataToMorbus = findViewById(R.id.DataToMorbus);
        Button dataToInstrumenta = findViewById(R.id.DataToInstrumenta);
        Button dataToAttributum = findViewById(R.id.DataToAttributum);
        Button dataToMateria = findViewById(R.id.DataToMateria);
        Button dataToFabula = findViewById(R.id.DataToFabula);
        Button dataToNewEntry = findViewById(R.id.DataToNewEntry);
        Button dataToDeleteEntry = findViewById(R.id.DataToDeleteEntry);
        Button dataToOmni = findViewById(R.id.DataToOmni);


        dataToMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toMain(view);
            }
        });
        dataToPlayerCharacters.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putString("key", "Player Characters");
                toReadDataActivity(view, bundle);
            }
        });
        dataToNPC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putString("key", "NPC");
                toReadDataActivity(view, bundle);
            }
        });
        dataToBestia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putString("key", "Bestia");
                toReadDataActivity(view, bundle);
            }
        });
        dataToHerba.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putString("key", "Herba");
                toReadDataActivity(view, bundle);
            }
        });
        dataToMorbus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putString("key", "Morbus");
                toReadDataActivity(view, bundle);
            }
        });
        dataToInstrumenta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putString("key", "Instrumenta");
                toReadDataActivity(view, bundle);
            }
        });
        dataToAttributum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putString("key", "Attributum");
                toReadDataActivity(view, bundle);
            }
        });
        dataToMateria.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putString("key", "Materia");
                toReadDataActivity(view, bundle);
            }
        });
        dataToFabula.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putString("key", "Fabula");
                toReadDataActivity(view, bundle);
            }
        });
        dataToNewEntry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toWriteNewEntryActivity(view);
            }
        });
        dataToDeleteEntry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toMain(view);
            }
        });

        dataToOmni.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putString("key", "Omni");
                toReadDataActivity(view, bundle);
            }
        });

    }

    public void toReadDataActivity(View view, Bundle bundle){
        Intent intent = new Intent(DataActivity.this, ReadDataActivity.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }
    public void toReadDataActivity(View view){
        Intent intent = new Intent(DataActivity.this, ReadDataActivity.class);
        startActivity(intent);
    }

    public void toMain(View view){
        Intent intent = new Intent(DataActivity.this, MainActivity.class);
        startActivity(intent);
    }

    public void toWriteNewEntryActivity(View view){
        Intent intent = new Intent(DataActivity.this, WriteNewEntryActivity.class);
        startActivity(intent);
    }

}