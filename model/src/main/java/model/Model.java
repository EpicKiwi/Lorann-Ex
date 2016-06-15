package model;

import java.awt.*;
import java.sql.Connection;
import java.util.Observable;

import contract.IElement;
import contract.IModel;
import model.elements.Hero;

/**
 * The Class Model.
 *
 * @author Marie
 */
public class Model extends Observable implements IModel {
	/**
	 * Model of connection
	 */
	private Connection connection;

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
		return true;
	}

	public boolean saveLevel()	{
		return true;
	}

	public Level getLevel(){
		return this.level;
	}

	public void flush() {
	}

	public void onTick(long tickNumber){
		System.out.println("Model Tick");
	}

	public Observable getObservable() {
		return this;
	}

	public IElement getElement(int x, int y) {
		return this.level.getElement(x,y);
	}
}
