package model.elements;

/**
 * A wall element that block the hero
 */
public abstract class Wall extends Element {
    /**
     * Localisation and image Wall
     * @param x
     * @param y
     * @param image
     */
    public Wall(int x, int y, String image) {
        super(x, y, image);
    }
}
