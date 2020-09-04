package player;

import equipment.Armour;
import equipment.Familiar;
import equipment.Spell;
import equipment.Weapon;
import org.junit.Before;
import org.junit.Test;
import player.classes.Wizard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import static org.junit.Assert.assertEquals;

public class WizardTest {

    private Wizard wizard;

    @Before
    public void before() {
        wizard = new Wizard();
    }

    @Test
    public void hasMaxHealth() {
        assertEquals(20, wizard.getMaxHealth());
    }

    @Test
    public void hasCurrentHealth() {
        assertEquals(20, wizard.getCurrentHealth());
    }

    @Test
    public void hasStrength() {
        assertEquals(0, wizard.getStrength());
    }

    @Test
    public void hasResistance() {
        assertEquals(-2, wizard.getResistance());
    }

    @Test
    public void hasWeapon() {
        assertEquals(Weapon.STAFF, wizard.getWeapon());
    }

    @Test
    public void hasArmour() {
        assertEquals(Armour.MAGE_ROBE, wizard.getArmour());
    }

    @Test
    public void hasLoot() {
        assertEquals(0, wizard.getLoot());
    }

    @Test
    public void canChangeWeapon() {
        wizard.changeWeapon(Weapon.MAGIC_SWORD);
        assertEquals(Weapon.MAGIC_SWORD, wizard.getWeapon());
    }

    @Test
    public void canChangeArmour() {
        wizard.changeArmour(Armour.MAGIC_ARMOUR);
        assertEquals(Armour.MAGIC_ARMOUR, wizard.getArmour());
    }

    @Test
    public void canLoseHealth() {
        wizard.loseHealth(1);
        assertEquals(19, wizard.getCurrentHealth());
    }

    @Test
    public void cannotGoBelow0Health() {
        wizard.loseHealth(100000);
        assertEquals(0, wizard.getCurrentHealth());
    }

    @Test
    public void canGainHealth() {
        wizard.loseHealth(10);
        wizard.gainHealth(1);
        assertEquals(11, wizard.getCurrentHealth());
    }

    @Test
    public void cannotGoAboveMaxHealth() {
        wizard.gainHealth(1);
        assertEquals(20, wizard.getCurrentHealth());
    }

    @Test
    public void canCollectLoot() {
        wizard.collectLoot(10);
        assertEquals(10, wizard.getLoot());
    }


    @Test
    public void canFight() {
        System.out.println("==========");
        System.out.println("Wizard attempting to fight...");
        wizard.fight();
    }

    @Test
    public void canUseAbility() {
        System.out.println("==========");
        System.out.println("Wizard attempting to use ability...");
        wizard.useAbility();
    }

    @Test
    public void hasSpellbook() {
        assertEquals(
                new ArrayList<>(Collections.singletonList(Spell.MAGIC_MISSILE)),
                wizard.getSpellbook()
        );
    }

    @Test
    public void hasMaxMana() {
        assertEquals(50, wizard.getMaxMana());
    }

    @Test
    public void hasCurrentMana() {
        assertEquals(50, wizard.getCurrentMana());
    }

    @Test
    public void hasFamiliar() {
        assertEquals(Familiar.OWL, wizard.getFamiliar());
    }

    @Test
    public void canLoseMana() {
        wizard.loseMana(5);
        assertEquals(45, wizard.getCurrentMana());
    }

    @Test
    public void cannotGoBelow0Mana() {
        wizard.loseMana(10000);
        assertEquals(0, wizard.getCurrentMana());
    }

    @Test
    public void canGainMana() {
        wizard.loseMana(10);
        wizard.gainMana(5);
        assertEquals(45, wizard.getCurrentMana());
    }

    @Test
    public void cannotGoAboveMaxMana() {
        wizard.gainMana(1);
        assertEquals(50, wizard.getCurrentMana());
    }

    @Test
    public void canChangeFamiliar() {
        wizard.changeFamiliar(Familiar.FAERIE_DRAGON);
        assertEquals(Familiar.FAERIE_DRAGON, wizard.getFamiliar());
    }

    @Test
    public void canAddSpellToSpellbook() {
        wizard.addSpellToSpellbook(Spell.FIREBALL);
        assertEquals(
                new ArrayList<>(Arrays.asList(Spell.MAGIC_MISSILE, Spell.FIREBALL)),
                wizard.getSpellbook()
        );
    }

    @Test
    public void cannotSameSpellToSpellbookTwice() {
        wizard.addSpellToSpellbook(Spell.MAGIC_MISSILE);
        assertEquals(
                new ArrayList<>(Collections.singletonList(Spell.MAGIC_MISSILE)),
                wizard.getSpellbook()
        );
    }

    @Test
    public void canRemoveSpellFromSpellbook() {
        wizard.removeSpellFromSpellbook(Spell.MAGIC_MISSILE);
        assertEquals(
                new ArrayList<Spell>(),
                wizard.getSpellbook()
        );
    }

    @Test
    public void canCastSpell() {
        System.out.println("==========");
        System.out.println("Warlock attempting to cast spell...");
        wizard.castSpell(Spell.MAGIC_MISSILE);
        assertEquals(47, wizard.getCurrentMana());
    }

    @Test
    public void cannotCastUnknownSpell() {
        System.out.println("==========");
        System.out.println("Warlock attempting to cast spell...");
        wizard.castSpell(Spell.FIREBALL);
        assertEquals(50, wizard.getCurrentMana());
    }

    @Test
    public void cannotCastSpellWithoutEnoughMana() {
        wizard.loseMana(49);
        System.out.println("==========");
        System.out.println("Warlock attempting to cast spell...");
        wizard.castSpell(Spell.MAGIC_MISSILE);
        assertEquals(1, wizard.getCurrentMana());
    }

}
