package party;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class Party {

    private static Party instance = new Party();

    private ArrayList<Player> partyMembers;
    private int loot;

    private Party() {
        partyMembers = new ArrayList<>();
        loot = 0;
    }

    public static Party getInstance() {
        return instance;
    }

    public void resetInstance() {
        partyMembers = new ArrayList<>();
        loot = 0;
    }

    public ArrayList<Player> getPartyMembers() {
        return partyMembers;
    }

    public int getLoot() {
        return loot;
    }

    public int getPartySize() {
        return partyMembers.size();
    }

    public void addPartyMember(Player player) {
        if (partyMembers.contains(player)) return;
        if (partyMembers.size() >= 6) return;
        partyMembers.add(player);
    }

    public void removePartyMember(Player player) {
        partyMembers.remove(player);
    }

    public String partyDescription() {
        if (getPartySize() == 0) return "no-one";
        if (getPartySize() == 1) return partyMembers.get(0).toString();

        ArrayList<String> partyNames = partyMembers.stream()
                .map(Player::toString)
                .collect(Collectors.toCollection(ArrayList::new));
        // gets comma separated list of all but final member
        String commaSeparated = String.join(", ", partyNames.subList(0, getPartySize() - 1));
        // adds final "and" and last party member
        return commaSeparated + " and " + partyNames.get(getPartySize() - 1);
    }

    public void collectLoot(int amount) {
        loot += amount;
    }

}
