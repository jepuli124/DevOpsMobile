package com.example.bfksupportapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class CalculatorActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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
                Intent intent = new Intent(CalculatorActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
        calAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculateHitAndDamage(view);
            }
        });

    }



    public void calculateHitAndDamage(View view){
        TextView Hit = findViewById(R.id.CalHitOutput);
        TextView DMG = findViewById(R.id.CalDmgOutput);
        TextView inputSTR = findViewById(R.id.CalNumInputSTR);
        TextView inputWS = findViewById(R.id.CalNumInputWeaponSkill);
        TextView inputSPD = findViewById(R.id.CalNumInputSPD);
        TextView inputWeaponDMG = findViewById(R.id.CalNumInputWeaponDMGMult);
        TextView inputEnemySPD = findViewById(R.id.CalNumInputEnemySpeed);
        TextView inputEnemyArmor = findViewById(R.id.CalNumInputEnemyArmor);
        Switch autoHitSwitch = findViewById(R.id.CalAutohitSwitch);

        if(inputSTR.getText().length() == 0){
            inputSTR.setText("0");
        }
        if(inputWS.getText().length() == 0){
            inputWS.setText("0");
        }
        if(inputSPD.getText().length() == 0){
            inputSPD.setText("0");
        }
        if(inputWeaponDMG.getText().length() == 0){
            inputEnemyArmor.setText("0.1");
        }
        if(inputEnemySPD.getText().length() == 0){
            inputEnemySPD.setText("0");
        }
        if(inputEnemyArmor.getText().length() == 0){
            inputEnemyArmor.setText("0");
        }
        int D20;
        if(autoHitSwitch.isChecked()){
            D20 = 20;
        } else {
            Random random = new Random();
            D20 = random.nextInt(21);
        }

        int calculatedHit = Integer.parseInt(inputWS.getText().toString()) + Integer.parseInt(inputSPD.getText().toString()) + D20 - Integer.parseInt(inputEnemySPD.getText().toString());

        if(calculatedHit < 1) {
            Hit.setText("MISS!");
            return;
        }
        Hit.setText("HIT! by value of: " + Integer.toString(calculatedHit));

        float calculatedDamage = Float.parseFloat(inputWeaponDMG.getText().toString()) * (Integer.parseInt(inputWS.getText().toString()) + Integer.parseInt(inputSTR.getText().toString()) + calculatedHit) - Integer.parseInt(inputEnemyArmor.getText().toString());

        if(calculatedDamage < 1) {
            DMG.setText("NO DAMAGE!");
            return;
        }
        DMG.setText("DAMAGE DONE: " + ((int) calculatedDamage));


    }




}