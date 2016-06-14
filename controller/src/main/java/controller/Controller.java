package controller;

import contract.IController;
import contract.IModel;
import contract.IView;
import contract.Order;

/**
 * The Class Controller.
 *
 * @author Baptiste
 */
public class Controller implements IController {

	/** The view. */
	private IView	view;

	/** The model. */
	private IModel	model;

	/**
	 * Instantiates a new controller.
	 *
	 * @param view
	 *          the view
	 * @param model
	 *          the model
	 */
	public Controller(final IView view, final IModel model) {
		this.setView(view);
		this.setModel(model);
	}

	/**
	 * Perform an order to the controller
	 *
	 * @param order
	 * The order to perform
     */
	public void orderPerform(Order order) {

	}

	/**
	 * Begin the game
	 */
	public void start(){

	}

	// GETTERS & SETTERS //

	/**
	 * Sets the view.
	 *
	 * @param view
	 *          the new view
	 */
	public void setView(final IView view) {
		this.view = view;
	}

	/**
	 * Sets the model.
	 *
	 * @param model
	 *          the new model
	 */
	public void setModel(final IModel model) {
		this.model = model;
	}

}
