package controller;

import contract.*;
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

	/** The clock of the game */
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
		MoveManager.init(this.model);
		AIManager.init(this.model);
		CollisionManager.init(this.model);
	}

	/**
	 * Perform an order to the controller
	 *
	 * @param order
	 * The order to perform
     */
	public void orderPerform(Order order) {
		IHero hero = this.model.getLevel().getHero();
		ILocation heroLocation = hero.getLocation();
		MoveManager mm = MoveManager.getInstance();

		switch (order){
			case CHARACTER_DOWN:
				mm.safeMoveTo(hero,heroLocation.getX(),heroLocation.getY()+1);
				break;
			case CHARACTER_UP:
				mm.safeMoveTo(hero,heroLocation.getX(),heroLocation.getY()-1);
				break;
			case CHARACTER_LEFT:
				mm.safeMoveTo(hero,heroLocation.getX()-1,heroLocation.getY());
				break;
			case CHARACTER_RIGHT:
				mm.safeMoveTo(hero,heroLocation.getX()+1,heroLocation.getY());
				break;
			default:
				System.out.println("Not supported order : "+order.toString());
				break;
		}
		this.model.flush();
	}

	/**
	 * Begin the game
	 */
	public void start(){
		if(this.model.loadLevel(1)){
			this.model.getObservable().addObserver(this.view.getObserver());
			this.clock = new Clock();
			this.clock.addObserver(this);
			Thread clockThread = new Thread(this.clock);
			clockThread.start();
			this.view.openFrame();
			this.model.flush();

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
		AIManager aim = AIManager.getInstance();
		ILevel level = this.model.getLevel();
		for(IEntity entity:level.getEntities()){
			if(entity instanceof IAI){
				aim.performAi((IAI) entity);
			}
			performCollision(entity);
		}
		this.model.flush();
	}

	/**
	 * Perform the collision depending of the behavior
	 */
	private void performCollision(IElement element){
		MoveManager mm = MoveManager.getInstance();
		CollisionManager cm = CollisionManager.getInstance();
		IElement other = mm.hasCollision(element);
		if(other == null)
			return;
		cm.performCollision(element);
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
