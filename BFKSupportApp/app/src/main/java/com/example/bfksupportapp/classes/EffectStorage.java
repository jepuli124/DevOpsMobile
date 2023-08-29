package com.example.bfksupportapp.classes;

import android.content.Context;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class EffectStorage extends Storage{

    private static EffectStorage instance;

    public static EffectStorage getInstance() {
        if (instance == null){
            instance = new EffectStorage();
        }
        return instance;
    }

    private ArrayList<Effect> inventory = new ArrayList<>();

    public void add(Effect effect, Context context){
        inventory.add(effect);
        save(context);
    }

    public ArrayList<Effect> getInventory(){
        return inventory;
    }

    @Override
    public void save(Context context) {
        try {
            ObjectOutputStream OOS = new ObjectOutputStream(context.openFileOutput("Effect.data", Context.MODE_PRIVATE));
            OOS.writeObject(inventory);
            OOS.close();
        } catch (IOException e) {
            Toast.makeText(context, "Saving Failed", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void load(Context context) {
        try {
            ObjectInputStream OIS = new ObjectInputStream(context.openFileInput("Effect.data"));
            inventory = (ArrayList<Effect>) OIS.readObject();
            OIS.close();
        }catch (FileNotFoundException e1){
            //Toast.makeText(context, "No save file", Toast.LENGTH_SHORT).show();
        }catch(IOException e2) {
            Toast.makeText(context, "Something went wrong", Toast.LENGTH_SHORT).show();
        }catch(ClassNotFoundException e3) {
            Toast.makeText(context, "Class not found?", Toast.LENGTH_SHORT).show();
        }
    }
}
