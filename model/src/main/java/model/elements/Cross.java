package model.elements;

/**
 * A crossing wall that block the hero
 */
public class Cross extends Wall {
    /**
     * Localisation and image Cross
     *
     * @param x
     * The X position
     * @param y
     * The Y position
     */
    public Cross(int x, int y) {
        super(x, y, "sprites/bone.png");
    }
}
