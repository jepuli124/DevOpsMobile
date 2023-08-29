package com.example.bfksupportapp;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.bfksupportapp.classes.DataStorage;
import com.example.bfksupportapp.classes.EffectStorage;
import com.example.bfksupportapp.classes.ItemTypeStorage;
import com.example.bfksupportapp.classes.MaterialStorage;
import com.example.bfksupportapp.classes.NPCStorage;
import com.example.bfksupportapp.classes.PerkStorage;
import com.example.bfksupportapp.classes.PlayerStorage;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button mainToCal = findViewById(R.id.MainToCal);
        Button mainToStickBug = findViewById(R.id.MainStickBug);
        Button mainToDatabase = findViewById(R.id.MainDataBase);

        loadStorages(this);
        mainToCal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, CalculatorActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("key", "value");
                intent.putExtras(bundle);
                startActivity(intent);

            }
        });


        mainToStickBug.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = "https://www.youtube.com/watch?v=9BalEldzE8o";
                Uri stickBug = Uri.parse(url);
                try {  // Example from Bill Butterfield's video didn't work so I replaced it with try and catch I found from Stackoverflow: https://stackoverflow.com/questions/2201917/how-can-i-open-a-url-in-androids-web-browser-from-my-application
                    Intent intent = new Intent(Intent.ACTION_VIEW, stickBug);
                    startActivity(intent);
                } catch (ActivityNotFoundException e) {
                    Toast.makeText(view.getContext(), "No Correct App found", Toast.LENGTH_LONG).show();
                    e.printStackTrace();
                }

            }
        });

        mainToDatabase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, DataActivity.class);
                startActivity(intent);

            }
        });
    }

    public void loadStorages(Context context){
        DataStorage.getInstance().load(context);
        EffectStorage.getInstance().load(context);
        ItemTypeStorage.getInstance().load(context);
        MaterialStorage.getInstance().load(context);
        NPCStorage.getInstance().load(context);
        PerkStorage.getInstance().load(context);
        PlayerStorage.getInstance().load(context);

    }
}