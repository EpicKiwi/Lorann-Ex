package model.elements;

import contract.Behavior;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * tests of class Money class
 */
public class MoneyTest {

    Money tst;

    @Before
    public void setUp() throws Exception {
        tst = new Money(45,21);
    }

    @Test
    public void getValue() throws Exception {
        assertNotNull(tst.getValue());
        assertEquals(tst.getValue(),100);
    }

    @Test
    public void getBehavior() throws Exception {
        assertNotNull(tst.getBehavior());
        assertEquals(tst.getBehavior(), Behavior.MOREPOINT);
    }

    @Test
    public void isPermeable() throws Exception {
        assertTrue(tst.isPermeable());
    }

}