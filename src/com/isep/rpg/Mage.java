package com.isep.rpg;

public class Mage extends SpellCaster {

    private Weapon weapon = new Weapon("magie", 10);

    public Mage(String n, int hp, int mana) {
        super(n, 50, 10);
        this.name = name;
        this.mana = 10;
    }

    @Override
    public void Pertepv1(int damage) {

    }

    @Override
    public void fight(Combatant combatant) {
        combatant.Pertepv(this.weapon.getDps());
    }

    public void addMana(int n)
    {
        this.mana += n;
    }

    public int getMana()
    {
        return this.mana;
    }

    public int getDamage() {
        return this.weapon.getDps();}
}
