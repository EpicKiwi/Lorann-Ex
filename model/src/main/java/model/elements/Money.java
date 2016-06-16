package model.elements;

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
    }

    /**
     * Get the type of the element
     * @return money
     */
    public String getType() {
        return "money";
    }
}
