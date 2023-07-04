package com.example.bfksupportapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Calculator extends AppCompatActivity {


    TextView result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        result = findViewById(R.id.CalNumOutput);
        if(getIntent().hasExtra("key")){
            String extra = getIntent().getExtras().getString("key");
            result.setText(extra);
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