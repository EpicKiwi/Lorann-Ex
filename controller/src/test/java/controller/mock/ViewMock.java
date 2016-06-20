package controller.mock;

import contract.IController;
import contract.IView;

import java.util.Observable;
import java.util.Observer;

/**
 * Mock class of the view
 */
public class ViewMock implements IView,Observer {
    public void repaint() {
        // UNUSED METHOD
    }

    public void openFrame() {
        // UNUSED METHOD
    }

    public Observer getObserver() {
        return this;
    }

    public void setController(IController controller) {
        // UNUSED METHOD
    }

    public void update(Observable observable, Object o) {
        // UNUSED METHOD
    }
}
