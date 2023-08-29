package com.example.bfksupportapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.bfksupportapp.classes.Character;
import com.example.bfksupportapp.classes.Item;
import com.example.bfksupportapp.classes.NPCStorage;
import com.example.bfksupportapp.classes.Perk;
import com.example.bfksupportapp.classes.PlayerStorage;
import com.example.bfksupportapp.classes.Stat;

import java.util.ArrayList;

public class AddionalDataCharacterActivity extends AppCompatActivity {

    String type;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addional_data_character);
        Bundle bundle;
        if(getIntent().hasExtra("type")){
            bundle = getIntent().getExtras();
            type = bundle.getString("type");

            if(getIntent().hasExtra("name")) {
                TextView name = findViewById(R.id.AddionalDataCharName);
                name.setText(bundle.getString("name"));
            }
            if(getIntent().hasExtra("desc")) {
                TextView desc = findViewById(R.id.AddionalDataCharDesc);
                desc.setText(bundle.getString("desc"));
            }
        } else {
            Intent intent = new Intent(AddionalDataCharacterActivity.this, DataActivity.class);
            startActivity(intent);
        }


        Button finish = findViewById(R.id.AddionalDataFinish);

        finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView name = findViewById(R.id.AddionalDataCharName);
                TextView desc = findViewById(R.id.AddionalDataCharDesc);
                TextView history = findViewById(R.id.AddionalDataCharHistory);
                TextView species = findViewById(R.id.AddionalDataCharSpecies);
                if(type.equals("player")){
                    PlayerStorage.getInstance().add(new Character(name.getText().toString(), desc.getText().toString(), history.getText().toString(), species.getText().toString(), new ArrayList<Stat>(), new ArrayList<Item>(), new ArrayList<Perk>() ), view.getContext());
                } else if (type.equals("NPC")){
                    NPCStorage.getInstance().add(new Character(name.getText().toString(), desc.getText().toString(), history.getText().toString(), species.getText().toString(), new ArrayList<Stat>(), new ArrayList<Item>(), new ArrayList<Perk>() ), view.getContext());
                }
                Intent intent = new Intent(AddionalDataCharacterActivity.this, DataActivity.class);
                startActivity(intent);
            }
        });
    }
}