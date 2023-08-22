package com.example.bfksupportapp.classes;

public class Material extends DataEntry {
    public Material(String name, float damage, float defence, float weight, float hardness, int quality, float thaumaticPotential) {
        super(name, "Damage:\n"+ damage + "\nDefence:\n" + defence + "\nWeight:\n" + weight + "\nHardness:\n" + hardness + "\nQuality:\n" + quality + "\nThaumatic potential:\n" + thaumaticPotential);
        this.damage = damage;
        this.defence = defence;
        this.weight = weight;
        this.hardness = hardness;
        this.quality = quality;
        this.thaumaticPotential = thaumaticPotential;
    }

    public Material(String name, String description) {
        super(name, description);
        /*
        this.damage = damage;
        this.defence = defence;
        this.weight = weight;
        this.hardness = hardness;
        this.quality = quality;
        this.thaumaticPotential = thaumaticPotential; */
    }

    private float damage;
    private float defence;
    private float weight;
    private float hardness;
    private int quality;
    private float thaumaticPotential;


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
