package party;

import org.junit.Before;
import org.junit.Test;
import party.classes.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import static org.junit.Assert.assertEquals;

public class PartyTest {

    private Party party = Party.getInstance() ;

    @Before
    public void before() {
        party.resetInstance();
    }

    @Test
    public void canGetPartySize() {
        assertEquals(0, party.getPartySize());
    }

    @Test
    public void partyMembersStartsEmpty() {
        assertEquals(
                new ArrayList<>(),
                party.getPartyMembers()
        );
    }

    @Test
    public void canAddPartyMember() {
        Barbarian barbarian = new Barbarian("Grog");
        party.addPartyMember(barbarian);
        assertEquals(
                new ArrayList<>(Collections.singletonList(barbarian)),
                party.getPartyMembers()
        );
    }

    @Test
    public void cannotAddExistingPartyMember() {
        Barbarian barbarian = new Barbarian("Grog");
        party.addPartyMember(barbarian);
        party.addPartyMember(barbarian);
        assertEquals(
                new ArrayList<>(Collections.singletonList(barbarian)),
                party.getPartyMembers()
        );
    }

    @Test
    public void cannotAddMoreThanSixPartyMembers() {
        Barbarian barbarian = new Barbarian("Grog");
        Cleric cleric = new Cleric("Pike");
        Dwarf dwarf = new Dwarf("Tova");
        Knight knight = new Knight("Vax");
        Warlock warlock = new Warlock("Percy");
        Wizard wizard = new Wizard("Caleb");
        Barbarian otherBarbarian = new Barbarian("Yasha");

        party.addPartyMember(barbarian);
        party.addPartyMember(cleric);
        party.addPartyMember(dwarf);
        party.addPartyMember(knight);
        party.addPartyMember(warlock);
        party.addPartyMember(wizard);
        party.addPartyMember(otherBarbarian);

        assertEquals(
                new ArrayList<>(Arrays.asList(barbarian, cleric, dwarf, knight, warlock, wizard)),
                party.getPartyMembers()
        );
    }

    @Test
    public void canRemovePartyMember() {
        Barbarian barbarian = new Barbarian("Grog");
        party.addPartyMember(barbarian);
        party.removePartyMember(barbarian);
        assertEquals(
                new ArrayList<>(),
                party.getPartyMembers()
        );
    }


}
