package player.classes;

import equipment.Armour;
import equipment.Familiar;
import equipment.Spell;
import equipment.Weapon;
import player.Player;
import player.classes.behaviours.Spellcaster;

import java.util.ArrayList;
import java.util.Collections;

public class Warlock extends Player implements Spellcaster {

    private ArrayList<Spell> spellbook;
    private int maxMana;
    private int currentMana;
    private Familiar familiar;

    public Warlock() {
        super(
                20,
                0,
                0,
                Weapon.DAGGER,
                Armour.MAGE_ROBE
        );
        this.maxMana = 30;
        this.currentMana = maxMana;
        this.spellbook = new ArrayList<>(Collections.singletonList(Spell.ELDRITCH_BLAST));
        this.familiar = Familiar.IMP;
    }

    @Override
    public ArrayList<Spell> getSpellbook() {
        return spellbook;
    }

    @Override
    public int getMaxMana() {
        return maxMana;
    }

    @Override
    public int getCurrentMana() {
        return currentMana;
    }

    @Override
    public void loseMana(int amount) {
        currentMana -= amount;
        if (currentMana < 0) currentMana = 0;
    }

    @Override
    public void gainMana(int amount) {
        currentMana += amount;
        if (currentMana > maxMana) currentMana = maxMana;
    }

    @Override
    public Familiar getFamiliar() {
        return familiar;
    }

    @Override
    public void changeFamiliar(Familiar familiar) {
        this.familiar = familiar;
    }

    @Override
    public void addSpellToSpellbook(Spell spell) {
        if (!spellbook.contains(spell)) spellbook.add(spell);
    }

    @Override
    public void removeSpellFromSpellbook(Spell spell) {
        spellbook.remove(spell);
    }


    @Override
    public void castSpell(Spell spell) {
        if (!spellbook.contains(spell)) {
            System.out.println("Warlock doesn't know that spell");
            return;
        }
        if (currentMana < spell.getManaCost()) {
            System.out.println("Not enough mana!");
            return;
        }
        loseMana(spell.getManaCost());
        System.out.println("Warlock casts " + spell.getName());
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
