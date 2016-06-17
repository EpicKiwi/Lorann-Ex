package model;


import contract.*;

import java.sql.ResultSet;
import java.sql.SQLException;
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

	/** Instantiates a new model. */


	public boolean loadLevel(int id){

		DBConnection dbConnection = DBConnection.getInstance();
		try {
			ResultSet rawLevel = dbConnection.findLevel(id);
			if(rawLevel.first()){
				this.level = new Level(rawLevel.getInt(3),rawLevel.getInt(4),new Hero(0,0),rawLevel.getInt(2));
            } else {
				System.err.println("The level "+id+" doesn't exists");
				this.loadSafetyLevel();
			}
		} catch (SQLException e) {
			System.err.println("SQL error : "+e.getMessage());
			e.printStackTrace();
			this.loadSafetyLevel();
		}
		return true;
	}

	public void loadSafetyLevel(){
		this.level = new Level(20,12,new Hero(1,1),1);
		this.level.setElement(10,5,new VWall(10,5));
		this.level.setElement(1,5,new VWall(1,5));
		this.level.setElement(19,5,new VWall(19,5));
		this.level.addEntity(new Monster(5,5, Direction.RIGHT));
		this.level.addEntity(new Monster(11,5, Direction.LEFT));
		this.level.addEntity(new Monster(12,6, Direction.LEFT));
		this.level.addEntity(new Monster(13,7, Direction.LEFT));
		this.level.addEntity(new Monster(14,8, Direction.LEFT));
		AI ele = new Monster(10,10, Direction.TOPRIGHT);
		ele.setAiType(AIType.DIAGONAL);
		this.level.addEntity(ele);
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
