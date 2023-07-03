package com.example.bfksupportapp.classes;

import java.io.Serializable;
import java.util.ArrayList;

public class Item implements Serializable {

    private String name;
    private Material material;
    private ItemType itemType;
    private ArrayList<Effect> effects = new ArrayList<>();
    private static final long serialVersionUID = 42L;
}
