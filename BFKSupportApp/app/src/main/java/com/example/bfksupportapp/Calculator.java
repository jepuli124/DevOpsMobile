package com.example.bfksupportapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Calculator extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TextView result = findViewById(R.id.CalNumOutput);
        if(getIntent().hasExtra("key")){
            Bundle bundle = getIntent().getExtras();
            String extra = bundle.getString("key");
            Toast.makeText(this, extra, Toast.LENGTH_SHORT).show(); //reads output of bundle.
        }
        setContentView(R.layout.activity_calculator);
        Button calBack = findViewById(R.id.CalBack);
        Button calAdd = findViewById(R.id.CalAdd);
        calBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Calculator.this, MainActivity.class);
                startActivity(intent);
            }
        });
        calAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calAdd(view);
            }
        });

    }

    public void calAdd(View view){
        TextView result = findViewById(R.id.CalNumOutput);
        TextView input1 = findViewById(R.id.calNumInput1);
        TextView input2 = findViewById(R.id.CalNumInput2);
        if(input1.getText().length() == 0){
            input1.setText("0");
        }
        if(input2.getText().length() == 0){
            input2.setText("0");
        }
        result.setText((Integer.parseInt(input1.getText().toString()) + Integer.parseInt(input2.getText().toString()))+"");
    }
}