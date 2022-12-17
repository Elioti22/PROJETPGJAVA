package com.isep.rpg;

public class Hunter extends Hero{

    private Weapon weapon = new Weapon("épée", 10);
    public Hunter(String n, int hp) {
        super(n, 50);
        this.name = n;
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
