package contract;

import java.awt.*;
import java.util.ArrayList;
import java.util.Observable;

/**
 * The Interface IModel.
 *
 * @author Jean-Aymeric Diet
 */
public interface IModel{

	boolean loadLevel(int id);
	IElement getElement(int x, int y);
	IElement[][] getElements();
	boolean saveLevel();
	void flush();
	Observable getObservable();
	ILevel getLevel();
	boolean loadAllLevels();
	boolean loadNextLevel();
	ArrayList<Integer> getLevelsId();
}
