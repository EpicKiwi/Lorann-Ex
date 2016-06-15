package model.pathAi;

import model.Level;
import model.elements.AI;

/**
 *@author Marie
 * Interface of AI of monster
 */
public abstract class PathAI {

    /**The AI instance to move*/
    protected AI ai;

    /**
     * Instanciate the PathAi
     * @param ai
     * The entity to move
     */
    public PathAI(AI ai) {
        this.ai = ai;
    }

    /**
     * A method executed on each tick
     * @param level
     * The level
     */
    public abstract void onTick (Level level);

    // GETTERS & SETTERS //


    /**
     * Set the AI associated
     * @param ai
     */
    public void setAi(AI ai) {
        this.ai = ai;
    }

    /**
     * Get the AI associated
     * @return
     * The AI associated
     */
    public AI getAi() {
        return ai;
    }
}
