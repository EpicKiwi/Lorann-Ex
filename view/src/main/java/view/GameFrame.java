package view;


import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;


/**
 * The Class ViewFrame.
 *
 * @author Clement Chabrier
 * build the frame and listen user's actions
 */
class GameFrame extends JFrame implements KeyListener 
{
	/**
	 * attribute to create the frame's size
	 */
	private int width = 640;
	
	/**
	 * attribute to create the frame's size
	 */
	private int height = 380;
	
	

	private GamePanel panel;
	
	
	
	/**
	 * constructor of this class
	 */
	GameFrame()
	{
		this.setTitle("Lorran");
		this.setSize(width, height);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.panel = new GamePanel();
	}
	
	/**
	 * update methode from the View class
	 */
	public void repaint()
	{
		
	}
	
	public GamePanel getGamePanel()
	{
		return this.panel;
	}
	
	
	/**
	 * geter of the width attribute
	 */
	public int getWidth()
	{
		return width;
	}
	
	/**
	 * geter of the width attribute
	 */
	public int getHeight()
	{
		return height;
	}
	
	
	/**
	 * methode used to capture the user's actions
	 */
	public void keyPressed(KeyEvent e) 
	{
		
	}
	
	
	/**
	 * methode used to capture the user's actions
	 */
	public void keyReleased(KeyEvent e) 
	{
		
	}
	
	
	/**
	 * methode used to capture the user's actions
	 */
	public void keyTyped(KeyEvent e) 
	{
	
	}

	
}
