package model;

import contract.Direction;
import model.elements.*;
import model.elements.mocks.ElementMock;
import model.elements.mocks.EntityMock;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Tests the class Level
 */
public class LevelTest {

    Level t;
    Hero h;

    @Before
    public void setUp() throws Exception {
        h = new Hero(2,6);
        t = new Level(0,20,30,h,1);
    }

    @Test
    public void testSetElementShouldReplaceSpecifiedElement() throws Exception {
        Element e = new ElementMock(0,0);
        t.setElement(0,0,e);
        assertNotNull("Should not be null",t.getElements()[0][0]);
        assertSame("Should set a new element at specified place",e,t.getElements()[0][0]);
        Entity en = new EntityMock(0,0);
        t.setElement(0,0,en);
        assertNotSame("Should be stocked in the ArrayList",en,t.getElements()[0][0]);
        assertTrue("Should be stocked in ArrayList",t.getEntities().indexOf(en) != -1);
    }

    @Test
    public void testAddEntityShouldAddEntity() throws Exception {
        Entity e = new EntityMock(5,8);
        t.addEntity(e);
        assertTrue("Should be stocked in the entities ArrayList",t.getEntities().indexOf(e) != -1);
    }

    @Test
    public void testRemoveEntityShouldRemoveAnen() throws Exception {
        Entity e = new EntityMock(5,8);
        t.addEntity(e);
        assertTrue("Should be stocked in the entities ArrayList",t.getEntities().indexOf(e) != -1);
        t.removeEntity(e);
        assertTrue("Should be removed from the ArrayList",t.getEntities().indexOf(e) == -1);
    }

    @Test
    public void testGetNumberShouldRepresentNumber() throws Exception {
        t.setNumber(9);
        assertEquals("Should be modified",9,t.getNumber());
    }

    @Test
    public void testGetDimentionShouldRepresentTheDimentions() throws Exception {
        Dimention d = new Dimention(45,98);
        t.setDimention(d);
        assertSame("Should be modified",d,t.getDimention());
    }

    @Test
    public void testGetHeroShouldRepresentTheHero() throws Exception {
        assertSame("Should be the same",h,t.getHero());
        Hero hv = new Hero(9,2);
        t.setHero(hv);
        assertSame("Should be the same",hv,t.getHero());
    }

    @Test
    public void testGetElementsShouldReturnElementsArray() throws Exception {
        assertNotNull("Can't be null",t.getElements());
        assertTrue("Should be the height of the level",t.getElements().length == t.getDimention().getHeight());
        assertTrue("Should be the width of the level",t.getElements()[0].length == t.getDimention().getWidth());
    }

    @Test
    public void testIsFinishedShouldRepresentTheFinished() throws Exception {
        assertFalse("Basic, the level is not finished",t.isFinished());
        t.setFinished(true);
        assertTrue("Should be changed",t.isFinished());
    }

    @Test
    public void testGetValueShouldBeFixed() throws Exception {
        assertEquals("Should be 1000",1000,t.getValue());
    }
}