package player.archetypes;

import equipment.Armour;
import equipment.Weapon;
import player.Player;

public abstract class Melee extends Player {

    public Melee(int maxHealth, int strength, int resistance, Weapon weapon, Armour armour) {
        super(maxHealth, strength, resistance, weapon, armour);
    }

}
