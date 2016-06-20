package controller;

import contract.Direction;
import contract.IElement;
import contract.IEntity;
import contract.IModel;
import controller.mock.ElementMock;
import controller.mock.EntityMock;
import controller.mock.ModelMock;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * The test class of the class MoveManager
 * @see controller.MoveManager
 */
public class MoveManagerTest {

    MoveManager mm;
    IModel m;

    @Before
    public void setUp() throws Exception {
        this.m = new ModelMock();
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


}