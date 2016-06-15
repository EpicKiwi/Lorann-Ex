package controller;

import contract.*;

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
		IHero hero = this.model.getLevel().getHero();
		ILocation heroLocation = hero.getLocation();
		switch (order){
			case CHARACTER_DOWN:
				safeMoveTo(hero,heroLocation.getX(),heroLocation.getY()+1);
				break;
			case CHARACTER_UP:
				safeMoveTo(hero,heroLocation.getX(),heroLocation.getY()-1);
				break;
			case CHARACTER_LEFT:
				safeMoveTo(hero,heroLocation.getX()-1,heroLocation.getY());
				break;
			case CHARACTER_RIGHT:
				safeMoveTo(hero,heroLocation.getX()+1,heroLocation.getY());
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
			this.model.getObservable().addObserver(this.view.getObserver());
			this.clock = new Clock();
			this.clock.addObserver(this);
			this.clockThread = new Thread(this.clock);
			this.clockThread.start();
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
		System.out.println("Tick n°"+this.clock.getTickNumber());
		ILevel level = this.model.getLevel();
		for(IEntity entity:level.getEntities()){
			if(entity instanceof IAI){
				performAi((IAI) entity);
			}
			performCollision(entity);
		}
	}

	/**
	 * Check if a collision append between the element and an other
	 * @return
	 * The other element in collision or null if no collision
	 */
	private IElement hasCollision(IElement element){
		ILocation elementLocation = element.getLocation();
		for(IEntity entity: this.model.getLevel().getEntities()){
			if(elementLocation.equals(entity.getLocation())){
				return entity;
			}
		}
		return this.model.getLevel().getElements()[elementLocation.getY()][elementLocation.getX()];
	}

	private void performAi(IAI entity){
		switch (entity.getAiType()){
			case STRAIGHT:
				//TODO Straight Ai
				break;
			case DIAGONAL:
				//TODO Straight Ai
				break;
			case RANDOM:
				//TODO Straight Ai
				break;
			case NOTHING:
				//Do nothing ???
				break;
		}
	}

	/**
	 * Perform the collision depending of the behavior
	 */
	private void performCollision(IElement element){
		IElement other = hasCollision(element);
		if(other == null)
			return;
		if(other.getBehavior() != null)
			other.getBehavior().onCollision(element,this.model.getLevel());
		if(element.getBehavior() != null)
			element.getBehavior().onCollision(other,this.model.getLevel());
	}

	private boolean canMoveOn(int x, int y){
		IDimention levelDimentions = this.model.getLevel().getDimention();
		if(x > levelDimentions.getWidth()-1 || x < 0)
			return false;
		if(y > levelDimentions.getHeight()-1 || y < 0)
			return false;
		return this.model.getLevel().getElement(x,y).isPermeable();
	}

	private boolean safeMoveTo(IEntity entity, int x, int y){
		if(canMoveOn(x,y)) {
			entity.moveTo(x,y);
			return true;
		}
		return false;
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
