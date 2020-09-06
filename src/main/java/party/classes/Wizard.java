package party.classes;

import equipment.Armour;
import equipment.Familiar;
import equipment.Spell;
import equipment.Weapon;
import party.archetypes.Spellcaster;

import java.util.ArrayList;
import java.util.Collections;

public class Wizard extends Spellcaster {

    public Wizard(String name) {
        super(
                name,
                20,
                0,
                -2,
                Weapon.STAFF,
                Armour.MAGE_ROBE,
                new ArrayList<>(Collections.singletonList(Spell.MAGIC_MISSILE)),
                50,
                Familiar.OWL
        );

    }

    @Override
    public String toString() {
        return String.format("%s the Wizard", getName());
    }

    @Override
    public void fight() {
        System.out.println("Wizard tries to bop the enemy with their staff! It's not very effective...");
    }

    @Override
    public void useAbility() {
        System.out.println("Restore mana?");
    }
}
