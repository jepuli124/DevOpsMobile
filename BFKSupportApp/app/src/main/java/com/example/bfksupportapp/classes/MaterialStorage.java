package com.example.bfksupportapp.classes;

import android.content.Context;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class MaterialStorage extends Storage{

    private static MaterialStorage instance;

    public static MaterialStorage getInstance() {
        if (instance == null){
            instance = new MaterialStorage();
        }
        return instance;
    }

    private ArrayList<Material> inventory = new ArrayList<>();

    public void add(Material material, Context context){
        inventory.add(material);
        save(context);
    }

    public ArrayList<Material> getInventory(){
        return inventory;
    }

    @Override
    void save(Context context) {
        try {
            ObjectOutputStream OOS = new ObjectOutputStream(context.openFileOutput("Material.data", Context.MODE_PRIVATE));
            OOS.writeObject(inventory);
            OOS.close();
        } catch (IOException e) {
            Toast.makeText(context, "Saving Failed", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    void load(Context context) {
        try {
            ObjectInputStream OIS = new ObjectInputStream(context.openFileInput("Material.data"));
            inventory = (ArrayList<Material>) OIS.readObject();
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
