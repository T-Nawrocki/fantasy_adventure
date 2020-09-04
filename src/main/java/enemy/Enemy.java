package enemy;

public abstract class Enemy {

    private String name;
    private String description;
    private int health;
    private int strength;

    public Enemy(String name, String description, int health, int strength) {
        this.name = name;
        this.description = description;
        this.health = health;
        this.strength = strength;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getHealth() {
        return health;
    }

    public int getStrength() {
        return strength;
    }

    public void loseHealth(int amount) {
        health -= amount;
        if (health < 0) health = 0;
    }
}
