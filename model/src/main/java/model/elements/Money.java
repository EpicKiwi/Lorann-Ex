package model.elements;

import contract.Behavior;

/**
 * An item that give money to the hero
 */
public class Money extends Item {
    /**
     * location and image Money
     *
     * @param x
     * @param y
     * @param image
     */
    public Money(int x, int y, String image) {
        super(x, y, "sprites/purse.png");
        this.behavior = Behavior.MOREPOINT;
    }

    /**
     * Get the type of the element
     * @return money
     */
    public String getType() {
        return "money";
    }
}
