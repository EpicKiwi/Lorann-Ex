package model;

import java.awt.*;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Observable;

import contract.Direction;
import contract.IElement;
import contract.IEntity;
import contract.IModel;
import model.elements.*;

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
		//TODO Implementer base de données
		this.level = new Level(20,12,new Hero(1,1),1);
		this.level.setElement(0,0,new HWall(0,0));
		this.level.setElement(1,0,new HWall(1,0));
		this.level.setElement(2,0,new HWall(2,0));
		this.level.setElement(3,0,new HWall(3,0));
		this.level.setElement(4,0,new HWall(4,0));
		this.level.addEntity(new Monster(5,5, Direction.RIGHT));
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
