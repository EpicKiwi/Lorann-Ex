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
	 * attribute of the GameFrame class from the composition
	 */
	private GameFrame frame;
	
	
	/**
	 * constructor of the view class
	 */
	public View()
	{
		this.frame = new GameFrame();
		
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
		this.frame.setVisible(true);
		
	}

	
	/**
	 * methode to close the current frame
	 */
	public void closeFrame()
	{
		this.frame.setVisible(false);
	}
	
	
	/**
	 * methode to get the observer from the patern
	 */
	public Observer getObserver() 
	{
		return this.frame.getGamePanel();
	}

	
	/**
	 * set the controller associated to the view
	 * @param controller
	 * The controller associated
     */
	public void setController(IController controller) 
	{
		this.frame.setController(controller);
	}
}
