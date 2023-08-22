package com.example.bfksupportapp.classes;

import java.util.ArrayList;

public class Item extends DataEntry{

    public Item(String name, Material material, ItemType itemType, ArrayList<Effect> effects){
        super(name, "Material: " + material + "\nItem type: " + itemType + "\nEffects: " + effects);
        this.material = material;
        this.itemType = itemType;
        this.effects = effects;
    }

    public Item(String name, String description){
        super(name, description);
        /*
        this.material = material;
        this.itemType = itemType;
        this.effects = effects;*/
    }
    private Material material;
    private ItemType itemType;
    private ArrayList<Effect> effects = new ArrayList<>();

}
