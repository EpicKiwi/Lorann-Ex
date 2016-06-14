package model.elements;

import com.sun.javafx.scene.traversal.Direction;


/**
 * An element who can move an live
 */
public class Entity extends Element{
    /**
     * Direction of the entity
     */
    protected Direction direction;

    /**
     * Localisation and image entity
     * @param x
     * @param y
     * @param image
     */

    public Entity(int x, int y, String image) {
        super(x, y, image);
    }

    /**
     * Move the entity to a specified position
     * @param x
     * The new X position
     * @param y
     * The new Y position
     */
    public void moveTo(int x, int y){

    }
}
