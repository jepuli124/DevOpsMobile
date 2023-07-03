package com.example.bfksupportapp.classes;

import android.content.Context;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public abstract class Storage {
    public Storage(){}

    private ArrayList<Object> inventory;

    public void add(Object object, Context context){
        inventory.add(object);
        save(context);
    }

    public ArrayList<Object> getInventory(){
        return inventory;
    }

    public void save(Context context) {
        try {
            ObjectOutputStream OOS = new ObjectOutputStream(context.openFileOutput("players.data", Context.MODE_PRIVATE));
            OOS.writeObject(inventory);
            OOS.close();
        } catch (IOException e) {
            Toast.makeText(context, "Saving Failed", Toast.LENGTH_SHORT).show();
        }
    }
    public void load(Context context) {
        try {
            ObjectInputStream OIS = new ObjectInputStream(context.openFileInput("players.data"));
            inventory = (ArrayList<Object>) OIS.readObject();
            OIS.close();
        } catch (FileNotFoundException e1) {
            //Toast.makeText(context, "No save file", Toast.LENGTH_SHORT).show();
        } catch (IOException e2) {
            Toast.makeText(context, "Something went wrong", Toast.LENGTH_SHORT).show();
        } catch (ClassNotFoundException e3) {
            Toast.makeText(context, "Class not found?", Toast.LENGTH_SHORT).show();
        }
    }

}
