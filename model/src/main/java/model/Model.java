package model;


import contract.*;

import java.util.Observable;

import model.elements.*;
import model.database.DBConnection;

/**
 * The Class Model.
 *
 * @author Marie
 */
public class Model extends Observable implements IModel {

	/**
	 * The level
	 */
	private Level level;

	/**
	 * Model of Hero
	 */
	private Hero hero;

	/** Instantiates a new model. */


	public boolean loadLevel(int Id){

		//DBConnection dbConnection = DBConnection.getInstance();

		//TODO Implementer base de données
		this.level = new Level(20,12,new Hero(5,3),1);
		this.level.setElement(10,5,new VWall(10,5));
		this.level.setElement(1,5,new VWall(1,5));
		this.level.setElement(19,5,new VWall(19,5));
		this.level.setElement(19,11,new Door(19,11));
		this.level.setElement(19,0,new LifeBubble(19,0));
		this.level.setElement(0,0,new Money(0,0));
		this.level.setElement(1,0,new Money(1,0));
		this.level.setElement(2,0,new Money(2,0));
		this.level.setElement(3,0,new Money(3,0));
		this.level.setElement(4,0,new Money(4,0));
		this.level.setElement(5,0,new Money(5,0));
		this.level.addEntity(new Monster(5,5, Direction.RIGHT));
		this.level.addEntity(new Monster(11,5, Direction.LEFT));
		AI ele = new Monster(10,10, Direction.TOPRIGHT);
		ele.setAiType(AIType.DIAGONAL);
		this.level.addEntity(ele);
		return true;
	}

	/**
	 * Save the level
	 */
	public boolean saveLevel()	{
		return true;
	}
	
	/**
	 * Get the level
	 * @return
	 */
	public Level getLevel(){
		return this.level;
	}

	/**
	 * Inform the view that the model have changed
	 */
	public void flush() {
		this.setChanged();
		this.notifyObservers();
	}
	
	/**
	 * Get the observable
	 * @return
	 */
	public Observable getObservable() {
		return this;
	}
	
	/**
	 * Get the element of a specific position
	 * @return
	 */
	public IElement getElement(int x, int y) {
		return this.level.getElement(x,y);
	}

	/**
	 * Get element of the board
	 * @return
	 */
	public IElement[][] getElements(){
		return this.level.getElements();
	}

	/**
	 * Get the hero
	 * @return
	 */
	public IEntity getHero(){
		return this.level.getHero();
	}
}
