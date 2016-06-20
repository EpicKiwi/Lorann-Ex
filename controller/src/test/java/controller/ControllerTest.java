package java.controller;

import controller.Controller;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class of the class Controller
 * @see Controller
 */

import static org.junit.Assert.*;

public class ControllerTest {
    Controller controller;
    boolean notified = false;

    @Before
    public void setUp() throws Exception {
        this.controller = new Controller();

    }

    @Test
    public void orderPerform() throws Exception {
        controller.orderPerform();
        assertNotNull("Press a button", controller.orderPerform());
        assertTrue("You have to press a button to move", controller.orderPerform());
        assertFalse("Unrecognized key", controller.orderPerform());

    }
    @Test
    public void update(Controller controller) {
        notified = true;
    }

    @Test
    public void hasCollision() throws Exception {
        assertFalse("You can't walk here", controller.equals(false));
        assertTrue("You can walk here", controller.equals(true));

    }

    @Test
    public void performCollision() throws Exception {
        assertNotNull("Collision can't be null", controller);

    }

    @Test
    public void setView() throws Exception {
        assertNotNull("Set the view can't be null", controller);

    }

    @Test
    public void setModel() throws Exception {
        assertNotNull("set model can't be null", controller);

    }

}