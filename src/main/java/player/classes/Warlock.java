package player.classes;

import equipment.Armour;
import equipment.Familiar;
import equipment.Spell;
import equipment.Weapon;
import player.Player;
import player.archetypes.Spellcaster;

import java.util.ArrayList;
import java.util.Collections;

public class Warlock extends Spellcaster {



    public Warlock() {
        super(
                20,
                0,
                0,
                Weapon.DAGGER,
                Armour.MAGE_ROBE,
                new ArrayList<Spell>(Collections.singletonList(Spell.ELDRITCH_BLAST)),
                30,
                Familiar.IMP
        );
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
