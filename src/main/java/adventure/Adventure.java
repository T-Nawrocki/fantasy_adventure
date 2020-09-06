package adventure;

import dungeon.Room;
import dungeon.rooms.EnemyRoom;
import dungeon.rooms.TreasureRoom;
import party.Party;
import party.Player;
import party.classes.*;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

import static helpers.Divider.divider;
import static helpers.FailedInputResponse.failedInputResponse;

public class Adventure {

    private static Scanner scanner = new Scanner(System.in);
    private static Random random = new Random();

    private static Party party = Party.getInstance();
    private static int roomsVisited = 0;
    private static Room currentRoom;

    public static void gatherParty() {
        party.resetInstance();

        divider();
        System.out.println("You must gather your party before venturing forth...");
        System.out.println("Your party can consist of up to six adventurers.");

        boolean partyComplete = false;

        System.out.println("Start by adding the first adventurer to your party.");
        createNewPlayer();

        while (!partyComplete) {

            System.out.println("Your party currently consists of: " + party.partyDescription());
            System.out.println("Would you like to add another party member? (y/n)");
            String addNewPlayerResponse = scanner.nextLine().toLowerCase();

            if (addNewPlayerResponse.equals("y")) {
                createNewPlayer();
                if (party.getPartySize() == 6) partyComplete = true;
            } else if (addNewPlayerResponse.equals("n")) {
                partyComplete = true;
            } else {
                failedInputResponse();
            }

        }

        System.out.println("With your party complete, it's time to begin your adventure...");
        System.out.println(party.partyDescription() + " head towards the dungeon,");
        System.out.println("ready to search for whatever treasure they can find, and battle their way to victory...");
    }

    private static void createNewPlayer() {
        boolean playerCreated = false;

        while (!playerCreated) {
            String classChosen = "";
            String nameChosen;

            while (classChosen.equals("")) {
                System.out.println("What class will the new adventurer be?");
                System.out.println("Barbarian | Cleric | Dwarf | Knight | Warlock | Wizard");
                String classResponse = scanner.nextLine().toLowerCase();

                if (
                        Arrays.asList(
                                "barbarian",
                                "cleric",
                                "dwarf",
                                "knight",
                                "warlock",
                                "wizard"
                        ).contains(classResponse)
                ) {
                    classChosen = classResponse;
                } else {
                    failedInputResponse();
                }
            }

            System.out.println("What is the new adventurer's name?");
            nameChosen = scanner.nextLine();

            boolean confirmationReceived = false;
            String confirmationResponse = "";
            while (!confirmationReceived) {
                System.out.printf("So you want to add a %s called %s to the party? (y/n)%n", classChosen, nameChosen);
                confirmationResponse = scanner.nextLine().toLowerCase();
                if (!Arrays.asList("y", "n").contains(confirmationResponse)) {
                    failedInputResponse();
                } else {
                    confirmationReceived = true;
                }
            }

            if (confirmationResponse.equals("y")) {
                Player newAdventurer = generateCharacter(classChosen, nameChosen);
                party.addPartyMember(newAdventurer);
                playerCreated = true;
            }
        }
    }

    private static Player generateCharacter(String classChosen, String nameChosen) {
        if (classChosen.equals("barbarian")) return new Barbarian(nameChosen);
        if (classChosen.equals("cleric")) return new Cleric(nameChosen);
        if (classChosen.equals("dwarf")) return new Dwarf(nameChosen);
        if (classChosen.equals("knight")) return new Knight(nameChosen);
        if (classChosen.equals("warlock")) return new Warlock(nameChosen);
        if (classChosen.equals("wizard")) return new Wizard(nameChosen);
        return null;
    }

    public static void introDescription() {
        divider();
        System.out.println("Your party gathers in the dungeon's entrance hall. The wreckage around you suggests that");
        System.out.println("these outer rooms have already been looted. After wandering around for a few hours in ");
        System.out.println("search of any remaining treasure, you still have nothing to show for your efforts.");
        System.out.println("You decide you are unlikely to find anything more here, and will have to venture deeper");
        System.out.println("if you want to find anything that will make your journey here worthwhile.");
        System.out.println("You ready yourselves, and begin to head deeper into the mountain...");
        System.out.println("After a few more deserted rooms, you find yourselves by a door that seems untouched.");
        System.out.println("Slowly, you push the door open...");
    }

    public static void changeRoom() {
        // chance of finding exit is roomsVisited / maxRooms
        int maxRooms = 10;
        int roll = random.nextInt(maxRooms) + 1;
        if (roll < roomsVisited) {
            winGame();
        } else {
            generateRoom();
        }
    }

    private static void generateRoom() {
        roomsVisited += 1;
        int roll = random.nextInt(2);  // even chance of treasure room or enemy room

        if (roll == 0) {
            currentRoom = new TreasureRoom();
            currentRoom.describeRoom();
        } else {
            currentRoom = new EnemyRoom();
            currentRoom.describeEnemy();
            combat();
        }
    }

    private static void combat() {
        // TODO combat mechanics
    }


    private static void winGame() {
        divider();
        System.out.println("As you pass through the door, you squint as sunlight bursts in your eyes.");
        System.out.println("Finally! You have found your way out of the dungeon. You set up camp and");
        System.out.println("count out the spoils of your adventure.");
        System.out.printf(
                "%d gp split %d ways, meaning you'll each take %d gp home.%n",
                party.getLoot(),
                party.getPartySize(),
                party.getLoot() / party.getPartySize()
        );
        System.out.println("You head back to town, slowly, grateful just to have made it out alive");
        System.out.println("and wondering what else you might have left behind under the mountain...");
    }

}
