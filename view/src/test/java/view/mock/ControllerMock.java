package view.mock;

import contract.IController;
import contract.IModel;
import contract.Order;

public class ControllerMock implements IController {

    Order last;

    public void orderPerform(Order order) {
        this.last = order;
    }

    public Order getLastOrder(){
        return last;
    }

    public void setModel(IModel model) {
        // UNUSED METHOD
    }

    public void start() {
        // UNUSED METHOD
    }
}
