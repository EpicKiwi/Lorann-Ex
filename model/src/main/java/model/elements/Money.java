package model.elements;

import contract.Behavior;
import contract.IValuable;

/**
 * An item that give money to the hero
 */
public class Money extends Item implements IValuable {
    /**
     * location and image Money
     *
     * @param x
     * @param y
     */
    public Money(int x, int y) {
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

    public int getValue() {
        return 100;
    }
}
