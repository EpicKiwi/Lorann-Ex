package model.elements;

/**
 * Horizontal wall that block the hero
 */
public class HWall extends Wall{
    /**
     * Localisation and image HWall
     *
     * @param x
     * The X position
     * @param y
     * The Y position
     */
    public HWall(int x, int y) {
        super(x, y, "sprites/horizontal_bone.png");
    }

    /**
     * Get the type of the element
     * @return horizontal-wall
     */
    public String getType() {
        return "horizontal-wall";
    }

    public String getLoadQuery(int id) {
        return null;
    }
}
