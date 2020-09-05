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
    public void partyMembersStartsEmpty() {
        assertEquals(
                new ArrayList<>(),
                party.getPartyMembers()
        );
    }

    @Test
    public void canAddPartyMember() {
        Barbarian barbarian = new Barbarian();
        party.addPartyMember(barbarian);
        assertEquals(
                new ArrayList<>(Collections.singletonList(barbarian)),
                party.getPartyMembers()
        );
    }

    @Test
    public void cannotAddExistingPartyMember() {
        Barbarian barbarian = new Barbarian();
        party.addPartyMember(barbarian);
        party.addPartyMember(barbarian);
        assertEquals(
                new ArrayList<>(Collections.singletonList(barbarian)),
                party.getPartyMembers()
        );
    }

    @Test
    public void cannotAddMoreThanSixPartyMembers() {
        Barbarian barbarian = new Barbarian();
        Cleric cleric = new Cleric();
        Dwarf dwarf = new Dwarf();
        Knight knight = new Knight();
        Warlock warlock = new Warlock();
        Wizard wizard = new Wizard();
        Barbarian otherBarbarian = new Barbarian();

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


}
