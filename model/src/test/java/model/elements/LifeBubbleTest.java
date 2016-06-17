package model.elements;

import contract.Behavior;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Tests for the
 */
public class LifeBubbleTest {

    LifeBubble tst;

    @Before
    public void setUp() throws Exception {
        tst = new LifeBubble(45,95);
    }

    @Test
    public void getValue() throws Exception {
        assertNotNull(tst.getValue());
        assertEquals(tst.getValue(),75);
    }

    @Test
    public void getBehavior() throws Exception {
        assertNotNull(tst.getBehavior());
        assertEquals(tst.getBehavior(), Behavior.UNLOCK);
    }

    @Test
    public void isPermeable() throws Exception {
        assertTrue(tst.isPermeable());
    }

}