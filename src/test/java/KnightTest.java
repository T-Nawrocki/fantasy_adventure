import equipment.Armour;
import equipment.Weapon;
import org.junit.Before;
import org.junit.Test;
import player.classes.Knight;

import static org.junit.Assert.assertEquals;

public class KnightTest {

    private Knight knight;

    @Before
    public void before() {
        knight = new Knight();
    }

    @Test
    public void hasMaxHp() {
        assertEquals(40, knight.getMaxHp());
    }

    @Test
    public void hasCurrentHp() {
        assertEquals(40, knight.getCurrentHp());
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
