package ru.glosav.m2.weapon;

import ru.glosav.m2.zoo.IZoo;

import java.util.Arrays;
import java.util.List;

/**
 * Created by abalyshev on 11.04.17.
 */
public class WeaponSetFactory {
    public List<IWeapon> dogWeaponSet() {
        return Arrays.asList(createBarkWeapon(), createStingWeapon());
    }
    public List<IWeapon> catWeaponSet() {
        return Arrays.asList(createScratchingWeapon(), createDoubleMeowingWeapon());
    }

    protected IWeapon createBarkWeapon() { return new BarkWeapon(); }
    protected IWeapon createStingWeapon() { return new StingWeapon(); }
    protected IWeapon createScratchingWeapon() { return new ScratchingWeapon(); }
    protected IWeapon createDoubleMeowingWeapon() { return new DoubleMeowingWeapon(); }

    protected class BarkWeapon implements IWeapon {
        @Override public int damage(IZoo enemy) {
            if ("dog".equalsIgnoreCase(enemy.getName())) {
                return 20;
            }
            return 25;
        }
        @Override public String getName() {
            return "bark";
        }
    }

    protected class StingWeapon implements IWeapon {
        @Override public int damage(IZoo enemy) {
            if ("dog".equalsIgnoreCase(enemy.getName())) {
                return 30;
            }
            return 40;
        }
        @Override public String getName() {
            return "sting";
        }
    }

    protected class ScratchingWeapon implements IWeapon {
        @Override public int damage(IZoo enemy) {
            if ("cat".equalsIgnoreCase(enemy.getName())) {
                return 20;
            }
            return 35;
        }
        @Override public String getName() {
            return "scratching";
        }
    }

    protected class DoubleMeowingWeapon implements IWeapon {
        @Override public int damage(IZoo enemy) {
            if ("cat".equalsIgnoreCase(enemy.getName())) {
                return 0;
            }
            return 35;
        }
        @Override public String getName() {
            return "double meowing";
        }
    }
}
