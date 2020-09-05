package party.classes;

import equipment.Armour;
import equipment.Weapon;
import org.junit.Before;
import org.junit.Test;
import party.classes.Dwarf;

import static org.junit.Assert.assertEquals;

public class DwarfTest {

    private Dwarf dwarf;

    @Before
    public void before() {
        dwarf = new Dwarf();
    }

    @Test
    public void hasMaxHp() {
        assertEquals(30, dwarf.getMaxHealth());
    }

    @Test
    public void hasCurrentHp() {
        assertEquals(30, dwarf.getCurrentHealth());
    }

    @Test
    public void hasStrength() {
        assertEquals(5, dwarf.getStrength());
    }

    @Test
    public void hasResistance() {
        assertEquals(8, dwarf.getResistance());
    }

    @Test
    public void hasWeapon() {
        assertEquals(Weapon.AXE, dwarf.getWeapon());
    }

    @Test
    public void hasArmour() {
        assertEquals(Armour.CHAINMAIL, dwarf.getArmour());
    }

    @Test
    public void hasLoot() {
        assertEquals(0, dwarf.getLoot());
    }

    @Test
    public void canChangeWeapon() {
        dwarf.changeWeapon(Weapon.MAGIC_SWORD);
        assertEquals(Weapon.MAGIC_SWORD, dwarf.getWeapon());
    }

    @Test
    public void canChangeArmour() {
        dwarf.changeArmour(Armour.MAGIC_ARMOUR);
        assertEquals(Armour.MAGIC_ARMOUR, dwarf.getArmour());
    }

    @Test
    public void canLoseHealth() {
        dwarf.loseHealth(1);
        assertEquals(29, dwarf.getCurrentHealth());
    }

    @Test
    public void cannotGoBelow0Health() {
        dwarf.loseHealth(100000);
        assertEquals(0, dwarf.getCurrentHealth());
    }

    @Test
    public void canGainHealth() {
        dwarf.loseHealth(10);
        dwarf.gainHealth(1);
        assertEquals(21, dwarf.getCurrentHealth());
    }

    @Test
    public void cannotGoAboveMaxHealth() {
        dwarf.gainHealth(1);
        assertEquals(30, dwarf.getCurrentHealth());
    }

    @Test
    public void canCollectLoot() {
        dwarf.collectLoot(10);
        assertEquals(10, dwarf.getLoot());
    }

    @Test
    public void canFight() {
        System.out.println("==========");
        System.out.println("Dwarf attempting to fight...");
        dwarf.fight();
    }

    @Test
    public void canUseAbility() {
        System.out.println("==========");
        System.out.println("Dwarf attempting to use ability...");
        dwarf.useAbility();
    }

}
