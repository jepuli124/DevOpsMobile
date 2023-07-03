package com.example.bfksupportapp.classes;

import android.content.Context;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Random;

public class PerkStorage {
    private PerkStorage() {

    }

    private static PerkStorage instance;

    public static PerkStorage getInstance() {
        if (instance == null){
            instance = new PerkStorage();
        }
        return instance;
    }

    private ArrayList<Perk> perks = new ArrayList<>();

    public void AddPerk(Perk perk, Context context){
        perks.add(perk);
        savePerks(context);
    }

    public Perk randomPerk(){
        Random value = new Random();
        return (perks.get(value.nextInt(perks.size())));
    }

    public Perk randomPerkByType(String type, String neutrality){
        Random value = new Random();
        ArrayList<Perk> perksByType = new ArrayList<>();
        for (Perk perk: perks) {
            if(perk.getType().equals(type) && perk.getNeutrality().equals(neutrality)){
                perksByType.add(perk);
            }
        }
        return (perksByType.get(value.nextInt(perksByType.size())));
    }

    public ArrayList<Perk> getPerks(){
        return perks;
    }

    public void savePerks(Context context){ //copied from far away more info in "learning dairy.docx".
        try {
            ObjectOutputStream OOS = new ObjectOutputStream(context.openFileOutput("Perks.data", Context.MODE_PRIVATE));
            OOS.writeObject(perks);
            OOS.close();
        } catch (IOException e) {
            Toast.makeText(context, "Saving Failed", Toast.LENGTH_SHORT).show();
        }
    }
    public void loadPerks(Context context){
        try {
            ObjectInputStream OIS = new ObjectInputStream(context.openFileInput("Perks.data"));
            perks = (ArrayList<Perk>) OIS.readObject();
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
