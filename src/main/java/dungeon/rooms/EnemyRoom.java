package dungeon.rooms;

import dungeon.Room;
import enemy.Enemy;
import enemy.EnemyType;
import equipment.*;

import java.util.AbstractMap;
import java.util.Random;

import static helpers.Divider.divider;

public class EnemyRoom extends Room {

    private Enemy enemy;
    private static Random random = new Random();

    @Override
    public void generateContents() {
        this.enemy = generateEnemy();
        this.treasure = generateTreasure();
        this.weapon = generateWeapon();
        this.armour = generateArmour();
        this.spell = generateSpell();
        this.healingItem = generateHealingItem();
        this.familiar = generateFamiliar();
    }

    @Override
    public void describeRoom() {
        divider();
        System.out.printf(
                "With the %s dead, you have a chance to look around the room and see what you can find...%n",
                enemy.getName()
        );
        System.out.printf("You find valuables worth a total of %d gp.%n", treasure);
        if (weapon != null) System.out.printf("A chest in the corner holds a %s.%n", weapon.getName());
        if (armour != null) System.out.printf("There is an armour stand with a %s on it.%n", armour.getName());
        if (spell != null) System.out.printf(
                "On a bookshelf, you find a scroll containing details of the %s spell.%n",
                spell.getName()
        );
        if (healingItem != null) System.out.printf(
                "Among the papers on a workbench in the centre of the room, you find %d %s.%n",
                healingItem.getValue(),
                healingItem.getValue() > 1 ? healingItem.getKey() + "s" : healingItem.getKey()
        );
        if (familiar != null) System.out.printf(
                "A shrine at the back of the room is dedicated to a %s spirit.%n",
                familiar.getName()
        );
    }

    @Override
    public void describeEnemy() {
        divider();
        System.out.printf("You enter the room, and are confronted with a %s, preparing to attack!%n", enemy.getName());
        System.out.println("You will have to deal with it before you can move forward...");

    }

    private Enemy generateEnemy() {
        EnemyType[] options = EnemyType.values();
        return options[random.nextInt(options.length)].getInstance();
    }

    private int generateTreasure() {
        int min = 50;
        int max = 200;
        return random.nextInt((max - min) + 1) + min;
    }

    private Weapon generateWeapon() {
        int chance = 10;  // chance of room containing this item type is 1/chance
        int roll = random.nextInt(chance);

        if (roll == 0) {
            Weapon[] options = Weapon.values();
            return options[random.nextInt(options.length)];
        }

        return null;
    }

    private Armour generateArmour() {
        int chance = 10;  // chance of room containing this item type is 1/chance
        int roll = random.nextInt(chance);

        if (roll == 0) {
            Armour[] options = Armour.values();
            return options[random.nextInt(options.length)];
        }

        return null;
    }

    private Spell generateSpell() {
        int chance = 10;  // chance of room containing this item type is 1/chance
        int roll = random.nextInt(chance);

        if (roll == 0) {
            Spell[] options = Spell.values();
            return options[random.nextInt(options.length)];
        }

        return null;
    }

    private AbstractMap.SimpleEntry<HealingItem, Integer> generateHealingItem() {
        int chance = 3;  // chance of room containing this item type is 1/chance
        int roll = random.nextInt(chance);

        if (roll == 0) {
            HealingItem[] options = HealingItem.values();
            HealingItem selectedItem = options[random.nextInt(options.length)];

            int quantity = random.nextInt(5) + 1;

            return new AbstractMap.SimpleEntry<>(selectedItem, quantity);
        }

        return null;
    }

    private Familiar generateFamiliar() {
        int chance = 10;  // chance of room containing this item type is 1/chance
        int roll = random.nextInt(chance);

        if (roll == 0) {
            Familiar[] options = Familiar.values();
            return options[random.nextInt(options.length)];
        }

        return null;
    }

}
