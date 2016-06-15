package model.behavior;

import contract.Behavior;
import contract.IElement;
import contract.ILevel;
import model.Level;
import model.elements.Element;

/**
 * A behavior of death of the player
 * @author Marie
 */
public class Death implements Behavior {

    /**
     * A method killing the hero
     * @param other
     * The other elements in the collision
     * @param level
     * The level
     */
    public void onCollision(IElement other, ILevel level) {

    }
}
