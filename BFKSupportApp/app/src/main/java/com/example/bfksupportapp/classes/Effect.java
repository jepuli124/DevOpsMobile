package com.example.bfksupportapp.classes;

public class Effect extends DataEntry {

    public Effect(String name, int tier) {
        super(name, "");
        this.name = name;
        this.tier = tier;
    }

    public Effect(String name, String description) {
        super(name, "");
        this.name = name;
        this.tier = 1;
    }

    private final String name;
    private final int tier;

    public int getTier() {
        return tier;
    }
}
