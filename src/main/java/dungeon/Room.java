package dungeon;

import equipment.*;

import java.util.AbstractMap;

public abstract class Room {

    protected int treasure;
    protected Weapon weapon;
    protected Armour armour;
    protected Spell spell;
    protected AbstractMap.SimpleEntry<HealingItem, Integer> healingItem;
    protected Familiar familiar;

    public Room() {
        generateContents();
        describeRoom();
    }

    public int getTreasure() {
        return treasure;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public Armour getArmour() {
        return armour;
    }

    public Spell getSpell() {
        return spell;
    }

    public AbstractMap.SimpleEntry<HealingItem, Integer> getHealingItem() {
        return healingItem;
    }

    public Familiar getFamiliar() {
        return familiar;
    }

    public abstract void generateContents();

    public abstract void describeRoom();

}
