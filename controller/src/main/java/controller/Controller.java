package controller;

import contract.*;
import java.util.Observable;
import java.util.Observer;

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
		HeroManager.init(this.model);
	}

	/**
	 * Perform an order to the controller
	 *
	 * @param order
	 * The order to perform
     */
	public void orderPerform(Order order) {
		HeroManager hm = HeroManager.getInstance();
		switch (order){
			case CHARACTER_DOWN:
				hm.move(Direction.DOWN);
				break;
			case CHARACTER_UP:
				hm.move(Direction.UP);
				break;
			case CHARACTER_LEFT:
				hm.move(Direction.LEFT);
				break;
			case CHARACTER_RIGHT:
				hm.move(Direction.RIGHT);
				break;
			case CHARACTER_SPELL:
				hm.sendSpell();
				break;
			default:
				System.out.println("Not supported order : "+order.toString());
				break;
		}
		performCollision(this.model.getLevel().getHero());
		this.model.flush();
	}

	/**
	 * Begin the game
	 */
	public void start(){
		if(this.model.loadLevel(1)){
			this.model.getObservable().addObserver(this.view.getObserver());
			this.clock = new Clock(this);
			this.clock.start();
			this.view.openFrame();

		} else {
			System.err.println("Can't load level id:"+LEVELID);

		}
	}

	/**
	 * Updated when a tick appen
     */
	public void update() {
		AIManager aim = AIManager.getInstance();
		ILevel level = this.model.getLevel();
		for(IEntity entity:level.getEntities()){
			if(entity instanceof IAI){
				aim.performAi((IAI) entity);
			}
			performCollision(entity);
		}
		performCollision(level.getHero());
		updateSprites();
		this.model.flush();
	}

	private void updateSprites(){
		for(IEntity entity:this.model.getLevel().getEntities()){
			if(entity.getSprite() instanceof IAnimatedSprite){
				((IAnimatedSprite) entity.getSprite()).nextStep();
			}
		}

		if(this.model.getLevel().getHero().getSprite() instanceof IAnimatedSprite){
			((IAnimatedSprite) this.model.getLevel().getHero().getSprite()).nextStep();
		}
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
		cm.performCrossedCollision(element,other);
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
