package model;

import java.sql.SQLException;
import java.util.Observable;
import java.util.logging.Level;

import contract.IModel;

/**
 * The Class Model.
 *
 * @author Jean-Aymeric Diet
 */
public class Model extends Observable implements IModel {



	/** Instantiates a new model. */


	public void loadLevel(Integer Id){
	}

	public void saveLevel()	{
	}

	public Level getLevel(){
		return null;
	}

	public void flush() {
	}


	public Observable getObservable() {
		return this;
	}
}
