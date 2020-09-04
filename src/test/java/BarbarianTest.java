import equipment.Armour;
import equipment.Weapon;
import org.junit.Before;
import org.junit.Test;
import player.classes.Barbarian;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class BarbarianTest {

    private Barbarian barbarian;

    @Before
    public void before() {
        barbarian = new Barbarian();
    }

    @Test
    public void hasMaxHp() {
        assertEquals(50, barbarian.getMaxHp());
    }

    @Test
    public void hasCurrentHp() {
        assertEquals(50, barbarian.getCurrentHp());
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
    public void hasLoot() {
        assertEquals(0, barbarian.getLoot());
    }

    @Test
    public void canFight() {
        System.out.println("Attempting to fight...");
        barbarian.fight();
    }

    @Test
    public void canUseAbility() {
        System.out.println("Attempting to use ability...");
        barbarian.useAbility();
    }

}
