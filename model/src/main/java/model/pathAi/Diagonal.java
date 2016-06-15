package model.pathAi;

import contract.IAI;
import contract.ILevel;
import model.Level;
import model.elements.AI;

/**
 *@author Marie
 * Deplacement to diagonal
 */
public class Diagonal extends PathAI  {

    /**
     * Instantiates the object
     * @param ai
     * The Entity to move
     */
    public Diagonal(IAI ai) {
        super(ai);
    }

    /**
     * Method executed each tick
     * @param level
     * The level
     */
    public void onTick(ILevel level) {

    }
}
