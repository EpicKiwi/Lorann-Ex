package contract;

import java.util.Observable;
import java.util.logging.Level;

/**
 * The Interface IModel.
 *
 * @author Jean-Aymeric Diet
 */
public interface IModel {

	boolean loadLevel(int id);
	Level getLevel();
	boolean saveLevel();
	void flush();
	Observable getObservable();
}
