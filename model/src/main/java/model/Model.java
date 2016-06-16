package model;


import java.util.Observable;
import contract.IElement;
import contract.IEntity;
import contract.IModel;
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
		DBConnection dbConnection = DBConnection.getInstance();




		return true;
	}

	public boolean saveLevel()	{
		return true;
	}

	public Level getLevel(){
		return this.level;
	}

	public void flush() {
		this.setChanged();
		this.notifyObservers();
	}

	public Observable getObservable() {
		return this;
	}

	public IElement getElement(int x, int y) {
		return this.level.getElement(x,y);
	}

	public IElement[][] getElements(){
		return this.level.getElements();
	}

	public IEntity getHero(){
		return this.level.getHero();
	}
}
