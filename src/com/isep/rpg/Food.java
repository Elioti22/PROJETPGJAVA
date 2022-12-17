package com.isep.rpg;

// Regen les points de vie
public class Food extends Consumable{


    private int gaindepv = 10;

    public Food(String name) {
        super(name);
    }

    public Food() {
        super("Potion");
    }


    public int getGaindepv() {
        return this.gaindepv;}
}
