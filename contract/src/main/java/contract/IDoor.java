package contract;

import contract.IElement;

/**
 * @author Baptiste
 * set the state of the door
 */
public interface IDoor extends IElement {
	/**
	 * Getter if the door is unlocked
	 * @return
	 * define if the door is locked or not
	 */
    boolean isUnlocked();

    /**
     * Setter for the door unlocked
     * @param unlocked
	 * set the state of the door
     */
    void setUnlocked(boolean unlocked);
}
