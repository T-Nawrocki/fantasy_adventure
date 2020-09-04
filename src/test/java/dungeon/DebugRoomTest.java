package dungeon;

import debugging.DebugRoom;
import equipment.*;
import org.junit.Before;
import org.junit.Test;

import java.util.AbstractMap;
import java.util.HashMap;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class DebugRoomTest {

    private DebugRoom debugRoom;

    @Before
    public void before() {
        debugRoom = new DebugRoom();
    }

    @Test
    public void hasTreasure() {
        assertEquals(10, debugRoom.getTreasure());
    }

    @Test
    public void hasWeapon() {
        assertEquals(Weapon.MAGIC_SWORD, debugRoom.getWeapon());
    }

    @Test
    public void hasArmour() {
        assertEquals(Armour.MAGIC_ARMOUR, debugRoom.getArmour());
    }

    @Test
    public void hasSpell() {
        assertEquals(Spell.METEOR_SWARM, debugRoom.getSpell());
    }

    @Test
    public void hasHealingItem() {
        assertEquals(
                new AbstractMap.SimpleEntry<>(HealingItem.SUPREME_POTION, 5),
                debugRoom.getHealingItem()
        );
    }

    @Test
    public void hasFamiliar() {
        assertEquals(Familiar.DEMON, debugRoom.getFamiliar());
    }

    @Test
    public void hasExits() {
        assertArrayEquals(
                new Direction[] {Direction.NORTH, Direction.EAST, Direction.SOUTH, Direction.WEST},
                debugRoom.getExits()
        );
    }

}
