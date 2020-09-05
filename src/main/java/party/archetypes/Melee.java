package party.archetypes;

import equipment.Armour;
import equipment.Weapon;
import party.Player;

public abstract class Melee extends Player {

    public Melee(String name, int maxHealth, int strength, int resistance, Weapon weapon, Armour armour) {
        super(name, maxHealth, strength, resistance, weapon, armour);
    }

}
