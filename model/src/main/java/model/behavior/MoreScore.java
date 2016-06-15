package model.behavior;

import contract.Behavior;
import contract.IElement;
import contract.ILevel;
import model.Level;
import model.elements.Element;

/**
 * A beahavior where the player win points
 * @author Marie
 */
public class MoreScore implements Behavior {

    /**
     * Add points to the hero
     * @param other
     * The other elements in the collision
     * @param level
     * The level
     */
    public void onCollision(IElement other, ILevel level) {

    }
}
