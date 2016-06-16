package model.elements;

/**
 * The door of the level
 * @author Marie
 */
public class Door extends Element {
    /**
     * localisation and image Door
     * @param x
     * @param y
     * @param image
     */
    public Door(int x, int y, String image) {
        super(x, y, "sprites/gate_open.png");
    }

    public String getType() {
        return "door";
    }
}
