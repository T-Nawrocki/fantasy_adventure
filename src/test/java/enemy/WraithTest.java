package enemy;

import enemy.types.Wraith;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class WraithTest {

    private Wraith wraith;

    @Before
    public void before() {
        wraith = new Wraith();
    }

    @Test
    public void hasName() {
        assertEquals("Wraith", wraith.getName());
    }

    @Test
    public void hasDescription() {
        assertEquals(
                "a dark cloud of mist in vaguely human shape, " +
                        "with sharp claws and a shriveled, hateful face",
                wraith.getDescription()
        );
    }

    @Test
    public void hasHealth() {
        assertEquals(60, wraith.getHealth());
    }

    @Test
    public void hasStrength() {
        assertEquals(20, wraith.getStrength());
    }

    @Test
    public void canLoseHealth() {
        wraith.loseHealth(1);
        assertEquals(59, wraith.getHealth());
    }

    @Test
    public void cannotGoBelow0Health() {
        wraith.loseHealth(10000);
        assertEquals(0, wraith.getHealth());
    }

}
