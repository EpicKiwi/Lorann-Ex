package model.elements;

import model.pathAi.PathAI;

/**
 * @author Marie
 * Autonomous and entity
 */
public class AI extends Entity{
    /**
     * AI of pathAI
     */
    protected PathAI pathai;

    /**
     * Localisation and image AI
     *
     * @param x
     * @param y
     * @param image
     */
    public AI(int x, int y, String image) {
        super(x, y, image);
    }
}
