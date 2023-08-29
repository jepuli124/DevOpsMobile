package com.example.bfksupportapp.classes;

import java.util.ArrayList;

public class Character extends DataEntry {


    public Character(String name, String description, String history, String species, ArrayList<Stat> stats, ArrayList<Item> items, ArrayList<Perk> perks) {
        super(name, "Description:\n" + description + "\nHistory: \n" + history+ "\nSpecies: \n" + species );
        this.history = history;
        this.species = species;
        this.stats = stats;
        this.items = items;
        this.perks = perks;
    }

    public Character(String name, String description) {
        super(name, "Description: " + description);
        /*
        this.history = history;
        this.species = species;
        this.stats = stats;
        this.items = items;
        this.perks = perks;*/
    }

    public Character(){
        super("No Name", "NoDesc");
        /*
        this.history = history;
        this.species = species;
        this.stats = stats;
        this.items = items; */


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


    private String history;
    private String species;

    private ArrayList<Stat> stats = new ArrayList<>();
    private ArrayList<Item> items = new ArrayList<>();
    private ArrayList<Perk> perks = new ArrayList<>();

}
