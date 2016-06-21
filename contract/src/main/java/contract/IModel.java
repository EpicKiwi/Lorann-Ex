package contract;

import java.util.ArrayList;
import java.util.Observable;

/**
 * The Interface IModel.
 *
 * @author Baptiste
 */
public interface IModel{

	/**
	 * A method boolean for load the level by Id
	 * @return
	 * return the load the level by Id
	 * @param id
	 * Load the level
	 */
	boolean loadLevel(int id);
	
	/**
	 * In the interface IElement, we got the element and his localisation (x;y)
	 * @param x
	 * localisation x
	 * @param y
	 * localisation y
	 * @return
	 * Element
	 */
	IElement getElement(int x, int y);
	
	/**
	 * getter for the elements
	 * @return
	 * A multi board to get the elements
	 */
	IElement[][] getElements();
	
	/**
	 * methode use to informe the model that the view has changed
	 */
	void flush();
	
	/**
	 * A method to get the observable
	 * @return
	 * a methode for observable
	 */
	Observable getObservable();
	
	/**
	 * A method to get the level
	 * @return
	 * Getter for the level
	 */
	ILevel getLevel();
	
	/**
	 * load all the levels in the series 
	 * @return
	 * If model load all levels
	 */
	boolean loadAllLevels();
	
	/**
	 * load the next level in the series
	 * @return
	 * If model load next level
	 */
	boolean loadNextLevel();
	
	/**
	 * get all of the level id
	 * @return
	 * Model get the level Id
	 */
	ArrayList<Integer> getLevelsId();
}
