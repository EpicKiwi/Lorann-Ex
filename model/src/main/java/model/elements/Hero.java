package model.elements;

/**
 * The hero of the game (Lorann)
 */
public class Hero extends Entity {
    /** The indicator of the capacity to the hero to launch a RAINBOW SPELLr <b>*o*</b> */
    boolean spell;
    /** The score of the player */
    int score;

    /**
     * Localisation and image hero
     *
     * @param x
     * @param y
     * @param image
     */
    public Hero(int x, int y, String image) {
        super(x, y, image);
    }
}
