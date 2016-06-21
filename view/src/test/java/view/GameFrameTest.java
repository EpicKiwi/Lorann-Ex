package view;

import contract.IController;
import contract.Order;
import org.junit.Before;
import org.junit.Test;
import view.mock.ComponentMock;
import view.mock.ControllerMock;

import java.awt.event.KeyEvent;

import static org.junit.Assert.*;

/**
 * Tests GameFrame class
 */
public class GameFrameTest {

    GameFrame t;
    ControllerMock c;

    @Before
    public void setUp() throws Exception {
        c = new ControllerMock();
        t = new GameFrame();
        t.setController(c);
    }

    @Test
    public void testKeyPressedShouldUpCharacterUp() throws Exception {
        KeyEvent e = new KeyEvent(new ComponentMock(), 0, 0, 0, 0);
        e.setKeyCode(KeyEvent.VK_UP);
        this.t.keyPressed(e);
        assertEquals(Order.CHARACTER_UP, c.getLastOrder());
    }

    @Test
    public void testKeyPressedShouldUpCharacterW() throws Exception {
        KeyEvent e = new KeyEvent(new ComponentMock(), 0, 0, 0, 0);
        e.setKeyCode(KeyEvent.VK_W);
        this.t.keyPressed(e);
        assertEquals(Order.CHARACTER_UP, c.getLastOrder());
    }

    @Test
    public void testKeyPressedShouldUpCharacterZ() throws Exception {
        KeyEvent e = new KeyEvent(new ComponentMock(), 0, 0, 0, 0);
        e.setKeyCode(KeyEvent.VK_Z);
        this.t.keyPressed(e);
        assertEquals(Order.CHARACTER_UP, c.getLastOrder());
    }

    @Test
    public void testKeyPressedShouldLeftCharacterLeft() throws Exception {
        KeyEvent e = new KeyEvent(new ComponentMock(), 0, 0, 0, 0);
        e.setKeyCode(KeyEvent.VK_LEFT);
        this.t.keyPressed(e);
        assertEquals(Order.CHARACTER_LEFT, c.getLastOrder());
    }

    @Test
    public void testKeyPressedShouldLeftCharacterQ() throws Exception {
        KeyEvent e = new KeyEvent(new ComponentMock(), 0, 0, 0, 0);
        e.setKeyCode(KeyEvent.VK_Q);
        this.t.keyPressed(e);
        assertEquals(Order.CHARACTER_LEFT, c.getLastOrder());
    }

    @Test
    public void testKeyPressedShouldLeftCharacterRight() throws Exception {
        KeyEvent e = new KeyEvent(new ComponentMock(), 0, 0, 0, 0);
        e.setKeyCode(KeyEvent.VK_RIGHT);
        this.t.keyPressed(e);
        assertEquals(Order.CHARACTER_RIGHT, c.getLastOrder());
    }

    @Test
    public void testKeyPressedShouldLeftCharacterD() throws Exception {
        KeyEvent e = new KeyEvent(new ComponentMock(), 0, 0, 0, 0);
        e.setKeyCode(KeyEvent.VK_D);
        this.t.keyPressed(e);
        assertEquals(Order.CHARACTER_RIGHT, c.getLastOrder());
    }

    @Test
    public void testKeyPressedShouldLeftCharacterDown() throws Exception {
        KeyEvent e = new KeyEvent(new ComponentMock(), 0, 0, 0, 0);
        e.setKeyCode(KeyEvent.VK_DOWN);
        this.t.keyPressed(e);
        assertEquals(Order.CHARACTER_DOWN, c.getLastOrder());
    }

    @Test
    public void testKeyPressedShouldLeftCharacterS() throws Exception {
        KeyEvent e = new KeyEvent(new ComponentMock(), 0, 0, 0, 0);
        e.setKeyCode(KeyEvent.VK_S);
        this.t.keyPressed(e);
        assertEquals(Order.CHARACTER_DOWN, c.getLastOrder());
    }

    @Test
    public void testKeyPressedShouldSpellCharacter() throws Exception {
        KeyEvent e = new KeyEvent(new ComponentMock(), 0, 0, 0, 0);
        e.setKeyCode(KeyEvent.VK_SPACE);
        this.t.keyPressed(e);
        assertEquals(Order.CHARACTER_SPELL, c.getLastOrder());
    }
}