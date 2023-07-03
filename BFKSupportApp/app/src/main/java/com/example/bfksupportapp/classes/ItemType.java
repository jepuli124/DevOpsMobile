package com.example.bfksupportapp.classes;

import java.io.Serializable;
import java.util.ArrayList;

public class ItemType implements Serializable {
    public ItemType(String name, float damage, float defence, float weight, float hardness, int quality, float thaumaticPotential, ArrayList<Effect> effects) {
        this.name = name;
        this.damage = damage;
        this.defence = defence;
        this.weight = weight;
        this.hardness = hardness;
        this.effects = effects;

    }

    private final String name;
    private final float damage;
    private final float defence;
    private final float weight;
    private final float hardness;
    private final ArrayList<Effect> effects;

    private static final long serialVersionUID = 42L;

    public String getName() {
        return name;
    }

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
