package model.elements;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Test the class Money
 */
public class MoneyTest {

    Money t;

    @Before
    public void setUp() throws Exception {
        t = new Money(4,65);
    }

    @Test
    public void testGetValueShouldBeFixed() throws Exception {
        assertEquals("The value of money should be 100",100,t.getValue());
    }

}