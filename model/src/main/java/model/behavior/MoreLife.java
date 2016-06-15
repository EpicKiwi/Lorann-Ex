package model.behavior;

import contract.Behavior;
import contract.IElement;
import contract.ILevel;
import model.Level;
import model.elements.Element;

/**
 * A behavior to increase the life of the player
 * @author Marie
 */
public class MoreLife implements Behavior {

    /**
     * Add a life to the hero
     * @param other
     * The other elements in the collision
     * @param level
     * The level
     */
    public void onCollision(IElement other, ILevel level) {

    }
}
