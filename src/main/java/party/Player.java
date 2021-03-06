package party;

import equipment.Armour;
import equipment.Weapon;

public abstract class Player {

    private String name;
    private int maxHealth;
    private int currentHealth;
    private int strength;
    private int resistance;
    private Weapon weapon;
    private Armour armour;

    public abstract void fight();
    public abstract void useAbility();

    public Player(String name, int maxHealth, int strength, int resistance, Weapon weapon, Armour armour) {
        this.name = name;
        this.maxHealth = maxHealth;
        this.currentHealth = maxHealth;
        this.strength = strength;
        this.resistance = resistance;
        this.weapon = weapon;
        this.armour = armour;
    }

    public String getName() {
        return name;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public int getCurrentHealth() {
        return currentHealth;
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

    public void changeWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public void changeArmour(Armour armour) {
        this.armour = armour;
    }

    public void loseHealth(int amount) {
        currentHealth -= amount;
        if (currentHealth < 0) currentHealth = 0;
    }

    public void gainHealth(int amount) {
        currentHealth += amount;
        if (currentHealth > maxHealth) currentHealth = maxHealth;
    }

}
