package contract;

import contract.IElement;

/**
 * Created by baptiste on 16/06/16.
 * set the state of the door
 */
public interface IDoor extends IElement {
	/**
	 * define if the door is locked or not
	 * @return
	 */
    boolean isUnlocked();

    /**
     * set the state of the door
     * @param unlocked
     */
    void setUnlocked(boolean unlocked);
}
