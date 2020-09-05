package enemy;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DragonTest {

    private Dragon dragon;

    @Before
    public void before() {
        dragon = new Dragon();
    }

    @Test
    public void hasName() {
        assertEquals("Dragon", dragon.getName());
    }

    @Test
    public void hasDescription() {
        assertEquals(
                "a giant, red dragon (it doesn't look very cooperative)",
                dragon.getDescription()
        );
    }

    @Test
    public void hasHealth() {
        assertEquals(200, dragon.getHealth());
    }

    @Test
    public void hasStrength() {
        assertEquals(35, dragon.getStrength());
    }

    @Test
    public void canLoseHealth() {
        dragon.loseHealth(1);
        assertEquals(199, dragon.getHealth());
    }

    @Test
    public void cannotGoBelow0Health() {
        dragon.loseHealth(10000);
        assertEquals(0, dragon.getHealth());
    }

}
