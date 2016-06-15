package model;

/**
 * A class representing the location of an element
 */
public class Location implements contract.ILocation {
    /** The X position */
    private Integer x;
    /** The Y position */
    private Integer y;

    /**
     * Instantiate the class
     * @param x
     * the X position
     * @param y
     * The Y position
     */
    public Location(Integer x, Integer y) {
        this.x = x;
        this.y = y;
    }

    // GETTER & SETTER //

    /**
     * Get The Y position
     * @return
     */
    public Integer getY() {
        return y;
    }

    /**
     * Set a new Y position
     * @param y
     * The new Y position
     */
    public void setY(Integer y) {
        this.y = y;
    }

    /**
     * Get the X position
     * @return
     */
    public Integer getX() {
        return x;
    }

    /**
     * Set a new X position
     * @param x
     * The new X position
     */
    public void setX(Integer x) {
        this.x = x;
    }
}
