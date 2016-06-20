package controller;

import contract.*;
import controller.mock.*;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Tests the class Collision manager
 */
public class CollisionManagerTest {

    IModel m;
    CollisionManager t;

    @Before
    public void setUp() throws Exception {
        m = new ModelMock(new HeroMock(5,5,Direction.DOWN));
        CollisionManager.init(m);
        t = CollisionManager.getInstance();
    }

    @Test
    public void testPerformCollisionShouldKillTheHero() throws Exception {
        IHero h = new HeroMock(0,0,Direction.DOWN);
        EntityMock e = new EntityMock(0,0,true, Direction.UNDEFINED);
        e.setBehavior(Behavior.DEATH);

        t.performCollision(e,h);

        assertFalse(h.isAlive());
    }

    @Test
    public void testPerformCollisionShouldEarnPoints() throws Exception {
        IHero h = new HeroMock(0,0,Direction.DOWN);
        h.setScore(0);
        EntityMock e = new EntityMock(0,0,true, Direction.UNDEFINED);
        e.setBehavior(Behavior.MOREPOINT);

        t.performCollision(e,h);

        assertEquals(e.getValue(),(int) h.getScore());
    }

    @Test
    public void testPerformCollisionShouldEndLevel() throws Exception {
        IHero h = new HeroMock(0,0,Direction.DOWN);
        EntityMock e = new EntityMock(0,0,true, Direction.UNDEFINED);
        e.setBehavior(Behavior.END);

        t.performCollision(e,h);

        assertTrue(m.getLevel().isFinished());
    }

    @Test
    public void testPerformCollisionShouldUnlockDoors() throws Exception {
        IHero h = new HeroMock(0,0,Direction.DOWN);
        EntityMock e = new EntityMock(0,0,true, Direction.UNDEFINED);
        e.setBehavior(Behavior.UNLOCK);
        IDoor d = new DoorMock(5,8);
        m.getLevel().setElement(5,8,d);

        t.performCollision(e,h);

        assertTrue(d.isUnlocked());
    }

    @Test
    public void testPerformCollisionShouldGetSpell() throws Exception {
        IHero h = new HeroMock(0,0,Direction.DOWN);
        h.setSpell(false);
        EntityMock e = new EntityMock(0,0,true, Direction.UNDEFINED);
        e.setBehavior(Behavior.SPELL);

        t.performCollision(e,h);

        assertTrue(h.isSpell());
    }

    @Test
    public void testPerformCollisionShouldKillMonster() throws Exception {
        EntityMock e = new EntityMock(0,0,true, Direction.UNDEFINED);
        e.setBehavior(Behavior.SPELL);

        IMonster m = new MonsterMock(0,0,Direction.DOWN,AIType.NOTHING);
        this.m.getLevel().addEntity(m);

        t.performCollision(e,m);

        assertEquals(-1,this.m.getLevel().getEntities().indexOf(m));
    }
}