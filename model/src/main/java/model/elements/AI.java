package model.elements;

import model.Sprite;
import model.pathAi.PathAI;

/**
 * @author Marie
 * Autonomous and entity
 */
public abstract class  AI extends Entity implements contract.IAI {

    /** The autonomous path class */
    protected PathAI path;

    /**
     * instanciate the Object
     *
     * @param x
     * The X position
     * @param y
     * The Y position
     * @param image
     * the path to the image representing the element
     */
    public AI(int x, int y, String image) {
        super(x, y, image);
        this.path = path;
    }

    /**
     * Instanciate the object
     * @param x
     * The X position
     * @param y
     * The Y position
     * @param sprite
     * The Sprite of the element
     */
    public AI(int x, int y, Sprite sprite) {
        super(x, y, sprite);
        this.path = path;
    }

    /**
     * Get the autonomous path class
     * @return
     * The autonomous path class
     */
    public PathAI getPath() {
        return path;
    }
}
