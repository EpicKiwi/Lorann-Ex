package model.elements;

import contract.Behavior;

/**
 * A bubble that open the door
 */
public class LifeBubble extends Item {
    /**
     * location and image LifeBubble
     *
     * @param x
     * @param y
     */
    public LifeBubble(int x, int y) {
        super(x, y, "sprites/crystal_ball.png");
        this.behavior = Behavior.UNLOCK;
        this.permeable = true;
    }

    /**
     * Get the type of the element
     * @return life-bubble
     */
    public String getType() {
        return "life-bubble";
    }
}
