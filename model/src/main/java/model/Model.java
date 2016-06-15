package model;

import java.awt.*;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Observable;

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
		this.level = new Level(12,20,new Hero(1,1),1);
		this.level.setElement(0,0,new HWall(0,0));
		this.level.addEntity(new Monster(5,5));
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

	public void onTick(long tickNumber){
		Level level = this.getLevel();
		for(Entity entity:level.getEntities()){
			if(entity instanceof AI && ((AI) entity).getPath() != null){
				((AI) entity).getPath().onTick(level);
			}
			if(entity.getSprite() instanceof AnimatedSprite){
				((AnimatedSprite) entity.getSprite()).nextStep();
			}
			level.performCollision(entity);
		}
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
