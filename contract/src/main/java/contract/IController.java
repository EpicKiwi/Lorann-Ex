package contract;

/**
 * The Interface IController.
 *
 * @author Baptiste
 */
public interface IController {

	/**
	 * Send an order to the controller.
	 *
	 * @param order
	 * The order to perform
     */
	public void orderPerform(Order order);

	/**
	 * Set the model of the controller
	 *
	 * @param model
	 * The model of the controller
     */
	public void setModel(IModel model);

	/**
	 * Begin the game
	 */
	public void start();

}
