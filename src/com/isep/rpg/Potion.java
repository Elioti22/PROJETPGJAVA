package com.isep.rpg;

// regen les points de magie
public class Potion extends Consumable{

    private int ptspotion = 5;

    public Potion(String name) {
        super(name);
    }

    public Potion() {
        super("POTION1");
    }

    public int getPtspotion() {
        return this.ptspotion;}
}
