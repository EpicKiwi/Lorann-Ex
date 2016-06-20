package model.elements;

import contract.Behavior;
import org.junit.Before;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;

/**
 * Test class of Door class
 */
public class DoorTest {

    Door t;

    @Before
    public void setUp() throws Exception {
        t = new Door(45,56);
    }

    @Test
    public void testIsUnlockedShouldBeFalseDefault() throws Exception {
        assertFalse("By default the door should be closed",t.isUnlocked());
    }

    @Test
    public void testSetUnlockedShouldChangeStateUnlocked() throws Exception {
        t.setUnlocked(true);
        assertTrue("Should be unlocked",t.isUnlocked());
        t.setUnlocked(false);
        assertFalse("Shouldn't be unlocked",t.isUnlocked());
    }

    @Test
    public void testGetBehaviorShouldChangeOverUnlocked() throws Exception {
        t.setUnlocked(false);
        assertEquals("Locked, the door should be lethal",t.getBehavior(), Behavior.DEATH);
        t.setUnlocked(true);
        assertEquals("Unlocked, the door should finish the level",t.getBehavior(), Behavior.END);
    }

    @Test
    public void testGetImageShouldChangeOverUnlocked() throws Exception {
        t.setUnlocked(false);
        Image im = t.getImage();
        t.setUnlocked(true);
        assertNotSame("The door's image should change when locked",im,t.getImage());
    }

    @Test
    public void testIsPermeableShouldBeFalse() throws Exception {
        assertTrue("The door should be permeable",t.isPermeable());
    }

}