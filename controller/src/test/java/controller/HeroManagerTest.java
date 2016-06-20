package controller;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * The test class of the class HeroManager
 * @see controller.HeroManager
 */
public class HeroManagerTest {
    HeroManagerTest heroManagerTest;

    @Test
    public void testGetInstance() throws Exception {
        assertNotNull("Instance can't be null", heroManagerTest);

    }

    @Test
    public void testInit() throws Exception {
        assertNull("Return nothing", heroManagerTest);

    }

    @Test
    public void testMove() throws Exception {
        assertTrue("You can walk here",heroManagerTest.equals(true));
        assertFalse("You can't walk here", heroManagerTest.equals(false));


    }

    @Test
    public void testSendSpell() throws Exception {
        assertTrue("You can launch the spell", heroManagerTest.equals(true));
        assertFalse("You can't launch the spell", heroManagerTest.equals(false));

    }
}