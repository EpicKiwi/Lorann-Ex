package model.elements;

import model.Location;
import model.Sprite;
import model.elements.mocks.ElementMock;
import org.junit.Before;
import org.junit.Test;

import java.util.Locale;
import java.util.Random;

import static org.junit.Assert.*;

/**
 * Tests for the class Element
 */
public class ElementTest {

    Element t;
    Random rnd;
    int x;
    int y;

    @Before
    public void setUp() throws Exception {
        rnd = new Random();
        x = rnd.nextInt(200)-100;
        y = rnd.nextInt(200)-100;
        t = new ElementMock(x,y);
    }

    @Test
    public void testGetImageShouldReturnValidImage() throws Exception{
        assertNotNull("Element should have an Image",t.getImage());
    }

    @Test
    public void testGetLocationShouldReturnSameCoordinates() throws Exception {
        assertNotNull("Element should have a location",t.getLocation());
        assertEquals("X position should be the same as the beginning",x,t.getLocation().getX());
        assertEquals("Y position should be the same as the beginning",y,t.getLocation().getY());
    }

    @Test
    public void testGetSpriteShouldReturnValidSprite() throws Exception {
        assertNotNull("Element should have a sprite",t.getSprite());
        assertNotNull("Element should have a sprite with an image",t.getSprite().getImage());
    }

    @Test
    public void testSetLocationShouldModifyLocation() throws Exception {
        Location nl = new Location(rnd.nextInt(200)-100,rnd.nextInt(200)-100);
        t.setLocation(nl);
        assertEquals("Set method need to set the new X position",t.getLocation().getX(),nl.getX());
        assertEquals("Set method need to set the new Y position",t.getLocation().getY(),nl.getY());
        t.setLocation(nl.getX(),nl.getY());
        assertEquals("Set method need to set the new X position",t.getLocation().getX(),nl.getX());
        assertEquals("Set method need to set the new Y position",t.getLocation().getY(),nl.getY());
    }

    @Test
    public void testSetSpriteShouldReplaceTheCurrentSprite() throws Exception {
        Sprite sprite = new Sprite("bone.png");
        t.setSprite(sprite);
        assertSame("The replced sprit doesn't the same",sprite,t.getSprite());
    }
}