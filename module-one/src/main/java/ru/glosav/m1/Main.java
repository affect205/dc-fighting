package ru.glosav.m1;

import ru.glosav.m1.zoo.AbstractZoo;
import ru.glosav.m1.zoo.Cat;
import ru.glosav.m1.zoo.Dog;
import ru.glosav.m2.weapon.IWeapon;
import ru.glosav.m2.weapon.WeaponSetFactory;
import ru.glosav.m2.zoo.IZoo;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by abalyshev on 11.04.17.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("D&C battle game begins!");
        WeaponSetFactory factory = new WeaponSetFactory();
        AbstractZoo[] fighters = new AbstractZoo[] {
                new Cat("Пушок", factory), new Dog("Люцифер", factory)
        };
        System.out.printf("Fighter #1: %s\n", fighters[0].toString());
        System.out.printf("Fighter #2: %s\n", fighters[1].toString());
        System.out.printf("%s [%s] vs %s [%s] Round 1:\n",
                fighters[0].getNickname(), fighters[0].getHealth(),
                fighters[1].getNickname(), fighters[1].getHealth()
        );
        while (!fighters[0].isDead() && !fighters[1].isDead()) {
            try {
                int fNdx = randInt(2);
                AbstractZoo attacks = fighters[fNdx];
                AbstractZoo defends = revert(fighters, fNdx);
                int wNdx = randInt(attacks.getWeaponSet().size());
                IWeapon weapon = attacks.getWeaponSet().get(wNdx);
                defends.reduceHealth(weapon.damage((IZoo)defends));
                System.out.printf("%s [%s] vs %s [%s] %s attacks with %s...\n",
                        attacks.getNickname(), attacks.getHealth(),
                        defends.getNickname(), defends.getHealth(),
                        attacks.getNickname(), weapon.getName()
                );
                Thread.sleep(1000);
            } catch (Exception e) {}
        }
        System.out.printf("Battle is finished! The winner is %s\n",
                getScore(fighters[0], fighters[1]));
    }

    public static int randInt(int bound) {
        return ThreadLocalRandom.current().nextInt(bound);
    }

    public static AbstractZoo revert(AbstractZoo[] fighters, int ndx) {
        return ndx == 0 ? fighters[1] : fighters[0];
    }

    public static String getScore(final AbstractZoo f1, final AbstractZoo f2) {
        if (f1.isDead() && f2.isDead()) return "Oh... here is no winner!";
        return f1.isDead() ? f2.getNickname() : f1.getNickname();
    }
}
