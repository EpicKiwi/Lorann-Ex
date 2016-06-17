package contract;

import contract.IElement;

/**
 * Created by baptiste on 16/06/16.
 */
public interface IDoor extends IElement {
    boolean isUnlocked();

    void setUnlocked(boolean unlocked);
}
