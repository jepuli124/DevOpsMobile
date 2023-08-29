package com.example.bfksupportapp.classes;

import android.content.Context;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class ItemTypeStorage extends Storage {

    private static ItemTypeStorage instance;

    public static ItemTypeStorage getInstance() {
        if (instance == null){
            instance = new ItemTypeStorage();
        }
        return instance;
    }

    private ArrayList<ItemType> inventory = new ArrayList<>();

    public void add(ItemType itemType, Context context){
        inventory.add(itemType);
        save(context);
    }

    public ArrayList<ItemType> getInventory(){
        return inventory;
    }

    @Override
    public void save(Context context) {
        try {
            ObjectOutputStream OOS = new ObjectOutputStream(context.openFileOutput("ItemType.data", Context.MODE_PRIVATE));
            OOS.writeObject(inventory);
            OOS.close();
        } catch (IOException e) {
            Toast.makeText(context, "Saving Failed", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void load(Context context) {
        try {
            ObjectInputStream OIS = new ObjectInputStream(context.openFileInput("ItemType.data"));
            inventory = (ArrayList<ItemType>) OIS.readObject();
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
