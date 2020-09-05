package party.classes;

import equipment.*;
import org.junit.Before;
import org.junit.Test;
import party.classes.Cleric;

import java.util.*;

import static org.junit.Assert.assertEquals;

public class ClericTest {

    private Cleric cleric;

    @Before
    public void before() {
        cleric = new Cleric("Pike");
    }

    @Test
    public void hasName() {
        assertEquals("Pike", cleric.getName());
    }

    @Test
    public void hasMaxHealth() {
        assertEquals(20, cleric.getMaxHealth());
    }

    @Test
    public void hasCurrentHealth() {
        assertEquals(20, cleric.getCurrentHealth());
    }

    @Test
    public void hasStrength() {
        assertEquals(0, cleric.getStrength());
    }

    @Test
    public void hasResistance() {
        assertEquals(-2, cleric.getResistance());
    }

    @Test
    public void hasWeapon() {
        assertEquals(Weapon.STAFF, cleric.getWeapon());
    }

    @Test
    public void hasArmour() {
        assertEquals(Armour.TUNIC, cleric.getArmour());
    }

    @Test
    public void hasLoot() {
        assertEquals(0, cleric.getLoot());
    }

    @Test
    public void canChangeWeapon() {
        cleric.changeWeapon(Weapon.MAGIC_SWORD);
        assertEquals(Weapon.MAGIC_SWORD, cleric.getWeapon());
    }

    @Test
    public void canChangeArmour() {
        cleric.changeArmour(Armour.MAGIC_ARMOUR);
        assertEquals(Armour.MAGIC_ARMOUR, cleric.getArmour());
    }

    @Test
    public void canLoseHealth() {
        cleric.loseHealth(1);
        assertEquals(19, cleric.getCurrentHealth());
    }

    @Test
    public void cannotGoBelow0Health() {
        cleric.loseHealth(100000);
        assertEquals(0, cleric.getCurrentHealth());
    }

    @Test
    public void canGainHealth() {
        cleric.loseHealth(10);
        cleric.gainHealth(1);
        assertEquals(11, cleric.getCurrentHealth());
    }

    @Test
    public void cannotGoAboveMaxHealth() {
        cleric.gainHealth(1);
        assertEquals(20, cleric.getCurrentHealth());
    }

    @Test
    public void canCollectLoot() {
        cleric.collectLoot(10);
        assertEquals(10, cleric.getLoot());
    }


    @Test
    public void canFight() {
        System.out.println("==========");
        System.out.println("Cleric attempting to fight...");
        cleric.fight();
    }

    @Test
    public void canUseAbility() {
        System.out.println("==========");
        System.out.println("Cleric attempting to use ability...");
        cleric.useAbility();
    }

    @Test
    public void hasSpellbook() {
        assertEquals(
                new ArrayList<>(),
                cleric.getSpellbook()
        );
    }

    @Test
    public void hasMaxMana() {
        assertEquals(15, cleric.getMaxMana());
    }

    @Test
    public void hasCurrentMana() {
        assertEquals(15, cleric.getCurrentMana());
    }

    @Test
    public void hasFamiliar() {
        assertEquals(Familiar.BEAR, cleric.getFamiliar());
    }

    @Test
    public void canLoseMana() {
        cleric.loseMana(5);
        assertEquals(10, cleric.getCurrentMana());
    }

    @Test
    public void cannotGoBelow0Mana() {
        cleric.loseMana(10000);
        assertEquals(0, cleric.getCurrentMana());
    }

    @Test
    public void canGainMana() {
        cleric.loseMana(10);
        cleric.gainMana(5);
        assertEquals(10, cleric.getCurrentMana());
    }

    @Test
    public void cannotGoAboveMaxMana() {
        cleric.gainMana(1);
        assertEquals(15, cleric.getCurrentMana());
    }

    @Test
    public void canChangeFamiliar() {
        cleric.changeFamiliar(Familiar.GIANT_TURTLE);
        assertEquals(Familiar.GIANT_TURTLE, cleric.getFamiliar());
    }

