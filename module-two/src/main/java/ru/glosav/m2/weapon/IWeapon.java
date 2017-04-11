package ru.glosav.m2.weapon;


import ru.glosav.m2.zoo.IZoo;

/**
 * Created by abalyshev on 11.04.17.
 */
public interface IWeapon {
    int damage(IZoo enemy);
    String getName();
}
