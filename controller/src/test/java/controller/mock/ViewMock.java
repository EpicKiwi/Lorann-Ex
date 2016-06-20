package controller.mock;

import contract.IController;
import contract.IView;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by Marie on 20/06/2016.
 */
public class ViewMock implements IView,Observer {
    public void repaint() {

    }

    public void openFrame() {

    }

    public Observer getObserver() {
        return this;
    }

    public void setController(IController controller) {

    }

    public void update(Observable observable, Object o) {

    }
}
