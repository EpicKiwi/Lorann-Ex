package controller;

import contract.IController;
import contract.IModel;
import contract.IView;
import contract.Order;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

/**
 * The Class Controller.
 *
 * @author Baptiste
 */
public class Controller implements IController,Observer {

	/** The view. */
	private IView	view;

	/** The model. */
	private IModel	model;

	private Thread clockThread;
	private Clock clock;

	public static int LEVELID = 1;

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
		switch (order){
			case CHARACTER_DOWN:
				break;
			case CHARACTER_UP:
				break;
			case CHARACTER_LEFT:
				break;
			case CHARACTER_RIGHT:
				break;
			default:
				System.out.println("Not supported order : "+order.toString());
				break;
		}
	}

	/**
	 * Begin the game
	 */
	public void start(){
		if(this.model.loadLevel(1)){
			/*this.model.getObservable().addObserver(this.view.getObserver());
			this.view.openFrame();
			this.model.flush();*/

			this.clock = new Clock();
			this.clock.addObserver(this);
			this.clockThread = new Thread(this.clock);
			this.clockThread.start();
		} else {
			System.err.println("Can't load level id:"+LEVELID);

		}
	}

	/**
	 * Updated when a tick appen
	 * @param observable
	 * The observable object @see Clock
	 * @param o
	 * An object
     */
	public void update(Observable observable, Object o) {
		System.out.println("Tick n°"+this.clock.getTickNumber());
		this.model.getLevel();
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
