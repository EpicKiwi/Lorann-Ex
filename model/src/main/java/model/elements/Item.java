package model.elements;

/**
 * A destroyable item
 */
public abstract class Item extends Element implements contract.IItem {
    /**
     * location and image Item
     * @param x
     * @param y
     * @param image
     */
    public Item(int x, int y, String image) {
        super(x, y, image);
        this.permeable = true;
    }
}
