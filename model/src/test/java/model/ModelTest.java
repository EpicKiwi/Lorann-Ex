package model;

import model.elements.Hero;
import model.elements.mocks.ModelMock;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import static org.junit.Assert.*;

/**
 * Tests the class Model
 */
public class ModelTest implements Observer {

    Model t;
    boolean notified = false;

    @Before
    public void setUp() throws Exception {
        t = new ModelMock();
    }

    @Test
    public void testLoadLevelShouldCreateLevel() throws Exception {
        t.loadLevel(0);
        assertNotNull("Level can't be null after loading",t.getLevel());
        assertTrue("Hero should be alive at the beginning of the level",t.getLevel().getHero().isAlive());
        assertTrue("Hero should have a spell at the beginning of the level",t.getLevel().getHero().isSpell());
        assertFalse("Level shouldn't be finished at the beginning",t.getLevel().isFinished());
    }

    @Test
    public void testLoadAllLevelsShouldLoadArrayOfLevelsID() throws Exception {
        t.loadAllLevels();
        assertNotNull("Levels id can't be null",t.getLevelsId());
        assertTrue("Number of levels should be greater than 0",t.getLevelsId().size() > 0);
    }

    @Test
    public void testLoadNextLevelShouldSetNewLevelAsTheNext() throws Exception {
        t.loadAllLevels();
        ArrayList<Integer> ids = t.getLevelsId();
        t.loadLevel(ids.get(0));
        t.loadNextLevel();
        assertTrue("Should go to next level",t.getLevel().getId() == t.getLevelsId().get(1));
    }

    @Test
    public void testFlushShouldNotify() throws Exception {
        t.addObserver(this);
        assertFalse("Should notify only after flush",notified);
        t.flush();
        assertTrue("Should notify after flush",notified);
    }

    public void update(Observable observable, Object o) {
        notified = true;
    }

    @Test
    public void testGetObservableShouldReturnModel() throws Exception {
        assertNotNull("Observable can't be null",t.getObservable());
        assertTrue("Observable should be a model",t.getObservable() instanceof Model);
    }

    @Test
    public void testGetElementShouldReturnSpecifiedElementOfLevel() throws Exception {
        t.loadLevel(0);
        assertSame("Element should be the same as an element in the level",t.getElement(0,0),t.getLevel().getElements()[0][0]);
    }

    @Test
    public void testGetElementsShouldReturnElementsOfLevel() throws Exception {
        t.loadLevel(0);
        assertArrayEquals("Should return the elements of the level",t.getElements(),t.getLevel().getElements());
    }

    @Test
    public void testGetHeroShouldReturnValidHeroWithoutLevel() throws Exception {
        assertNotNull("Hero can't be null",t.getHero());
        assertTrue("Hero should be an instance of Hero",t.getHero() instanceof Hero);
    }
}