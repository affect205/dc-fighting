package ru.glosav.m1.zoo;

import ru.glosav.m2.weapon.WeaponSetFactory;
import ru.glosav.m2.zoo.IZoo;

/**
 * Created by abalyshev on 11.04.17.
 */
public class Cat extends AbstractZoo implements IZoo {
    public Cat(String nickname, WeaponSetFactory weaponSetFactory) {
        super(nickname, 180, weaponSetFactory.catWeaponSet());
    }
    @Override
    public String getName() {
        return "Cat";
    }
}
