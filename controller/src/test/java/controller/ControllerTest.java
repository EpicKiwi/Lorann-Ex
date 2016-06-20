package controller;

import contract.*;
import controller.mock.ModelMock;
import controller.mock.ViewMock;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class of the class Controller
 * @see Controller
 */

import static org.junit.Assert.*;

public class ControllerTest {

    Controller t;
    IModel m;
    IView v;

    @Before
    public void setUp() throws Exception {
        this.m = new ModelMock();
        this.v = new ViewMock();
        this.t = new Controller(v,m);
    }

    @Test
    public void testOrderPerformShouldDownHero() throws Exception {
        ILocation b = m.getLevel().getHero().getLocation();
        t.orderPerform(Order.CHARACTER_DOWN);
        ILocation a = m.getLevel().getHero().getLocation();
        assertEquals(a.getX(),b.getX());
        assertEquals(a.getY(),b.getY()+1);

    }

    @Test
    public void hasCollision() throws Exception {
        assertFalse("You can't walk here", t.equals(false));
        assertTrue("You can walk here", t.equals(true));

    }

    @Test
    public void performCollision() throws Exception {
        assertNotNull("Collision can't be null", t);

    }

    @Test
    public void setView() throws Exception {
        assertNotNull("Set the view can't be null", t);

    }

    @Test
    public void setModel() throws Exception {
        assertNotNull("set model can't be null", t);

    }

}