    @Test
    public void canAddSpellToSpellbook() {
        cleric.addSpellToSpellbook(Spell.GUIDING_BOLT);
        assertEquals(
                new ArrayList<>(Collections.singletonList(Spell.GUIDING_BOLT)),
                cleric.getSpellbook()
        );
    }

    @Test
    public void cannotSameSpellToSpellbookTwice() {
        cleric.addSpellToSpellbook(Spell.GUIDING_BOLT);
        cleric.addSpellToSpellbook(Spell.GUIDING_BOLT);
        assertEquals(
                new ArrayList<>(Collections.singletonList(Spell.GUIDING_BOLT)),
                cleric.getSpellbook()
        );
    }

    @Test
    public void canRemoveSpellFromSpellbook() {
        cleric.addSpellToSpellbook(Spell.GUIDING_BOLT);
        cleric.removeSpellFromSpellbook(Spell.GUIDING_BOLT);
        assertEquals(
                new ArrayList<Spell>(),
                cleric.getSpellbook()
        );
    }

    @Test
    public void canCastSpell() {
        cleric.addSpellToSpellbook(Spell.GUIDING_BOLT);
        System.out.println("==========");
        System.out.println("Cleric attempting to cast spell...");
        cleric.castSpell(Spell.GUIDING_BOLT);
        assertEquals(13, cleric.getCurrentMana());
    }

    @Test
    public void cannotCastUnknownSpell() {
        System.out.println("==========");
        System.out.println("Cleric attempting to cast spell...");
        cleric.castSpell(Spell.FIREBALL);
        assertEquals(15, cleric.getCurrentMana());
    }

    @Test
    public void cannotCastSpellWithoutEnoughMana() {
        cleric.addSpellToSpellbook(Spell.GUIDING_BOLT);
        cleric.loseMana(14);
        System.out.println("==========");
        System.out.println("Cleric attempting to cast spell...");
        cleric.castSpell(Spell.GUIDING_BOLT);
        assertEquals(1, cleric.getCurrentMana());
    }

    @Test
    public void hasHealingItems() {
        assertEquals(
                new HashMap<>(Collections.singletonMap(HealingItem.MINOR_POTION, 5)),
                cleric.getHealingItems()
        );
    }

    @Test
    public void canCollectNewHealingItem() {
        cleric.collectHealingItem(HealingItem.SUPREME_POTION, 2);
        assertEquals(
                new HashMap<HealingItem, Integer>() {{
                    put(HealingItem.MINOR_POTION, 5);
                    put(HealingItem.SUPREME_POTION, 2);
                }},
                cleric.getHealingItems()
        );
    }

    @Test
    public void canCollectExistingHealingItem() {
        cleric.collectHealingItem(HealingItem.MINOR_POTION, 2);
        assertEquals(
                new HashMap<>(Collections.singletonMap(HealingItem.MINOR_POTION, 7)),
                cleric.getHealingItems()
        );
    }
    
    @Test
    public void canUseHealingItem() {
        System.out.println("==========");
        System.out.println("Cleric attempting to use healing item...");
        cleric.useHealingItem(HealingItem.MINOR_POTION);
        assertEquals(
                new HashMap<>(Collections.singletonMap(HealingItem.MINOR_POTION, 4)),
                cleric.getHealingItems()
        );
    }

    @Test
    public void canUseLastHealingItem() {
        cleric.collectHealingItem(HealingItem.BANDAGE, 1);
        System.out.println("==========");
        System.out.println("Cleric attempting to use healing item...");
        cleric.useHealingItem(HealingItem.BANDAGE);
        assertEquals(
                new HashMap<>(Collections.singletonMap(HealingItem.MINOR_POTION, 5)),
                cleric.getHealingItems()
        );
    }

    @Test
    public void cannotUseHealingItemYouDoNotOwn() {
        System.out.println("==========");
        System.out.println("Cleric attempting to use healing item...");
        cleric.useHealingItem(HealingItem.BANDAGE);
        assertEquals(
                new HashMap<>(Collections.singletonMap(HealingItem.MINOR_POTION, 5)),
                cleric.getHealingItems()
        );
    }

}
