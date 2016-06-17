package model.elements;

import contract.Behavior;
import contract.IValuable;

/**
 * A bubble that open the door
 */
public class LifeBubble extends Item implements IValuable {
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

    public int getValue() {
        return 75;
    }
}
