package party.archetypes;

import equipment.Armour;
import equipment.Familiar;
import equipment.Spell;
import equipment.Weapon;
import party.Player;

import java.util.ArrayList;

public abstract class Spellcaster extends Player {

    private ArrayList<Spell> spellbook;
    private int maxMana;
    private int currentMana;
    private Familiar familiar;

    public Spellcaster(
            String name,
            int maxHealth,
            int strength,
            int resistance,
            Weapon weapon,
            Armour armour,
            ArrayList<Spell> spellbook,
            int maxMana,
            Familiar familiar
    ) {
        super(name, maxHealth, strength, resistance, weapon, armour);
        this.spellbook = spellbook;
        this.maxMana = maxMana;
        this.currentMana = maxMana;
        this.familiar = familiar;
    }

    public ArrayList<Spell> getSpellbook() {
        return spellbook;
    }

    public int getMaxMana() {
        return maxMana;
    }

    public int getCurrentMana() {
        return currentMana;
    }

    public void loseMana(int amount) {
        currentMana -= amount;
        if (currentMana < 0) currentMana = 0;
    }

    public void gainMana(int amount) {
        currentMana += amount;
        if (currentMana > maxMana) currentMana = maxMana;
    }

    public Familiar getFamiliar() {
        return familiar;
    }


    public void changeFamiliar(Familiar familiar) {
        this.familiar = familiar;
    }

    public void addSpellToSpellbook(Spell spell) {
        if (!spellbook.contains(spell)) spellbook.add(spell);
    }

    public void removeSpellFromSpellbook(Spell spell) {
        spellbook.remove(spell);
    }

    public void castSpell(Spell spell) {
        if (!spellbook.contains(spell)) {
            System.out.println("I don't know that spell");
            return;
        }
        if (currentMana < spell.getManaCost()) {
            System.out.println("Not enough mana!");
            return;
        }
        loseMana(spell.getManaCost());
        System.out.println("I cast " + spell.getName());
    }



}
