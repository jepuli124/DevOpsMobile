package com.example.bfksupportapp.classes;

import java.io.Serializable;
import java.util.ArrayList;

public class Character implements Serializable {


    public Character(String name, String description, String history, String species, ArrayList<Stat> stats, ArrayList<Item> items, ArrayList<Perk> perks) {
        this.name = name;
        this.description = description;
        this.history = history;
        this.species = species;
        this.stats = stats;
        this.items = items;
        this.perks = perks;
    }

    public Character(){
        this.name = name;
        this.description = description;
        this.history = history;
        this.species = species;
        this.stats = stats;
        this.items = items;


        this.perks.add(PerkStorage.getInstance().randomPerkByType("physical", "positive"));
        this.perks.add(PerkStorage.getInstance().randomPerkByType("physical", "negative"));
        this.perks.add(PerkStorage.getInstance().randomPerkByType("spiritual", "positive"));
        this.perks.add(PerkStorage.getInstance().randomPerkByType("spiritual", "negative"));
        this.perks.add(PerkStorage.getInstance().randomPerkByType("skill", "positive"));
        this.perks.add(PerkStorage.getInstance().randomPerkByType("skill", "negative"));
        this.perks.add(PerkStorage.getInstance().randomPerkByType("thaumatic", "positive"));
        this.perks.add(PerkStorage.getInstance().randomPerkByType("thaumatic", "negative"));
        this.perks.add(PerkStorage.getInstance().randomPerkByType("characteristic", "positive"));
        this.perks.add(PerkStorage.getInstance().randomPerkByType("characteristic", "negative"));


    }

    private String name;
    private String description;
    private String history;
    private String species;

    private ArrayList<Stat> stats = new ArrayList<>();
    private ArrayList<Item> items = new ArrayList<>();
    private ArrayList<Perk> perks = new ArrayList<>();
    private static final long serialVersionUID = 42L;
}
