package com.isep.rpg;
import java.util.Random;

public abstract class Enemy extends Combatant {


    public Enemy(String n, int hp) {
        super(n, 50, 10);
    }


    public abstract void Pertepv1(int damage);
}