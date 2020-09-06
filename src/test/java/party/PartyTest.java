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
    private Barbarian barbarian;
    private Cleric cleric;
    private Dwarf dwarf;
    private Knight knight;
    private Warlock warlock;
    private Wizard wizard;
    private Barbarian otherBarbarian;


    @Before
    public void before() {
        party.resetInstance();
        barbarian = new Barbarian("Grog");
        cleric = new Cleric("Pike");
        dwarf = new Dwarf("Tova");
        knight = new Knight("Vax");
        warlock = new Warlock("Percy");
        wizard = new Wizard("Caleb");
        otherBarbarian = new Barbarian("Yasha");
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
        party.addPartyMember(barbarian);
        assertEquals(
                new ArrayList<>(Collections.singletonList(barbarian)),
                party.getPartyMembers()
        );
    }

    @Test
    public void cannotAddExistingPartyMember() {
        party.addPartyMember(barbarian);
        party.addPartyMember(barbarian);
        assertEquals(
                new ArrayList<>(Collections.singletonList(barbarian)),
                party.getPartyMembers()
        );
    }

    @Test
    public void cannotAddMoreThanSixPartyMembers() {
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
        party.addPartyMember(barbarian);
        party.removePartyMember(barbarian);
        assertEquals(
                new ArrayList<>(),
                party.getPartyMembers()
        );
    }

    @Test
    public void canGetPartyDescriptionEmptyParty() {
        assertEquals("no-one", party.partyDescription());
    }

    @Test
    public void canGetPartyDescriptionPartyOfOne() {
        party.addPartyMember(barbarian);
        assertEquals("Grog the Barbarian", party.partyDescription());
    }

    @Test
    public void canGetPartyDescriptionPartyOfTwo() {
        party.addPartyMember(barbarian);
        party.addPartyMember(cleric);
        assertEquals("Grog the Barbarian and Pike the Cleric", party.partyDescription());
    }

    @Test
    public void canGetPartyDescriptionPartyOfThreePlus() {
        party.addPartyMember(barbarian);
        party.addPartyMember(cleric);
        party.addPartyMember(warlock);
        assertEquals(
                "Grog the Barbarian, Pike the Cleric and Percy the Warlock",
                party.partyDescription()
        );
    }


}
