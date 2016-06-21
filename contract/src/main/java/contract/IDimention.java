package contract;

/**
 * @author Baptiste
 * size of the screen
 */
public interface IDimention {

	/**
	 * getter for the width
	 * @return
     * get the width of the screen
	 */
    int getWidth();

    /**
     * Setter for the width
     * @param width
     * set the width of the screen
     */
    void setWidth(int width);

    /**
     * Getter for the height
     * @return
     * get the height of the screen
     */
    int getHeight();

    /**
     * Setter for the height
     * @param height
     * set the height of the screen
     */
    void setHeight(int height);
}
