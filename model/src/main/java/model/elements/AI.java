package model.elements;

import contract.AIType;
import model.Sprite;

/**
 * @author Marie
 * Autonomous and entity
 */
public abstract class  AI extends Entity implements contract.IAI {

    /** The type of AI */
    protected AIType aiType;

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
    }

    /**
     * Get the type of Artificial intelligence of the object
     * @return
     * The AIType
     */
    public AIType getAiType() {
        return aiType;
    }

    /**
     * Set a new type of artificial intelligence
     * @param aiType
     * The new AIType
     */
    public void setAiType(AIType aiType) {
        this.aiType = aiType;
    }
}
