package model;

/**
 * A class representing the location of an element
 */
public class Location implements contract.ILocation {
    /** The X position */
    private int x;
    /** The Y position */
    private int y;

    /**
     * Instantiate the class
     * @param x
     * the X position
     * @param y
     * The Y position
     */
    public Location(int x, int y) {
        this.x = x;
        this.y = y;
    }

    // GETTER & SETTER //

    /**
     * Get The Y position
     * @return
     */
    public int getY() {
        return y;
    }

    /**
     * Set a new Y position
     * @param y
     * The new Y position
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * Get the X position
     * @return
     */
    public int getX() {
        return x;
    }

    /**
     * Set a new X position
     * @param x
     * The new X position
     */
    public void setX(int x) {
        this.x = x;
    }
}
