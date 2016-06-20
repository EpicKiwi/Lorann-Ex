package model.elements;

import model.elements.mocks.WallMock;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Test of the class Wall
 */
public class WallTest {

    Wall t;

    @Before
    public void setUp() throws Exception {
        t = new WallMock(54,34);
    }

    @Test
    public void testIsPermeableShouldReturnFalse() throws Exception {
        assertFalse("A well shouldn't be permeable",t.isPermeable());
    }
}