package com.example.bfksupportapp.classes;

import android.content.Context;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Random;

public class PerkStorage extends Storage{
    private PerkStorage() {

    }

    private static PerkStorage instance;

    public static PerkStorage getInstance() {
        if (instance == null){
            instance = new PerkStorage();
        }
        return instance;
    }

    private ArrayList<Perk> inventory = new ArrayList<>();

    public void add(Perk perk, Context context){
        inventory.add(perk);
        save(context);
    }

    public Perk randomPerk(){
        Random value = new Random();
        return (inventory.get(value.nextInt(inventory.size())));
    }

    public Perk randomPerkByType(String type, String neutrality){
        Random value = new Random();
        ArrayList<Perk> perksByType = new ArrayList<>();
        for (Perk perk: inventory) {
            if(perk.getType().equals(type) && perk.getNeutrality().equals(neutrality)){
                perksByType.add(perk);
            }
        }
        return (perksByType.get(value.nextInt(perksByType.size())));
    }

    public ArrayList<Perk> getInventory(){
        return inventory;
    }


    @Override
    void save(Context context) {
        try {
            ObjectOutputStream OOS = new ObjectOutputStream(context.openFileOutput("Perks.data", Context.MODE_PRIVATE));
            OOS.writeObject(inventory);
            OOS.close();
        } catch (IOException e) {
            Toast.makeText(context, "Saving Failed", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    void load(Context context) {
        try {
            ObjectInputStream OIS = new ObjectInputStream(context.openFileInput("Perks.data"));
            inventory = (ArrayList<Perk>) OIS.readObject();
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
