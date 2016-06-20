package controller;

import contract.Direction;
import contract.IElement;
import contract.IHero;
import contract.IModel;
import controller.mock.ElementMock;
import controller.mock.HeroMock;
import controller.mock.ModelMock;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Tests the class HeroManager
 */
public class HeroManagerTest {

    ModelMock m;
    IHero h;
    HeroManager t;

    @Before
    public void setUp() throws Exception {
        h = new HeroMock(5,5,Direction.DOWN);
        m = new ModelMock(h);
        m.loadLevel(0);
        MoveManager.init(m);
        HeroManager.init(m);
        t = HeroManager.getInstance();
    }

    @Test
    public void testMoveShouldMoveHeroUp() throws Exception {
        t.move(Direction.UP);
        assertEquals(5,h.getLocation().getX());
        assertEquals(4,h.getLocation().getY());
    }

    @Test
    public void testMoveShouldMoveHeroDown() throws Exception {
        t.move(Direction.DOWN);
        assertEquals(5,h.getLocation().getX());
        assertEquals(6,h.getLocation().getY());
    }

    @Test
    public void testMoveShouldMoveHeroLeft() throws Exception {
        t.move(Direction.LEFT);
        assertEquals(4,h.getLocation().getX());
        assertEquals(5,h.getLocation().getY());
    }

    @Test
    public void testMoveShouldMoveHeroRight() throws Exception {
        t.move(Direction.RIGHT);
        assertEquals(6,h.getLocation().getX());
        assertEquals(5,h.getLocation().getY());
    }

    @Test
    public void testMoveShouldMoveHeroTopLeft() throws Exception {
        t.move(Direction.TOPLEFT);
        assertEquals(4,h.getLocation().getX());
        assertEquals(4,h.getLocation().getY());
    }

    @Test
    public void testMoveShouldMoveHeroBottomRight() throws Exception {
        t.move(Direction.BOTTOMRIGHT);
        assertEquals(6,h.getLocation().getX());
        assertEquals(6,h.getLocation().getY());
    }

    @Test
    public void testMoveShouldntMoveHeroDown() throws Exception {
        m.getLevel().setElement(5,6,new ElementMock(5,6,false));
        t.move(Direction.DOWN);
        assertEquals(5,h.getLocation().getX());
        assertEquals(5,h.getLocation().getY());
    }

    @Test
    public void testSendSpellShouldCreateSpellDown() throws Exception {
        t.sendSpell();
        assertEquals(1,m.getLevel().getEntities().size());
        IElement spell = m.getLevel().getEntities().get(0);
        assertEquals(5,spell.getLocation().getX());
        assertEquals(6,spell.getLocation().getY());
    }

    @Test
    public void testSendSpellShouldCreateSpellLeft() throws Exception {
        h.setDirection(Direction.LEFT);
        t.sendSpell();
        assertEquals(1,m.getLevel().getEntities().size());
        IElement spell = m.getLevel().getEntities().get(0);
        assertEquals(4,spell.getLocation().getX());
        assertEquals(5,spell.getLocation().getY());
    }
}