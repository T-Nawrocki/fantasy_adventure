import party.Party;

import static helpers.Divider.divider;

public class Adventure {

    private static Party party = Party.getInstance();

    public static void main(String[] args) {

        gatherParty();

        introDescription();

    }

    private static void gatherParty() {
        divider();
        System.out.println("You must gather your party before venturing forth...");

        while (party.getPartySize() < 6) {

        }
    }

    private static void introDescription() {
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

}
