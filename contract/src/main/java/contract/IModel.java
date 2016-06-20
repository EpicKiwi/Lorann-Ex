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
	 * @param id
	 * Load the level
	 */
	boolean loadLevel(int id);
	
	/**
	 * In the interface IElement, we got the element and his localisation (x;y)
	 * @param x
	 * @param y
	 * get the element
	 */
	IElement getElement(int x, int y);
	
	/**
	 * A multi board to get the elements
	 */
	IElement[][] getElements();
	
	/**
	 * methode use to informe the model that the view has changed
	 */
	void flush();
	
	/**
	 * A method to get the observable
	 */
	Observable getObservable();
	
	/**
	 * A method to get the level
	 */
	ILevel getLevel();
	
	/**
	 * load all the levels in the series 
	 * @return
	 */
	boolean loadAllLevels();
	
	/**
	 * load the next level in the series
	 * @return
	 */
	boolean loadNextLevel();
	
	/**
	 * get all of the level id
	 * @return
	 */
	ArrayList<Integer> getLevelsId();
}
