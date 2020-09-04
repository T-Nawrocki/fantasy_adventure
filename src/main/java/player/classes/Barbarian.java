package player.classes;

import equipment.Armour;
import equipment.Weapon;
import player.archetypes.Melee;

public class Barbarian extends Melee {

    public Barbarian() {
        super(
                50,
                10,
                5,
                Weapon.AXE,
                Armour.LEATHER_ARMOUR
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
