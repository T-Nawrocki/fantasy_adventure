package party.classes;

import equipment.Armour;
import equipment.Weapon;
import org.junit.Before;
import org.junit.Test;
import party.classes.Barbarian;

import static org.junit.Assert.assertEquals;

public class BarbarianTest {

    private Barbarian barbarian;

    @Before
    public void before() {
        barbarian = new Barbarian("Grog");
    }


    @Test
    public void hasName() {
        assertEquals("Grog", barbarian.getName());
    }

    @Test
    public void canConvertToString() {
        assertEquals("Grog the Barbarian", barbarian.toString());
    }

    @Test
    public void hasMaxHealth() {
        assertEquals(50, barbarian.getMaxHealth());
    }

    @Test
    public void hasCurrentHealth() {
        assertEquals(50, barbarian.getCurrentHealth());
    }

    @Test
    public void hasStrength() {
        assertEquals(10, barbarian.getStrength());
    }

    @Test
    public void hasResistance() {
        assertEquals(5, barbarian.getResistance());
    }

    @Test
    public void hasWeapon() {
        assertEquals(Weapon.AXE, barbarian.getWeapon());
    }

    @Test
    public void hasArmour() {
        assertEquals(Armour.LEATHER_ARMOUR, barbarian.getArmour());
    }

    @Test
    public void canChangeWeapon() {
        barbarian.changeWeapon(Weapon.MAGIC_SWORD);
        assertEquals(Weapon.MAGIC_SWORD, barbarian.getWeapon());
    }

    @Test
    public void canChangeArmour() {
        barbarian.changeArmour(Armour.MAGIC_ARMOUR);
        assertEquals(Armour.MAGIC_ARMOUR, barbarian.getArmour());
    }

    @Test
    public void canLoseHealth() {
        barbarian.loseHealth(1);
        assertEquals(49, barbarian.getCurrentHealth());
    }

    @Test
    public void cannotGoBelow0Health() {
        barbarian.loseHealth(100000);
        assertEquals(0, barbarian.getCurrentHealth());
    }

    @Test
    public void canGainHealth() {
        barbarian.loseHealth(10);
        barbarian.gainHealth(1);
        assertEquals(41, barbarian.getCurrentHealth());
    }

    @Test
    public void cannotGoAboveMaxHealth() {
        barbarian.gainHealth(1);
        assertEquals(50, barbarian.getCurrentHealth());
    }

    @Test
    public void canFight() {
        System.out.println("==========");
        System.out.println("Barbarian attempting to fight...");
        barbarian.fight();
    }

    @Test
    public void canUseAbility() {
        System.out.println("==========");
        System.out.println("Barbarian attempting to use ability...");
        barbarian.useAbility();
    }

}
