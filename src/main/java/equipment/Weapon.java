package equipment;

public enum Weapon {
    AXE("Axe", 5),
    SHORTSWORD("Shortsword", 4),
    HALBERD("Halberd", 4),
    DAGGER("Dagger", 2),
    STAFF("Wooden Staff", 1),
    MAGIC_SWORD("Magic Sword", 10);

    private String name;
    private int damage;

    Weapon(String name, int damage) {
        this.name = name;
        this.damage = damage;
    }

    public String getName() {
        return name;
    }

    public int getDamage() {
        return damage;
    }
}
