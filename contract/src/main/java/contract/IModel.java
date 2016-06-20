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

	void flush();
	/**
	 * A method to get the observable
	 */
	Observable getObservable();
	/**
	 * A method to get the level
	 */
	ILevel getLevel();
	boolean loadAllLevels();
	boolean loadNextLevel();
	ArrayList<Integer> getLevelsId();
}
