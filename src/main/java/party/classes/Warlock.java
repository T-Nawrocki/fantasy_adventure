package party.classes;

import equipment.Armour;
import equipment.Familiar;
import equipment.Spell;
import equipment.Weapon;
import party.archetypes.Spellcaster;

import java.util.ArrayList;
import java.util.Collections;

public class Warlock extends Spellcaster {

    public Warlock(String name) {
        super(
                name,
                20,
                0,
                0,
                Weapon.DAGGER,
                Armour.MAGE_ROBE,
                new ArrayList<>(Collections.singletonList(Spell.ELDRITCH_BLAST)),
                30,
                Familiar.IMP
        );
    }

    @Override
    public String toString() {
        return String.format("%s the Warlock", getName());
    }

    @Override
    public void fight() {
        System.out.println("Warlock tries to stab... it's not very effective");
    }

    @Override
    public void useAbility() {
        System.out.println("Maybe something like exchanging hp for mp");
    }
}
