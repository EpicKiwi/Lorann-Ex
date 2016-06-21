package controller;

import contract.*;
import controller.mock.AiMock;
import controller.mock.ElementMock;
import controller.mock.HeroMock;
import controller.mock.ModelMock;
import org.junit.Before;
import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.*;

/**
 * The test class of the class AIManager
 * @see controller.AIManager
 */
public class AIManagerTest {

    AIManager t;
    IModel m;
    Random r;

    @Before
    public void setUp() throws Exception {
        r = new Random();
        m = new ModelMock(new HeroMock(5,5,Direction.DOWN));
        MoveManager.init(m);
        AIManager.init(m);
        t = AIManager.getInstance();
    }

    @Test
    public void testPerformAiShouldDoNothing() throws Exception {
        IAI e = new AiMock(5,8, Direction.DOWN, AIType.NOTHING);

        t.performAi(e);

        assertEquals(5,e.getLocation().getX());
        assertEquals(8,e.getLocation().getY());
    }

    @Test
    public void testPerformAiShouldStepDown() throws Exception {
        IAI e = new AiMock(5,8, Direction.DOWN, AIType.STRAIGHT);

        t.performAi(e);

        assertEquals(5,e.getLocation().getX());
        assertEquals(9,e.getLocation().getY());
    }

    @Test
    public void testPerformAiShouldStepLeft() throws Exception {
        IAI e = new AiMock(5,8, Direction.LEFT, AIType.STRAIGHT);

        t.performAi(e);

        assertEquals(4,e.getLocation().getX());
        assertEquals(8,e.getLocation().getY());
    }

    @Test
    public void testPerformAiShouldGoBack() throws Exception {
        IAI e = new AiMock(5,8, Direction.UP, AIType.STRAIGHT);
        m.getLevel().setElement(5,7,new ElementMock(5,7,false));

        t.performAi(e);

        assertEquals(5,e.getLocation().getX());
        assertEquals(9,e.getLocation().getY());
        assertEquals(Direction.DOWN,e.getDirection());
    }

    @Test
    public void testPerformAiShouldGoInDiagonal() throws Exception {
        IAI e = new AiMock(5,8, Direction.TOPLEFT, AIType.DIAGONAL);

        t.performAi(e);

        assertEquals(4,e.getLocation().getX());
        assertEquals(7,e.getLocation().getY());
    }

    @Test
    public void testPerformAiShouldGoRandomly() throws Exception {
        IAI e = new AiMock(5,8, Direction.UNDEFINED, AIType.RANDOM);

        t.performAi(e);

        assertTrue(e.getLocation().getX() <= 6 && e.getLocation().getX() >= 4);
        assertTrue(e.getLocation().getY() >= 7 && e.getLocation().getY() <= 9);
    }

    @Test
    public void testPerformAiShouldGoToHero() throws Exception {
        IAI e = new AiMock(5,8, Direction.UNDEFINED, AIType.FOLLOW);


        IHero h = new HeroMock(7,8,Direction.DOWN);
        m.loadLevel(0);
        m.getLevel().setHero(h);

        t.performAi(e);

        assertEquals(5,e.getLocation().getX());
        assertEquals(7,e.getLocation().getY());
    }

}