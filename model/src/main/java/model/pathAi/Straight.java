package model.pathAi;

import model.Level;
import model.elements.AI;

/**
 *@author Marie
 * Move straight
 */
public class Straight extends PathAI {

    /**
     * Instantiates the object
     * @param ai
     * The entity to move
     */
    public Straight(AI ai) {
        super(ai);
    }

    /**
     * Executed each tick
     * @param level
     * The level
     */
    public void onTick(Level level) {

    }
}