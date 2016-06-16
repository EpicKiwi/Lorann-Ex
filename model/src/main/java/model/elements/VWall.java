package model.elements;

/**
 * A vertical wall that block the hero
 */
public class VWall extends Wall
{
    /**
     * Localisation and image VWall
     *
     * @param x
     * The X position
     * @param y
     * The Y position
     */
    public VWall(int x, int y) {
        super(x, y, "sprites/vertical_bone.png");
    }

    /**
     * Get the type of the element
     * @return vertical-wall
     */
    public String getType() {
        return "vertical-wall";
    }
}
