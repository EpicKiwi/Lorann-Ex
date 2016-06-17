package model.elements;

import model.Location;
import model.Sprite;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Tests of Element class
 */
public class ElementTest {

    Door tst; //Can't instantiate element because it's abstract

    @Before
    public void setUp() throws Exception {
        tst = new Door(5,8);
    }

    @Test
    public void getLocation() throws Exception {
        assertNotNull(tst.getLocation());
        assertEquals(new Location(5,8).getX(),tst.getLocation().getX());
        assertEquals(new Location(5,8).getY(),tst.getLocation().getY());
    }

    @Test
    public void setLocation() throws Exception {
        Location loc = new Location(48,65);
        tst.setLocation(loc);
        assertSame(tst.getLocation(),loc);
    }

    @Test
    public void getSprite() throws Exception {
        assertNotNull(tst.getSprite());
    }

    @Test
    public void setSprite() throws Exception {
        Sprite spr = new Sprite("bone.png");
        tst.setSprite(spr);
        assertSame(tst.getSprite(),spr);
    }

    @Test
    public void getImage() throws Exception {
        assertNotNull(tst.getImage());
        Sprite spr = new Sprite("bone.png");
        tst.setSprite(spr);
        assertNotNull(tst.getImage());
    }

}