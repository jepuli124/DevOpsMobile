package com.example.bfksupportapp.classes;

import android.content.Context;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class DataStorage extends Storage{

    private DataStorage() {

    }

    private static DataStorage instance;
    private ArrayList<DataEntry> entries = new ArrayList<>();

    public static DataStorage getInstance() {
        if (instance == null){
            instance = new DataStorage();
        }
        return instance;
    }

    public void add(DataEntry dataEntry, Context context) {
        entries.add(dataEntry);
        save(context);
    }

    public ArrayList<DataEntry> getInventory(){
        return entries;
    }

    @Override
    void save(Context context) {
        try {
            ObjectOutputStream OOS = new ObjectOutputStream(context.openFileOutput("dataEntries.data", Context.MODE_PRIVATE));
            OOS.writeObject(entries);
            OOS.close();
        } catch (IOException e) {
            Toast.makeText(context, "Saving Failed", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    void load(Context context) {
        try {
            ObjectInputStream OIS = new ObjectInputStream(context.openFileInput("dataEntries.data"));
            entries = (ArrayList<DataEntry>) OIS.readObject();
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
