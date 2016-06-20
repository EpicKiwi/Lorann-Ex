package controller.mock;

import contract.IController;
import contract.IView;

import java.util.Observer;

/**
 * Created by Marie on 20/06/2016.
 */
public class viewMock implements IView {
    public void repaint() {

    }

    public void openFrame() {

    }

    public Observer getObserver() {
        return null;
    }

    public void setController(IController controller) {

    }
}
