package com.isep.rpg;

public class BOSS extends Enemy {

    private Weapon weapon = new Weapon("force surdimensionnée", 10);
    private int pvv;

    public BOSS(String name, int pvv) {
        super("Boss final !!", 100);
    }


    @Override
    public void Pertepv1(int damage) {
        this.pvv = this.pvv - damage;
    }

    @Override
    public void fight(Combatant combatant) {

    }

    public void win(int hpp) {

        this.pvv = 6 + pvv;
    }



    public int getDamage() {
        return this.weapon.getDps();}


}


