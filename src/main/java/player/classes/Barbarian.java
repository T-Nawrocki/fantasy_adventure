package player.classes;

import equipment.Armour;
import equipment.Weapon;
import player.Player;

public class Barbarian extends Player {

    public Barbarian() {
        super(
                50,
                10,
                5,
                new Weapon("axe"),
                new Armour("leather")
        );
    }

    @Override
    public void fight() {
        System.out.println("Barbarian smash");
    }

    @Override
    public void useAbility() {
        System.out.println("Rar, I'm a barbarian");
    }
}
