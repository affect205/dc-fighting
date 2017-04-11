package ru.glosav.m1.zoo;

import ru.glosav.m2.weapon.IWeapon;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * Created by abalyshev on 11.04.17.
 */
public abstract class AbstractZoo {
    protected String nickname;
    protected int health;
    protected List<IWeapon> weaponSet;
    protected boolean dead;
    public AbstractZoo(String nickname, int health, List<IWeapon> weaponSet) {
        this.nickname = nickname;
        this.health = health;
        this.weaponSet = weaponSet;
    }
    public String getNickname() { return nickname; }
    public int getHealth() { return health; }
    public void reduceHealth(int value) {
        health -= value;
        if (health <= 0) {
            health = 0;
            dead = true;
        }
    }
    public boolean isDead() { return dead; }
    public List<IWeapon> getWeaponSet() { return weaponSet; }

    @Override
    public String toString() {
        return "AbstractZoo{" +
                "nickname='" + nickname + '\'' +
                ", health=" + health +
                ", weaponSet=[" + weaponSet.stream().map(IWeapon::getName).collect(Collectors.joining(",")) +
                "]}";
    }
}
