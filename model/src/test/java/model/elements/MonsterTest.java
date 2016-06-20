package model.elements;

import contract.AIType;
import contract.Direction;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Test of the class Monster
 */
public class MonsterTest {

    Monster t1;
    Monster t2;
    Monster t3;
    Monster t4;

    @Before
    public void setUp() throws Exception {
        t1 = new Monster(45,96, Direction.DOWN);
        t2 = new Monster(97,36, Direction.BOTTOMLEFT);
        t3 = new Monster(2,51, Direction.UNDEFINED);
        t4 = new Monster(57,95, Direction.FOLLOW);
    }

    @Test
    public void testGetImageShouldBeDifferent() throws Exception {
        assertNotSame(t1.getSprite(),t2.getSprite());
        assertNotSame(t1.getSprite(),t3.getSprite());
        assertNotSame(t1.getSprite(),t4.getSprite());
        assertNotSame(t2.getSprite(),t3.getSprite());
        assertNotSame(t2.getSprite(),t4.getSprite());
        assertNotSame(t3.getSprite(),t4.getSprite());
    }

    @Test
    public void testGetAiTypeShouldBeDifferent() throws Exception {
        assertEquals(AIType.STRAIGHT,t1.getAiType());
        assertEquals(AIType.DIAGONAL,t2.getAiType());
        assertEquals(AIType.RANDOM,t3.getAiType());
        assertEquals(AIType.FOLLOW,t4.getAiType());
    }

    @Test
    public void testGetValueShouldBeDifferent() throws Exception {
        assertEquals("Straight monster should have a value of 150",150,t1.getValue());
        assertEquals("Diagonal monster should have a value of 225",225,t2.getValue());
        assertEquals("Random monster should have a value of 285",285,t3.getValue());
        assertEquals("Follow monster should have a value of 315",315,t4.getValue());
    }
}