package player.classes.behaviours;

import equipment.Familiar;
import equipment.Spell;

import java.util.ArrayList;

public interface Spellcaster {

    ArrayList<Spell> getSpellbook();
    int getMaxMana();
    int getCurrentMana();
    void loseMana(int amount);
    void gainMana(int amount);
    Familiar getFamiliar();


    void addSpellToSpellbook(Spell spell);
    void removeSpellFromSpellbook(Spell spell);
    void castSpell(Spell spell);

    void changeFamiliar(Familiar familiar);

}
