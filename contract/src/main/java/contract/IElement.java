package contract;

import java.awt.*;

/**
 * @author Baptiste
 * configure the element
 */
public interface IElement {

	/**
	 * define actions if the object collide with an other
	 * @param other
     * Other object
	 * @param level
     * Level of the element
	 */
    void onCollision(IElement other, ILevel level);

    /**
     * get the behavior of the element
     * @return
     * The behavior
     */
    Behavior getBehavior();

    /**
     * get the element's location on screen
     * @return
     * The location
     */
    ILocation getLocation();

    /**
     * Setter for the location
     * @param location
     * set the element's location on screen
     */
    void setLocation(ILocation location);

    /**
     * set the element's location on screen
     * @param x
     * Location x
     * @param y
     * Location y
     */
    void setLocation(int x, int y);

    /**
     * getter the image of the element that will appear on screen
     * @return
     * The sprite
     */
    ISprite getSprite();

    /**
     * Setter for the sprite
     * @param sprite
     * set the image of the element that will appear on screen
     */
    void setSprite(ISprite sprite);

    /**
     * define if the element can be walk trought or not
     * @return
     * A boolean true if it's permeable
     */
    boolean isPermeable();

    /**
     * get the image of an element that is stocked
     * @return
     * The current image of the element
     */
    Image getImage();
}
