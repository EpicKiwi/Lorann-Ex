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
	
	
	
	/**
	 * constructor of this class
	 */
	GameFrame()
	{
		this.setTitle("Lorran");
		this.setSize(width, height);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	/**
	 * update methode from the View class
	 */
	public void repaint()
	{
		
	}
	
	/**
	 * geter of the width attribute
	 */
	public int getWidth()
	{
		return 0;
	}
	
	/**
	 * geter of the width attribute
	 */
	public int getHeight()
	{
		return 0;
	}
	
	
	/**
	 * methode used to capture the user's actions
	 */
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
	/**
	 * methode used to capture the user's actions
	 */
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
	/**
	 * methode used to capture the user's actions
	 */
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	
}
