package model.elements;

import model.Location;
import model.Sprite;
import model.behavior.Behavior;

/**
 * An element of a level
 * @author Marie
 */
public class Element {
    /** The behavior of the élément */
    protected Behavior behavior;
    /** The location of the element */
    protected Location location;
    /** The sprite of the element */
    protected Sprite sprite;
    /** Set if an entity can walk hover the element */
    protected boolean permeable;

    /**
     * Instanciate the element
     * @param location
     * The location of the element
     * @param image
     * The path to the image of the element
     */
    public Element(Location location, String image) {
        this.location = location;
        this.sprite = new Sprite(image);
    }

    /**
     * Instanciate the element
     * @param x
     * The X position of the element
     * @param y
     * The Y Position of the element
     * @param image
     * The path to an image representing the element
     */
    public Element(int x, int y, String image) {
        this.location = new Location(x,y);
        this.sprite = new Sprite(image);
    }

    /**
     * Instanciate the element
     * @param x
     * The X Position of the element
     * @param y
     * The Y position of the element
     * @param sprite
     * The Sprite of the element
     */
    public Element(int x, int y, Sprite sprite) {
        this.location = new Location(x,y);
        this.sprite = sprite;
    }

    /**
     * Instanciate the element
     * @param location
     * The location of the element
     * @param sprite
     * The sprite of the element
     */
    public Element(Location location, Sprite sprite) {
        this.location = location;
        this.sprite = sprite;
    }

    // GETTERS & SETTERS //

    /**
     * Get the behavior of the element
     * @return
     * The behavior
     */
    public Behavior getBehavior() {
        return behavior;
    }

    /**
     * Get the location of the element
     * @return
     * The location
     */
    public Location getLocation() {
        return location;
    }

    /**
     * Set the new location
     * @param location
     * The location of the element
     */
    public void setLocation(Location location) {
        this.location = location;
    }

    /**
     * Set The new location of the element
     * @param x
     * The new X position
     * @param y
     * The new Y position
     */
    public void setLocation(int x, int y) {
        this.location.setX(x);
        this.location.setY(y);
    }

    /**
     * Get the sprite of the element
     * @return
     * The sprite
     */
    public Sprite getSprite() {
        return sprite;
    }

    /**
     * Set a new sprite to the element
     * @param sprite
     * The new sprite
     */
    public void setSprite(Sprite sprite) {
        this.sprite = sprite;
    }

    /**
     * Get if the element if permeable
     * @return
     */
    public boolean isPermeable() {
        return permeable;
    }
}
