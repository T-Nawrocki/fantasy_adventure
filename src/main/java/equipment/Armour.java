package equipment;

public enum Armour {

    MAGE_ROBE("Mage's Robe", 0),
    TUNIC("Tunic", 0),
    LEATHER_ARMOUR("Leather Armour", 1),
    CHAINMAIL("Chainmail", 3),
    PLATE("Plate Armour", 5),
    MAGIC_ARMOUR("Magic Armour", 10);

    private String name;
    private int damageModifier;

    Armour(String name, int damageModifier) {
        this.name = name;
        this.damageModifier = damageModifier;
    }

    public String getName() {
        return name;
    }

    public int getDamageModifier() {
        return damageModifier;
    }
}
