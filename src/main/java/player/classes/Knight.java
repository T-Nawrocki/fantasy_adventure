package player.classes;

import equipment.Armour;
import equipment.Weapon;
import player.Player;

public class Knight extends Player {

    public Knight() {
        super(
                40,
                7,
                3,
                Weapon.SHORTSWORD,
                Armour.PLATE
        );
    }

    @Override
    public void fight() {
        System.out.println("Knight is fighting");
    }

    @Override
    public void useAbility() {
        System.out.println("Knight uses their ability");
    }
}
