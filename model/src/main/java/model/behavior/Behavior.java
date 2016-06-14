package model.behavior;

import model.Level;
import model.elements.Element;

/**
 * An interface for the differents Behaviour of the éléments
 */
public interface Behavior {

    /**
     * A methods executed when a collision was triggered
     * @param other
     * The other elements in the collision
     * @param level
     * The level
     */
    public void onCollision(Element other, Level level);
}
