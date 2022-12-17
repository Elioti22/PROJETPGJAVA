package com.isep.rpg;

public abstract class SpellCaster extends Hero{

    public SpellCaster(String n, int hp, int mana) {
        super(n, 50);

        // Ajout d'objet pour regen les pv
        super.addItemToBesaceheros(new Potion(), 3);
        super.addItemToBesaceheros(new Potion(), 4);


    }
}
