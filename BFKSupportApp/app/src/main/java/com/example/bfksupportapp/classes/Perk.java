package com.example.bfksupportapp.classes;

import java.util.ArrayList;

public class Perk extends DataEntry {
    public Perk(String name, String description, ArrayList<Stat> stats, String type, String neutrality) {
        super(name, description);
        this.stats = stats;
        this.type = type;
        this.neutrality = neutrality;
    }
    public Perk(String name, String description) {
        super(name, description);
        /* this.stats = stats;
        this.type = type;
        this.neutrality = neutrality; */
    }


    private String type;
    private String neutrality;
    private ArrayList<Stat> stats;


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
