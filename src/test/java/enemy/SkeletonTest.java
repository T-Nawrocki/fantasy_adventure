package enemy;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SkeletonTest {

    private Skeleton skeleton;

    @Before
    public void before() {
        skeleton = new Skeleton();
    }

    @Test
    public void hasName() {
        assertEquals("Skeleton", skeleton.getName());
    }

    @Test
    public void hasDescription() {
        assertEquals(
                "a reanimated Skeleton with a rusted sword and broken helmet",
                skeleton.getDescription()
        );
    }

    @Test
    public void hasHealth() {
        assertEquals(20, skeleton.getHealth());
    }

    @Test
    public void hasStrength() {
        assertEquals(10, skeleton.getStrength());
    }

    @Test
    public void canLoseHealth() {
        skeleton.loseHealth(1);
        assertEquals(19, skeleton.getHealth());
    }

    @Test
    public void cannotGoBelow0Health() {
        skeleton.loseHealth(10000);
        assertEquals(0, skeleton.getHealth());
    }

}
