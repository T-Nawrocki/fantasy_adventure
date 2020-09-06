package enemy;

import enemy.types.Hobgoblin;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HobgoblinTest {

    private Hobgoblin hobgoblin;

    @Before
    public void before() {
        hobgoblin = new Hobgoblin();
    }

    @Test
    public void hasName() {
        assertEquals("Hobgoblin", hobgoblin.getName());
    }

    @Test
    public void hasDescription() {
        assertEquals(
                "a large goblin-like creature that's covered in fur, holding a spiked mace",
                hobgoblin.getDescription()
        );
    }

    @Test
    public void hasHealth() {
        assertEquals(40, hobgoblin.getHealth());
    }

    @Test
    public void hasStrength() {
        assertEquals(15, hobgoblin.getStrength());
    }

    @Test
    public void canLoseHealth() {
        hobgoblin.loseHealth(1);
        assertEquals(39, hobgoblin.getHealth());
    }

    @Test
    public void cannotGoBelow0Health() {
        hobgoblin.loseHealth(10000);
        assertEquals(0, hobgoblin.getHealth());
    }

}
