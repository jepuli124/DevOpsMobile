package com.example.bfksupportapp.classes;

import java.io.Serializable;

public class Effect implements Serializable {

    public Effect(String name, int tier) {
        this.name = name;
        this.tier = tier;
    }

    private final String name;
    private final int tier;
    private static final long serialVersionUID = 42L;

    public String getName() {
        return name;
    }

    public int getTier() {
        return tier;
    }
}
