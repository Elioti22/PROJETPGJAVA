package com.isep.rpg;

public abstract class Hero extends Combatant {

    // Creation du sac d'objet
    private Item[] besacecombant = new Item[5];


    public Hero(String n, int hp) {
        super(n, 50,10);

        // Ajout d'objet pour regen les pv
        this.addItemToBesaceheros(new Food(), 0);
        this.addItemToBesaceheros(new Food(), 1);
        this.addItemToBesaceheros(new Food(), 2);
    }

    public Item[] getBesacecombant() {
        return this.besacecombant;}

    public void addItemToBesaceheros(Item i, int placement) {
        this.besacecombant[placement] = i;}


}
