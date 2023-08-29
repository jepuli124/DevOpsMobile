package com.example.bfksupportapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.bfksupportapp.classes.Bestia;
import com.example.bfksupportapp.classes.DataStorage;
import com.example.bfksupportapp.classes.Effect;
import com.example.bfksupportapp.classes.EffectStorage;
import com.example.bfksupportapp.classes.Fabula;
import com.example.bfksupportapp.classes.Herba;
import com.example.bfksupportapp.classes.ItemType;
import com.example.bfksupportapp.classes.ItemTypeStorage;
import com.example.bfksupportapp.classes.Material;
import com.example.bfksupportapp.classes.MaterialStorage;
import com.example.bfksupportapp.classes.Morbus;
import com.example.bfksupportapp.classes.Perk;
import com.example.bfksupportapp.classes.PerkStorage;

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

                RadioGroup radioGroup = findViewById(R.id.WriteNewDataRadioGroup);
                /*
                RadioButton radioButtonPlayer = findViewById(R.id.WriteNewDataRadioPlayerCharacter);
                RadioButton radioButtonNPC = findViewById(R.id.WriteNewDataRadioNPC);
                RadioButton radioButtonBestia = findViewById(R.id.WriteNewDataRadioBestia);
                RadioButton radioButtonHerba = findViewById(R.id.WriteNewDataRadioHerba);
                RadioButton radioButtonMorbus = findViewById(R.id.WriteNewDataRadioMorbus);
                RadioButton radioButtonIntrumenta = findViewById(R.id.WriteNewDataRadioInstrumenta);
                RadioButton radioButtonAttributum = findViewById(R.id.WriteNewDataRadioAttributum);
                RadioButton radioButtonMateria = findViewById(R.id.WriteNewDataRadioMateria);
                RadioButton radioButtonFabula = findViewById(R.id.WriteNewDataRadioFabula);*/


                if(radioGroup.getCheckedRadioButtonId() == R.id.WriteNewDataRadioPlayerCharacter){
                    Toast.makeText(WriteNewEntryActivity.this, "Player", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(WriteNewEntryActivity.this, AddionalDataCharacterActivity.class);
                    intent.putExtra("type", "player");
                    if(entryName.getText().toString().length() < 1){
                        Toast.makeText(WriteNewEntryActivity.this, "Please add name", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    intent.putExtra("name", entryName.getText().toString());
                    intent.putExtra("desc", entryDesc.getText().toString());
                    startActivity(intent);

                } else if (radioGroup.getCheckedRadioButtonId() == R.id.WriteNewDataRadioNPC){
                    Toast.makeText(WriteNewEntryActivity.this, "NPC", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(WriteNewEntryActivity.this, AddionalDataCharacterActivity.class);
                    intent.putExtra("type", "NPC");
                    if(entryName.getText().toString().length() < 1){
                        Toast.makeText(WriteNewEntryActivity.this, "Please add name", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    intent.putExtra("name", entryName.getText().toString());
                    intent.putExtra("desc", entryDesc.getText().toString());
                    startActivity(intent);
                } else if (radioGroup.getCheckedRadioButtonId() == R.id.WriteNewDataRadioBestia){
                    Toast.makeText(WriteNewEntryActivity.this, "Bestia", Toast.LENGTH_SHORT).show();
                    DataStorage.getInstance().add(new Bestia(entryName.getText().toString(), entryDesc.getText().toString()), view.getContext());
                } else if (radioGroup.getCheckedRadioButtonId() == R.id.WriteNewDataRadioHerba){
                    Toast.makeText(WriteNewEntryActivity.this, "Herba", Toast.LENGTH_SHORT).show();
                    DataStorage.getInstance().add(new Herba(entryName.getText().toString(), entryDesc.getText().toString()), view.getContext());
                } else if (radioGroup.getCheckedRadioButtonId() == R.id.WriteNewDataRadioMorbus){
                    Toast.makeText(WriteNewEntryActivity.this, "Morbus", Toast.LENGTH_SHORT).show();
                    DataStorage.getInstance().add(new Morbus(entryName.getText().toString(), entryDesc.getText().toString()), view.getContext());
                } else if (radioGroup.getCheckedRadioButtonId() == R.id.WriteNewDataRadioInstrumenta){
                    Toast.makeText(WriteNewEntryActivity.this, "Instrumenta", Toast.LENGTH_SHORT).show();
                    ItemTypeStorage.getInstance().add(new ItemType(entryName.getText().toString(), entryDesc.getText().toString()), view.getContext());
                } else if (radioGroup.getCheckedRadioButtonId() == R.id.WriteNewDataRadioPerk){
                    Toast.makeText(WriteNewEntryActivity.this, "Attributum", Toast.LENGTH_SHORT).show();
                    PerkStorage.getInstance().add(new Perk(entryName.getText().toString(), entryDesc.getText().toString()), view.getContext());
                }   else if (radioGroup.getCheckedRadioButtonId() == R.id.WriteNewDataRadioEffect){
                    Toast.makeText(WriteNewEntryActivity.this, "Attributum", Toast.LENGTH_SHORT).show();
                    EffectStorage.getInstance().add(new Effect(entryName.getText().toString(), entryDesc.getText().toString()), view.getContext());
                } else if (radioGroup.getCheckedRadioButtonId() == R.id.WriteNewDataRadioMateria){
                    Toast.makeText(WriteNewEntryActivity.this, "Materia", Toast.LENGTH_SHORT).show();
                   MaterialStorage.getInstance().add(new Material(entryName.getText().toString(), entryDesc.getText().toString()), view.getContext());
                } else if (radioGroup.getCheckedRadioButtonId() == R.id.WriteNewDataRadioFabula){
                    Toast.makeText(WriteNewEntryActivity.this, "Fabula", Toast.LENGTH_SHORT).show();
                    DataStorage.getInstance().add(new Fabula(entryName.getText().toString(), entryDesc.getText().toString()), view.getContext());
                } else {
                    Toast.makeText(WriteNewEntryActivity.this, "Please select category", Toast.LENGTH_SHORT).show();
                    Toast.makeText(WriteNewEntryActivity.this, Integer.toString(radioGroup.getCheckedRadioButtonId()) , Toast.LENGTH_SHORT).show();
                    radioGroup.clearCheck();
                    return;
                }
                entryName.setText("");
                entryDesc.setText("");
                radioGroup.clearCheck();


            }
        });
    }
}