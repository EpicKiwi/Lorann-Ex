package model;


import contract.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
	 * The hero of the game
	 */
	private Hero hero;

	/**
	 * The IDs of the levels
	 */
	private ArrayList<Integer> levelsId;

	public Model() {
		this.hero = new Hero(1,1);
	}

	/** Instantiates a new model. */


	public boolean loadAllLevels(){
		DBConnection dbConnection = DBConnection.getInstance();
		try {
			ResultSet res = dbConnection.findAllLevels();
			this.levelsId = new ArrayList<Integer>();
			while(res.next()){
				levelsId.add(res.getInt(1));
			}
		} catch (SQLException e) {
			System.err.println("SQL error : "+e.getMessage());
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean loadLevel(int id){
		DBConnection dbConnection = DBConnection.getInstance();
		try {
			ResultSet rawLevel = dbConnection.findLevel(id);
			if(rawLevel.first()){
				this.level = new Level(rawLevel.getInt(1),rawLevel.getInt(3),rawLevel.getInt(4),this.hero,rawLevel.getInt(2));
            } else {
				System.err.println("The level "+id+" doesn't exists");
				this.loadSafetyLevel();
			}
			ResultSet rawElements = dbConnection.findElements(id);
			while(rawElements.next()){
				if(rawElements.getString(2).equals("cross-wall")) {
					this.level.setElement(rawElements.getInt(3),rawElements.getInt(4),new Cross(rawElements.getInt(3),rawElements.getInt(4)));
				} else if(rawElements.getString(2).equals("vertical-wall")) {
					this.level.setElement(rawElements.getInt(3),rawElements.getInt(4),new VWall(rawElements.getInt(3),rawElements.getInt(4)));
				} else if(rawElements.getString(2).equals("horizontal-wall")) {
					this.level.setElement(rawElements.getInt(3),rawElements.getInt(4),new HWall(rawElements.getInt(3),rawElements.getInt(4)));
				} else if(rawElements.getString(2).equals("door")) {
					this.level.setElement(rawElements.getInt(3),rawElements.getInt(4),new Door(rawElements.getInt(3),rawElements.getInt(4)));
				} else if(rawElements.getString(2).equals("life-bubble")) {
					this.level.setElement(rawElements.getInt(3),rawElements.getInt(4),new LifeBubble(rawElements.getInt(3),rawElements.getInt(4)));
				} else if(rawElements.getString(2).equals("money")) {
					this.level.setElement(rawElements.getInt(3),rawElements.getInt(4),new Money(rawElements.getInt(3),rawElements.getInt(4)));
				} else if(rawElements.getString(2).equals("hero")) {
					ILocation loc = this.level.getHero().getLocation();
					loc.setX(rawElements.getInt(3));
					loc.setY(rawElements.getInt(4));
					this.level.getHero().setDirection(Direction.valueOf(rawElements.getString(5)));
				} else if(rawElements.getString(2).equals("monster")) {
					this.level.addEntity(new Monster(rawElements.getInt(3),rawElements.getInt(4),Direction.valueOf(rawElements.getString(5))));
				} else {
						System.err.println("Unsupported element "+rawElements.getString(2)+" at "+rawElements.getInt(3)+":"+rawElements.getInt(4));
				}
			}
		} catch (SQLException e) {
			System.err.println("SQL error : "+e.getMessage());
			e.printStackTrace();
			this.loadSafetyLevel();
			return false;
		}
		this.hero.setAlive(true);
		this.hero.setSpell(true);
		return true;
	}

	public boolean loadNextLevel(){
		int lastIndex = this.levelsId.indexOf(this.level.getId());
		if((lastIndex+1) < this.levelsId.size()) {
			this.loadLevel(this.levelsId.get(lastIndex+1));
			return true;
		}
		return false;
	}

	public void loadSafetyLevel(){
		this.level = new Level(-1,20,12,new Hero(1,1),1);
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

	public ArrayList<Integer> getLevelsId() {
		return levelsId;
	}
}
