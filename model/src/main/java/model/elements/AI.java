package model.elements;

import model.Sprite;
import model.pathAi.PathAI;

/**
 * @author Marie
 * Autonomous and entity
 */
public class AI extends Entity {

    /** The autonomous path class */
    protected PathAI path;

    /**
     * instanciate the Object
     *
     * @param path
     */
    public AI(int x, int y, String image, PathAI path) {
        super(x, y, image);
        this.path = path;
    }

    public AI(int x, int y, Sprite sprite, PathAI path) {
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
