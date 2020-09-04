package debugging;

import dungeon.Direction;
import dungeon.Room;
import equipment.*;

import java.util.AbstractMap;
import java.util.HashMap;

// THIS IS A DEBUGGING CLASS WHICH SHOULD NOT BE INSTANTIATED OUTSIDE OF TESTS
public class DebugRoom extends Room {
//
//    public DebugRoom() {
//        super();
//    }

    @Override
    public void generateContents() {
        this.treasure = 10;
        this.weapon = Weapon.MAGIC_SWORD;
        this.armour = Armour.MAGIC_ARMOUR;
        this.spell = Spell.METEOR_SWARM;
        this.healingItem = new AbstractMap.SimpleEntry<>(HealingItem.SUPREME_POTION, 5);
        this.familiar = Familiar.DEMON;
        this.exits = new Direction[] {Direction.NORTH, Direction.EAST, Direction.SOUTH, Direction.WEST};
    }

}
