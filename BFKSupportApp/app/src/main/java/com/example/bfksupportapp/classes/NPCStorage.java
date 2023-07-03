package com.example.bfksupportapp.classes;

import android.content.Context;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;


public class NPCStorage {
    private NPCStorage() {

    }

    private static NPCStorage instance;

    public static NPCStorage getInstance() {
        if (instance == null){
            instance = new NPCStorage();
        }
        return instance;
    }

    private ArrayList<Character> NPCs = new ArrayList<>();

    public void addNPC(Character character, Context context){
        NPCs.add(character);
        saveNPCs(context);
    }


    public ArrayList<Character> getNPCs(){
        return NPCs;
    }

    public void saveNPCs(Context context){
        try {
            ObjectOutputStream OOS = new ObjectOutputStream(context.openFileOutput("NPCs.data", Context.MODE_PRIVATE));
            OOS.writeObject(NPCs);
            OOS.close();
        } catch (IOException e) {
            Toast.makeText(context, "Saving Failed", Toast.LENGTH_SHORT).show();
        }
    }
    public void loadNPCs(Context context){
        try {
            ObjectInputStream OIS = new ObjectInputStream(context.openFileInput("NPCs.data"));
            NPCs = (ArrayList<Character>) OIS.readObject();
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
