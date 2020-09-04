package equipment;

public enum HealingItem {
    BANDAGE("Bandage", 3),
    MINOR_POTION("Minor Potion", 5),
    GREATER_POTION("Greater Potion", 10),
    SUPERIOR_POTION("Superior Potion", 20),
    SUPREME_POTION("Supreme Potion", 50);

    private String name;
    private int healingValue;

    HealingItem(String name, int healingValue) {
        this.name = name;
        this.healingValue = healingValue;
    }

    public String getName() {
        return name;
    }

    public int getHealingValue() {
        return healingValue;
    }
}
