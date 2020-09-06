package party.classes;

import equipment.Armour;
import equipment.Weapon;
import party.archetypes.Melee;

public class Barbarian extends Melee {

    public Barbarian(String name) {
        super(
                name,
                50,
                10,
                5,
                Weapon.AXE,
                Armour.LEATHER_ARMOUR
        );
    }

    @Override
    public String toString() {
        return String.format("%s the Barbarian", getName());
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
