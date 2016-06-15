package model.behavior;

import contract.Behavior;
import contract.IElement;
import contract.ILevel;
import model.Level;
import model.elements.Element;

/**
 * A Behavior of the end of the level
 * @author Marie
 */
public class End implements Behavior {

    /**
     * End the level
     * @param other
     * The other elements in the collision
     * @param level
     * The level
     */
    public void onCollision(IElement other, ILevel level) {

    }
}
