package party.classes;

import equipment.Armour;
import equipment.Weapon;
import party.archetypes.Melee;

public class Dwarf extends Melee {

    public Dwarf(String name) {
        super(
                name,
                30,
                5,
                8,
                Weapon.AXE,
                Armour.CHAINMAIL
        );
    }

    @Override
    public String toString() {
        return String.format("%s the Dwarf", getName());
    }

    @Override
    public void fight() {
        System.out.println("Dwarf is fighting");
    }

    @Override
    public void useAbility() {
        System.out.println("Dwarf uses their ability");
    }
}
