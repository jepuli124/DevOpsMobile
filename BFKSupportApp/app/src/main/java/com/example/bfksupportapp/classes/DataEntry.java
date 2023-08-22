package com.example.bfksupportapp.classes;

import java.io.Serializable;

public class DataEntry implements Serializable {
    public DataEntry(String name, String description) {
        this.name = name;
        this.description = description;
    }

    protected String name;
    protected String description;

    protected static final long serialVersionUID = 42L;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
