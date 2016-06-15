package view;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

/**
 * The Class ViewPanel.
 *
 * @author Jean-Aymeric Diet
 */
class GamePanel extends JPanel implements Observer
{
	/**
	 * constructor of this class
	 */
	GamePanel()
	{
		setBackground(Color.BLACK);
		setVisible(true);
	}
	
	/**
	 * will print on screen sprites of the game
	 */
	public void paintComponent(Graphics g)
	{
		
	}

	/**
	 * methode used to update information sent to a class from IObserver
	 * @param observable
	 * The observable object
	 * @param o
	 * An object
	 */
	public void update(Observable observable, Object o) 
	{

	}
}
