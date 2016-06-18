package model.elements;

import contract.Direction;
import model.elements.mocks.EntityMock;
import org.junit.Before;
import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.*;

/**
 * Test of the class Entity
 */
public class EntityTest {

    Entity t;
    Random rnd;

    @Before
    public void setUp() throws Exception {
        t = new EntityMock(87,23);
        rnd = new Random();
    }

    @Test
    public void testMoveToShouldChangePosition() throws Exception {
        int x = rnd.nextInt(200)-100,y = rnd.nextInt(200)-100;
        t.moveTo(x,y);
        assertEquals("The X position should be the same",x,t.getLocation().getX());
        assertEquals("The Y position should be the same",y,t.getLocation().getY());
    }

    @Test
    public void testSetDirectionShouldChangeDirection() throws Exception {
        t.setDirection(Direction.BOTTOMLEFT);
        assertEquals("The direction should change",Direction.BOTTOMLEFT,t.getDirection());
        t.setDirection(Direction.TOPRIGHT);
        assertEquals("The direction should change",Direction.TOPRIGHT,t.getDirection());
    }
}