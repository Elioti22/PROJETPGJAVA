package com.isep.rpg;

public class Warrior extends Hero{


    private Weapon weapon = new Weapon("sabre", 10);

    public Warrior(String n, int hp) {
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
