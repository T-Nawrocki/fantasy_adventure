package party;

import java.util.ArrayList;

public class Party {

    private static Party instance = new Party();

    private ArrayList<Player> partyMembers;

    private Party() {
        partyMembers = new ArrayList<>();
    }

    public static Party getInstance() {
        return instance;
    }

    public void resetInstance() {
        partyMembers = new ArrayList<>();

    }

    public ArrayList<Player> getPartyMembers() {
        return partyMembers;
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


}
