package main;

import controller.Controller;
import model.Model;
import view.View;

/**
 * The Class Main.
 *
 * @author Baptiste
 */
public abstract class Main {

	/**
	 * The main method.
	 *
	 * @param args
	 *          the arguments
	 */
	public static void main(final String[] args) {
		Model model = new Model();
		View view = new View();
		Controller controller = new Controller(view,model);
		view.setController(controller);
		controller.start();
	}
}