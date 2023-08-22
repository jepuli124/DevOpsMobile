package com.example.bfksupportapp.classes;

public class Stat extends DataEntry {

    public Stat(String name, int level, int xp, int maxLvl) {
        super(name, "Level:\n" + level + "\nXp:\n" + xp + "\nMaxLvl:\n" + maxLvl);
        this.level = level;
        this.xp = xp;
        this.maxLvl = maxLvl;
    }

    public Stat(String name, String description) {
        super(name, description);
        /*
        this.level = level;
        this.xp = xp;
        this.maxLvl = maxLvl; */
    }

    private int level;
    private int xp;
    private int maxLvl;
    private final int XpToNextLvl = 5 * level;

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
