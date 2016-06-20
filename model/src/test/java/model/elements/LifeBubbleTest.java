package model.elements;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Test the class LifeBubble
 */
public class LifeBubbleTest {

    LifeBubble t;

    @Before
    public void setUp() throws Exception {
        t = new LifeBubble(45,98);
    }

    @Test
    public void testGetValueShouldBeFixed() throws Exception {
        assertEquals("The value of life bubble should be 75",75,t.getValue());
    }

}