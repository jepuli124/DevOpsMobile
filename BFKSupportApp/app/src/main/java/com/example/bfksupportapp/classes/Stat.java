package com.example.bfksupportapp.classes;

import java.io.Serializable;

public class Stat implements Serializable {

    public Stat(String name, int level, int xp, int maxLvl) {
        this.name = name;
        this.level = level;
        this.xp = xp;
        this.maxLvl = maxLvl;
    }

    private String name;
    private int level;
    private int xp;
    private int maxLvl;
    private final int XpToNextLvl = 5 * level;

    private static final long serialVersionUID = 42L;


    public String getName() {
        return name;
    }

    public int getLevel() {
        return level;
    }

    private void setLevel(int level) {
        this.level = level;
    }

    public int getXp() {
        return xp;
    }

    public void addXp(int xp) {
        this.xp = this.xp+xp;
        levelUp();
    }

    private void levelUp(){
        while(XpToNextLvl >= xp){
            if(level >= maxLvl){
                break;
            }
            xp = xp - XpToNextLvl;
            level += 1;
        }
    }

    public int getMaxLvl() {
        return maxLvl;
    }

    public int getXpToNextLvl() {
        return XpToNextLvl;
    }
}
