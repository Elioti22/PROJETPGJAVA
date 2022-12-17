package com.isep.rpg;

public class Dragon extends Enemy {

    private Weapon weapon = new Weapon("crache du feu", 5);

    public Dragon(String n, int hp) {
        super(n, hp);
    }

    @Override
    public void Pertepv1(int damage) {

    }

    @Override
    public void fight(Combatant combatant) {
        combatant.Pertepv(this.weapon.getDps());

    }


    public int getDamage() {
        return this.weapon.getDps();}
}
