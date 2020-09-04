package equipment;

public enum Familiar {

    CAT("Cat", 0, 0),
    OWL("Owl", 5, 0),
    BEAR("Bear", 0, 10),
    FAERIE_DRAGON("Faerie Dragon", 10, 2),
    GIANT_TURTLE("Giant Turtle", 0, 10),
    IMP("Imp", 10, -1),
    DEMON("Demon", 50, -5);

    private String name;
    private int magicModifier;
    private int resistanceModifier;

    Familiar(String name, int magicModifier, int resistanceModifier) {
        this.name = name;
        this.magicModifier = magicModifier;
        this.resistanceModifier = resistanceModifier;
    }

    public String getName() {
        return name;
    }

    public int getMagicModifier() {
        return magicModifier;
    }

    public int getResistanceModifier() {
        return resistanceModifier;
    }

}
