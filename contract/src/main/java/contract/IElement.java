package contract;

import java.awt.*;

/**
 * Created by baptiste on 15/06/16.
 * configure the element
 */
public interface IElement {

	/**
	 * define actions if the object collide with an other
	 * @param other
	 * @param level
	 */
    void onCollision(IElement other, ILevel level);

    /**
     * get the behavior of the element
     * @return
     */
    Behavior getBehavior();

    /**
     * get the element's location on screen
     * @return
     */
    ILocation getLocation();

    /**
     * set the element's location on screen
     * @param location
     */
    void setLocation(ILocation location);

    /**
     * set the element's location on screen
     * @param x
     * @param y
     */
    void setLocation(int x, int y);

    /**
     * get the image of the element that will appear on screen
     * @return
     */
    ISprite getSprite();

    /**
     * set the image of the element that will appear on screen
     * @param sprite
     */
    void setSprite(ISprite sprite);

    /**
     * define if the element can be walk trought or not
     * @return
     */
    boolean isPermeable();

    /**
     * get the image of an element that is stocked
     * @return
     */
    Image getImage();
}
