package com.example.bfksupportapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.bfksupportapp.classes.DataEntry;
import com.example.bfksupportapp.classes.DataStorage;

public class WriteNewEntryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write_new_entry);

        ImageView returnImg = findViewById(R.id.WriteNewEntryReturn);

        Button entryAdd = findViewById(R.id.WriteNewEntryAdd);
        returnImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                Intent intent = new Intent(WriteNewEntryActivity.this, DataActivity.class);
                startActivity(intent);
            }
        });

        entryAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                TextView entryName = findViewById(R.id.WriteNewEntryName);
                TextView entryDesc = findViewById(R.id.WriteNewEntryDesc);
                DataStorage.getInstance().add(new DataEntry(entryName.getText().toString(), entryDesc.getText().toString()), view.getContext());
            }
        });
    }
}