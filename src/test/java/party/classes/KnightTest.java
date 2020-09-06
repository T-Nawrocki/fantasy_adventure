package party.classes;

import equipment.Armour;
import equipment.Weapon;
import org.junit.Before;
import org.junit.Test;
import party.classes.Knight;

import static org.junit.Assert.assertEquals;

public class KnightTest {

    private Knight knight;

    @Before
    public void before() {
        knight = new Knight("Vax");
    }

    @Test
    public void hasName() {
        assertEquals("Vax", knight.getName());
    }

    @Test
    public void canConvertToString() {
        assertEquals("Vax the Knight", knight.toString());
    }

    @Test
    public void hasMaxHealth() {
        assertEquals(40, knight.getMaxHealth());
    }

    @Test
    public void hasCurrentHealth() {
        assertEquals(40, knight.getCurrentHealth());
    }

    @Test
    public void hasStrength() {
        assertEquals(7, knight.getStrength());
    }

    @Test
    public void hasResistance() {
        assertEquals(3, knight.getResistance());
    }

    @Test
    public void hasWeapon() {
        assertEquals(Weapon.SHORTSWORD, knight.getWeapon());
    }

    @Test
    public void hasArmour() {
        assertEquals(Armour.PLATE, knight.getArmour());
    }

    @Test
    public void hasLoot() {
        assertEquals(0, knight.getLoot());
    }

    @Test
    public void canChangeWeapon() {
        knight.changeWeapon(Weapon.MAGIC_SWORD);
        assertEquals(Weapon.MAGIC_SWORD, knight.getWeapon());
    }

    @Test
    public void canChangeArmour() {
        knight.changeArmour(Armour.MAGIC_ARMOUR);
        assertEquals(Armour.MAGIC_ARMOUR, knight.getArmour());
    }

    @Test
    public void canLoseHealth() {
        knight.loseHealth(1);
        assertEquals(39, knight.getCurrentHealth());
    }

    @Test
    public void cannotGoBelow0Health() {
        knight.loseHealth(100000);
        assertEquals(0, knight.getCurrentHealth());
    }

    @Test
    public void canGainHealth() {
        knight.loseHealth(10);
        knight.gainHealth(1);
        assertEquals(31, knight.getCurrentHealth());
    }

    @Test
    public void cannotGoAboveMaxHealth() {
        knight.gainHealth(1);
        assertEquals(40, knight.getCurrentHealth());
    }

    @Test
    public void canCollectLoot() {
        knight.collectLoot(10);
        assertEquals(10, knight.getLoot());
    }


    @Test
    public void canFight() {
        System.out.println("==========");
        System.out.println("Knight attempting to fight...");
        knight.fight();
    }

    @Test
    public void canUseAbility() {
        System.out.println("==========");
        System.out.println("Knight attempting to use ability...");
        knight.useAbility();
    }

}
