import equipment.Armour;
import equipment.Weapon;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DwarfTest {

    private Dwarf dwarf;

    @Before
    public void before() {
        dwarf = new Dwarf();
    }

    @Test
    public void hasMaxHp() {
        assertEquals(30, dwarf.getMaxHp());
    }

    @Test
    public void hasCurrentHp() {
        assertEquals(30, dwarf.getCurrentHp());
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
    public void canFight() {
        System.out.println("Attempting to fight...");
        dwarf.fight();
    }

    @Test
    public void canUseAbility() {
        System.out.println("Attempting to use ability...");
        dwarf.useAbility();
    }

}
