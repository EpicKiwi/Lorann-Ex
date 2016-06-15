package model;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Observable;
import java.util.logging.Level;

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
		return null;
	}

	public void flush() {
	}

	public void onTick(){
		System.out.println("Model Tick");
	}

	public Observable getObservable() {
		return this;
	}
}
