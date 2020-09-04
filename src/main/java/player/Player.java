package player;

import equipment.Armour;
import equipment.Weapon;

public abstract class Player {

    private int maxHp;
    private int currentHp;
    private int strength;
    private int resistance;
    private Weapon weapon;
    private Armour armour;
    private int loot;

    public abstract void fight();
    public abstract void useAbility();

    public Player(int maxHp, int strength, int resistance, Weapon weapon, Armour armour) {
        this.maxHp = maxHp;
        this.currentHp = maxHp;
        this.strength = strength;
        this.resistance = resistance;
        this.weapon = weapon;
        this.armour = armour;
        this.loot = 0;
    }

    public int getMaxHp() {
        return maxHp;
    }

    public int getCurrentHp() {
        return currentHp;
    }

    public int getStrength() {
        return strength;
    }

    public int getResistance() {
        return resistance;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public Armour getArmour() {
        return armour;
    }

    public int getLoot() {
        return loot;
    }


    public void changeWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public void changeArmour(Armour armour) {
        this.armour = armour;
    }

    public void loseHp(int amount) {
        currentHp -= amount;
    }

    public void gainHp(int amount) {
        currentHp += amount;
        if (currentHp > maxHp) currentHp = maxHp;
    }

    public void collectLoot(int amount) {
        loot += amount;
    }

}
