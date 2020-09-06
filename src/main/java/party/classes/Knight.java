package party.classes;

import equipment.Armour;
import equipment.Weapon;
import party.archetypes.Melee;

public class Knight extends Melee {

    public Knight(String name) {
        super(
                name,
                40,
                7,
                3,
                Weapon.SHORTSWORD,
                Armour.PLATE
        );
    }

    @Override
    public String toString() {
        return String.format("%s the Knight", getName());
    }

    @Override
    public void fight() {
        System.out.println("Knight is fighting");
    }

    @Override
    public void useAbility() {
        System.out.println("Knight uses their ability");
    }
}
