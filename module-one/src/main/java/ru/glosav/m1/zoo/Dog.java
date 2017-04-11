package ru.glosav.m1.zoo;


import ru.glosav.m2.weapon.WeaponSetFactory;
import ru.glosav.m2.zoo.IZoo;

/**
 * Created by abalyshev on 11.04.17.
 */
public class Dog extends AbstractZoo implements IZoo {
    public Dog(String nickname, WeaponSetFactory weaponSetFactory) {
        super(nickname, 220, weaponSetFactory.dogWeaponSet());
    }
    @Override
    public String getName() {
        return "Dog";
    }
}
