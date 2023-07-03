package com.example.bfksupportapp.classes;

import java.io.Serializable;
import java.util.ArrayList;

public class Perk implements Serializable {
    public Perk(String name, String description, ArrayList<Stat> stats, String type, String neutrality) {
        this.name = name;
        this.description = description;
        this.stats = stats;
        this.type = type;
        this.neutrality = neutrality;
    }

    private final String name;
    private final String description;
    private final String type;
    private final String neutrality;
    private final ArrayList<Stat> stats;

    private static final long serialVersionUID = 42L;

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public ArrayList<Stat> getStats() {
        return stats;
    }

    public String getType() {
        return type;
    }

    public String getNeutrality() {
        return neutrality;
    }
}
