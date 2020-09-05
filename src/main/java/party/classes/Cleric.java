package party.classes;

import equipment.*;
import party.archetypes.Spellcaster;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Cleric extends Spellcaster {

    private HashMap<HealingItem, Integer> healingItems;

    public Cleric() {
        super(
                20,
                0,
                -2,
                Weapon.STAFF,
                Armour.TUNIC,
                new ArrayList<>(),
                15,
                Familiar.BEAR
        );
        healingItems = new HashMap<>(Collections.singletonMap(HealingItem.MINOR_POTION, 5));
    }

    public HashMap<HealingItem, Integer> getHealingItems() {
        return healingItems;
    }

    @Override
    public void fight() {
        System.out.println("The Cleric flails around, hoping to do some damage... It's not very effective.");
    }

    @Override
    public void useAbility() {
        System.out.println("Basic healing or maybe replenishing potions");
    }


    public void collectHealingItem(HealingItem healingItem, int amount) {
        int count = healingItems.getOrDefault(healingItem, 0);
        healingItems.put(healingItem, count + amount);
    }

    public void useHealingItem(HealingItem healingItem) {
        if (healingItems.containsKey(healingItem)) {
            int remaining = healingItems.get(healingItem) - 1;
            if (remaining == 0) {
                healingItems.remove(healingItem);
            } else {
                healingItems.put(healingItem, remaining);
            }
            System.out.println("Cleric used a " + healingItem.getName());
        } else {
            System.out.println("Cleric doesn't have any " + healingItem.getName());
        }
    }
}
