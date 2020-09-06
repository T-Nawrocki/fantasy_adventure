package party.classes;

import equipment.Armour;
import equipment.Familiar;
import equipment.Spell;
import equipment.Weapon;
import org.junit.Before;
import org.junit.Test;
import party.classes.Warlock;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import static org.junit.Assert.assertEquals;

public class WarlockTest {

    private Warlock warlock;

    @Before
    public void before() {
        warlock = new Warlock("Percy");
    }

    @Test
    public void hasName() {
        assertEquals("Percy", warlock.getName());
    }

    @Test
    public void canConvertToString() {
        assertEquals("Percy the Warlock", warlock.toString());
    }

    @Test
    public void hasMaxHealth() {
        assertEquals(20, warlock.getMaxHealth());
    }

    @Test
    public void hasCurrentHealth() {
        assertEquals(20, warlock.getCurrentHealth());
    }

    @Test
    public void hasStrength() {
        assertEquals(0, warlock.getStrength());
    }

    @Test
    public void hasResistance() {
        assertEquals(0, warlock.getResistance());
    }

    @Test
    public void hasWeapon() {
        assertEquals(Weapon.DAGGER, warlock.getWeapon());
    }

    @Test
    public void hasArmour() {
        assertEquals(Armour.MAGE_ROBE, warlock.getArmour());
    }

    @Test
    public void hasLoot() {
        assertEquals(0, warlock.getLoot());
    }

    @Test
    public void canChangeWeapon() {
        warlock.changeWeapon(Weapon.MAGIC_SWORD);
        assertEquals(Weapon.MAGIC_SWORD, warlock.getWeapon());
    }

    @Test
    public void canChangeArmour() {
        warlock.changeArmour(Armour.MAGIC_ARMOUR);
        assertEquals(Armour.MAGIC_ARMOUR, warlock.getArmour());
    }

    @Test
    public void canLoseHealth() {
        warlock.loseHealth(1);
        assertEquals(19, warlock.getCurrentHealth());
    }

    @Test
    public void cannotGoBelow0Health() {
        warlock.loseHealth(100000);
        assertEquals(0, warlock.getCurrentHealth());
    }

    @Test
    public void canGainHealth() {
        warlock.loseHealth(10);
        warlock.gainHealth(1);
        assertEquals(11, warlock.getCurrentHealth());
    }

    @Test
    public void cannotGoAboveMaxHealth() {
        warlock.gainHealth(1);
        assertEquals(20, warlock.getCurrentHealth());
    }

    @Test
    public void canCollectLoot() {
        warlock.collectLoot(10);
        assertEquals(10, warlock.getLoot());
    }


    @Test
    public void canFight() {
        System.out.println("==========");
        System.out.println("Warlock attempting to fight...");
        warlock.fight();
    }

    @Test
    public void canUseAbility() {
        System.out.println("==========");
        System.out.println("Warlock attempting to use ability...");
        warlock.useAbility();
    }

    @Test
    public void hasSpellbook() {
        assertEquals(
                new ArrayList<>(Collections.singletonList(Spell.ELDRITCH_BLAST)),
                warlock.getSpellbook()
        );
    }

    @Test
    public void hasMaxMana() {
        assertEquals(30, warlock.getMaxMana());
    }

    @Test
    public void hasCurrentMana() {
        assertEquals(30, warlock.getCurrentMana());
    }

    @Test
    public void hasFamiliar() {
        assertEquals(Familiar.IMP, warlock.getFamiliar());
    }

    @Test
    public void canLoseMana() {
        warlock.loseMana(5);
        assertEquals(25, warlock.getCurrentMana());
    }

    @Test
    public void cannotGoBelow0Mana() {
        warlock.loseMana(10000);
        assertEquals(0, warlock.getCurrentMana());
    }

    @Test
    public void canGainMana() {
        warlock.loseMana(10);
        warlock.gainMana(5);
        assertEquals(25, warlock.getCurrentMana());
    }

    @Test
    public void cannotGoAboveMaxMana() {
        warlock.gainMana(1);
        assertEquals(30, warlock.getCurrentMana());
    }

    @Test
    public void canChangeFamiliar() {
        warlock.changeFamiliar(Familiar.DEMON);
        assertEquals(Familiar.DEMON, warlock.getFamiliar());
    }

    @Test
    public void canAddSpellToSpellbook() {
        warlock.addSpellToSpellbook(Spell.ACID_SPLASH);
        assertEquals(
                new ArrayList<>(Arrays.asList(Spell.ELDRITCH_BLAST, Spell.ACID_SPLASH)),
                warlock.getSpellbook()
        );
    }

    @Test
    public void cannotSameSpellToSpellbookTwice() {
        warlock.addSpellToSpellbook(Spell.ELDRITCH_BLAST);
        assertEquals(
                new ArrayList<>(Collections.singletonList(Spell.ELDRITCH_BLAST)),
                warlock.getSpellbook()
        );
    }

    @Test
    public void canRemoveSpellFromSpellbook() {
        warlock.removeSpellFromSpellbook(Spell.ELDRITCH_BLAST);
        assertEquals(
                new ArrayList<Spell>(),
                warlock.getSpellbook()
        );
    }

    @Test
    public void canCastSpell() {
        System.out.println("==========");
        System.out.println("Warlock attempting to cast spell...");
        warlock.castSpell(Spell.ELDRITCH_BLAST);
        assertEquals(28, warlock.getCurrentMana());
    }

    @Test
    public void cannotCastUnknownSpell() {
        System.out.println("==========");
        System.out.println("Warlock attempting to cast spell...");
        warlock.castSpell(Spell.FIREBALL);
        assertEquals(30, warlock.getCurrentMana());
    }

    @Test
    public void cannotCastSpellWithoutEnoughMana() {
        warlock.loseMana(29);
        System.out.println("==========");
        System.out.println("Warlock attempting to cast spell...");
        warlock.castSpell(Spell.ELDRITCH_BLAST);
        assertEquals(1, warlock.getCurrentMana());
    }

}
