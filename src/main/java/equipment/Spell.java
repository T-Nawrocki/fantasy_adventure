package equipment;

public enum Spell {

    FIREBALL("Fireball", 40, 5),
    CHAIN_LIGHTNING("Chain Lightning", 20, 3),
    ACID_SPLASH("Acid Splash", 12, 1),
    MAGIC_MISSILE("Magic Missile", 24, 3),
    ELDRITCH_BLAST("Eldritch Blast", 16, 2),
    GUIDING_BOLT("Guiding Bolt", 20, 2),
    TIDAL_WAVE("Tidal Wave", 28, 4),
    METEOR_SWARM("Meteor Swarm", 200, 20);

    private String name;
    private int damage;
    private int manaCost;

    Spell(String name, int damage, int manaCost) {
        this.name = name;
        this.damage = damage;
        this.manaCost = manaCost;
    }

    public String getName() {
        return name;
    }

    public int getDamage() {
        return damage;
    }

    public int getManaCost() {
        return manaCost;
    }
}
