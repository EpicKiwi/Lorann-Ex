package controller;

import contract.Direction;
import contract.IElement;
import contract.IEntity;
import contract.IModel;
import controller.mock.ElementMock;
import controller.mock.EntityMock;
import controller.mock.HeroMock;
import controller.mock.ModelMock;
import org.junit.Before;
import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.*;

/**
 * The test class of the class MoveManager
 * @see controller.MoveManager
 */
public class MoveManagerTest {

    MoveManager mm;
    IModel m;
    Random r;

    @Before
    public void setUp() throws Exception {
        r = new Random();
        this.m = new ModelMock(new HeroMock(5,5,Direction.DOWN));
        MoveManager.init(m);
        mm = MoveManager.getInstance();
    }

    @Test
    public void testGetInstanceShouldReturnEveryTimesSameInstance() throws Exception {
        assertNotNull(MoveManager.getInstance());
        assertSame(MoveManager.getInstance(),MoveManager.getInstance());
    }

    @Test
    public void testHasCollisionShouldReturnNull() throws Exception {
        IElement e = new ElementMock(2,6,false);

        //Element not at the position
        m.getLevel().setElement(1,6,new ElementMock(1,6,true));
        assertNull(mm.hasCollision(e));
    }

    @Test
    public void testHasCollisionShouldReturnOtherElement() throws Exception {
        IElement e = new ElementMock(2,6,false);

        //Element at the position
        IElement oth = new ElementMock(1,6,true);
        m.getLevel().setElement(2,6,oth);
        assertNotNull(mm.hasCollision(e));
        assertSame(oth,mm.hasCollision(e));
    }

    @Test
    public void testHasCollisionShouldReturnOtherEntity() throws Exception {
        IElement e = new ElementMock(2,6,false);

        //Entity at the position
        IEntity oth2 = new EntityMock(2,6,true, Direction.DOWN);
        m.getLevel().addEntity(oth2);
        assertNotNull(mm.hasCollision(e));
        assertSame(oth2,mm.hasCollision(e));
    }

    @Test
    public void testHasCollisionShouldReturnHero() throws Exception {
        m.getLevel().getHero().setLocation(5,6);

        //Entity at the position
        IEntity oth2 = new EntityMock(5,6,true, Direction.DOWN);
        m.getLevel().addEntity(oth2);
        assertNotNull(mm.hasCollision(m.getLevel().getHero()));
        assertSame(oth2,mm.hasCollision(m.getLevel().getHero()));
    }

    @Test
    public void testCanMoveOnShouldReturnFalse() throws Exception {
        m.getLevel().setElement(2,6,new ElementMock(2,6,false));

        assertFalse(mm.canMoveOn(15,6)); //Out of the level (width)
        assertFalse(mm.canMoveOn(2,23)); //Out of the level (height)
        assertFalse(mm.canMoveOn(2,6)); //On a not permeable element
    }

    @Test
    public void testCanMoveOnShouldReturnTrue() throws Exception {
        m.getLevel().setElement(2,6,new ElementMock(2,6,true));

        assertTrue(mm.canMoveOn(r.nextInt(10),r.nextInt(20))); //In level
        assertTrue(mm.canMoveOn(2,6)); //On permeable element
    }

    @Test
    public void testSafeMoveToShouldMoveEntity() throws Exception {
        IEntity e = new EntityMock(5,8,false,Direction.DOWN);

        assertTrue(mm.safeMoveTo(e,6,8));
        assertEquals(6,e.getLocation().getX());
        assertEquals(8,e.getLocation().getY());
    }

    @Test
    public void testSafeMoveToShouldntMoveEntity() throws Exception {
        IEntity e = new EntityMock(5,8,false,Direction.DOWN);
        m.getLevel().setElement(2,6,new ElementMock(2,6,false));

        assertFalse(mm.safeMoveTo(e,15,6)); //Out of the level (width)
        assertEquals(5,e.getLocation().getX());
        assertEquals(8,e.getLocation().getY());

        assertFalse(mm.safeMoveTo(e,2,23)); //Out of the level (height)
        assertEquals(5,e.getLocation().getX());
        assertEquals(8,e.getLocation().getY());

        assertFalse(mm.safeMoveTo(e,2,6)); //On a not permeable element
        assertEquals(5,e.getLocation().getX());
        assertEquals(8,e.getLocation().getY());
    }
}