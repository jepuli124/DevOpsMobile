package com.example.bfksupportapp.classes;

import java.util.ArrayList;

public class ItemType extends DataEntry{
    public ItemType(String name, float damage, float defence, float weight, float hardness, int quality, float thaumaticPotential, ArrayList<Effect> effects) {
        super(name, "Damage:\n"+ damage + "\nDefence:\n" + defence + "\nWeight:\n" + weight + "\nHardness:\n" + hardness + "\nEffects:\n" + effects);
        this.damage = damage;
        this.defence = defence;
        this.weight = weight;
        this.hardness = hardness;
        this.effects = effects;

    }

    public ItemType(String name, String description) {
        super(name, description);
        /*this.damage = damage;
        this.defence = defence;
        this.weight = weight;
        this.hardness = hardness;
        this.effects = effects;*/

    }

    private float damage;
    private float defence;
    private float weight;
    private float hardness;
    private ArrayList<Effect> effects;


    public float getDamage() {
        return damage;
    }

    public float getDefence() {
        return defence;
    }

    public float getWeight() {
        return weight;
    }

    public float getHardness() {
        return hardness;
    }

    public ArrayList<Effect> getEffects() {
        return effects;
    }
}
