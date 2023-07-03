package com.example.bfksupportapp.classes;

import java.io.Serializable;

public class Material implements Serializable {
    public Material(String name, float damage, float defence, float weight, float hardness, int quality, float thaumaticPotential) {
        this.name = name;
        this.damage = damage;
        this.defence = defence;
        this.weight = weight;
        this.hardness = hardness;
        this.quality = quality;
        this.thaumaticPotential = thaumaticPotential;
    }

    private final String name;
    private final float damage;
    private final float defence;
    private final float weight;
    private final float hardness;
    private final int quality;
    private final float thaumaticPotential;

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

    public int getQuality(){
        return quality;
    }

    public float getThaumaticPotential() {
        return thaumaticPotential;
    }
}
