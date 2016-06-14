package view;


import java.awt.event.KeyEvent;
import java.util.Observer;

import javax.swing.SwingUtilities;

import contract.IController;
import contract.IModel;

import contract.IView;

/**
 * The Class View.
 *
 * @author Clement Chabrier
 */
public class View implements IView
{
	
	/**
	 * constructor of the view class
	 */
	public View()
	{
		
	}
	
	
/**
 * update methode from IView inteface	
 */
	public void repaint()
	{
		
	}
	
	/**
	 * methode to open the frame
	 */
	public void openFrame()
	{
		
	}

	public Observer getObserver() {
		return null;
	}

	/**
	 * methode to close the frame
	 */
	public void closeFrame()
	{
		
	}

	/**
	 * set the controller associated to the view
	 * @param controller
	 * The controller associated
     */
	public void setController(IController controller) {

	}
}
