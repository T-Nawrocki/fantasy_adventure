package enemy;

import enemy.types.MindFlayer;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MindFlayerTest {

    private MindFlayer mindFlayer;

    @Before
    public void before() {
        mindFlayer = new MindFlayer();
    }

    @Test
    public void hasName() {
        assertEquals("Mind Flayer", mindFlayer.getName());
    }

    @Test
    public void hasDescription() {
        assertEquals(
                "a cruel-looking humanoid with tentacles where its mouth should be, " +
                        "and a psychic aura surrounding it",
                mindFlayer.getDescription()
        );
    }

    @Test
    public void hasHealth() {
        assertEquals(80, mindFlayer.getHealth());
    }

    @Test
    public void hasStrength() {
        assertEquals(25, mindFlayer.getStrength());
    }

    @Test
    public void canLoseHealth() {
        mindFlayer.loseHealth(1);
        assertEquals(79, mindFlayer.getHealth());
    }

    @Test
    public void cannotGoBelow0Health() {
        mindFlayer.loseHealth(10000);
        assertEquals(0, mindFlayer.getHealth());
    }

}
