package model.elements;

import contract.Behavior;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Tests of Hero class
 */
public class HeroTest {

    Hero tst;

    @Before
    public void setUp() throws Exception {
        tst = new Hero(54,98);
    }

    @Test
    public void getScore() throws Exception {
        assertNotNull(tst.getScore());
        assertEquals(0,(int) tst.getScore());
    }

    @Test
    public void setScore() throws Exception {
        tst.setScore(500);
        assertEquals(500,(int) tst.getScore());
    }

    @Test
    public void isSpell() throws Exception {
        assertTrue(tst.isSpell());
    }

    @Test
    public void setSpell() throws Exception {
        tst.setSpell(false);
        assertFalse(tst.isSpell());
        tst.setSpell(true);
        assertTrue(tst.isSpell());
    }

    @Test
    public void isAlive() throws Exception {
        assertTrue(tst.isAlive());
    }

    @Test
    public void setAlive() throws Exception {
        tst.setAlive(false);
        assertFalse(tst.isAlive());
        tst.setAlive(true);
        assertTrue(tst.isAlive());
    }

    @Test
    public void getBehavior() throws Exception {
        assertNull(tst.getBehavior());
    }

    @Test
    public void isPermeable() throws Exception {
        assertTrue(tst.isPermeable());
    }

}