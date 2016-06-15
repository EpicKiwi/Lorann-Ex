package model.pathAi;

import contract.IAI;
import model.Level;
import model.elements.AI;

/**
 *@author Marie
 * Interface of AI of monster
 */
public abstract class PathAI implements contract.IPathAI {

    /**The AI instance to move*/
    protected IAI ai;

    /**
     * Instanciate the PathAi
     * @param ai
     * The entity to move
     */
    public PathAI(IAI ai) {
        this.ai = ai;
    }

    // GETTERS & SETTERS //


    /**
     * Set the AI associated
     * @param ai
     */
    public void setAi(IAI ai) {
        this.ai = ai;
    }

    /**
     * Get the AI associated
     * @return
     * The AI associated
     */
    public IAI getAi() {
        return ai;
    }
}
