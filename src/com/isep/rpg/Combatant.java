package com.isep.rpg;

public abstract class Combatant {

    String name;
    private int pointsvie;
    private Weapon weapon;
    int mana;

    public Combatant(String n, int hp, int mana) {
        this.name = n;
        this.pointsvie = hp;
        this.mana = mana;
    }

    public void Pertepv(int damage) {
        this.pointsvie = this.pointsvie - damage;
    }

    public abstract void Pertepv1(int damage);

    // Classe abstraite
    public abstract void fight(Combatant combatant);
    public abstract int getDamage();


    // Accesseurs GET
    public String getName() {
        return this.name;}

    public int getPointsvie() {
        return this.pointsvie;}

    public int getMana() {
        return this.mana;
    }

    public void addMana(int n){
        this.mana =+ n;
    }

    public void win(int hpp) {

        this.pointsvie = 6 + pointsvie;
    }
    public void def(int pointsvie) {

        this.pointsvie = 2 + pointsvie;
    }
    public void consu(int pointsvie) {

        this.pointsvie = 5 + pointsvie;
    }



    public void Damage(int n)
    {
        this.pointsvie -= n;
        if(this.pointsvie <= 0)
        {
            int rest = 0 - this.pointsvie;
            this.pointsvie = 0;
            this.pointsvie -= rest;
            if(this.pointsvie <= 0)
            {
                this.pointsvie = 0;

            }
        }
    }


}
