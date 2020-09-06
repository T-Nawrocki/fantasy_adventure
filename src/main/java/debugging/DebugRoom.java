package debugging;

import dungeon.Direction;
import dungeon.Room;
import equipment.*;

import java.util.AbstractMap;

import static helpers.Divider.divider;

// THIS IS A DEBUGGING CLASS WHICH SHOULD NOT BE INSTANTIATED OUTSIDE OF TESTS
public class DebugRoom extends Room {

    @Override
    public void generateContents() {
        this.treasure = 10;
        this.weapon = Weapon.MAGIC_SWORD;
        this.armour = Armour.MAGIC_ARMOUR;
        this.spell = Spell.METEOR_SWARM;
        this.healingItem = new AbstractMap.SimpleEntry<>(HealingItem.SUPREME_POTION, 5);
        this.familiar = Familiar.DEMON;
    }

    @Override
    public void describeRoom() {
        divider();
        System.out.println("You're not quite sure how you ended up here, " +
                "but this appears to be some sort of control room");
        System.out.println("The walls are blank, " +
                "and there are pedestals with a number of objects around the room");
        System.out.println("There are four doors, but they all seem to lead back here.");
    }

    @Override
    public void describeEnemy() {}

}
