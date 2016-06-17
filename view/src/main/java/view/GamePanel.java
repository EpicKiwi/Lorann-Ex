package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

import contract.IElement;
import contract.IEntity;
import contract.IHero;
import contract.ILevel;
import contract.IModel;

/**
 * The Class ViewPanel.
 *
 * @author Clement Chabrier
 */
class GamePanel extends JPanel implements Observer
{
	
	private IModel model;
	
	
	Font f;

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
		super.paintComponent(g);
		
		ILevel level = this.model.getLevel();
		for (int y = 0; y < level.getDimention().getHeight(); y++)
		{
			for (int x = 0; x < level.getDimention().getWidth(); x++)
			{
				IElement ele = level.getElement(x, y);
				if (ele == null)
					continue;
				g.drawImage(model.getElement(x,y).getImage(),x*32,y*32,this);
			}
		}

		for (IEntity ele : model.getLevel().getEntities())
		{
			g.drawImage(ele.getImage(), ele.getLocation().getX()*32, ele.getLocation().getY()*32, null);
		}


		if(this.model.getLevel().getHero().isAlive()) {
			IHero ele = level.getHero();
			g.drawImage(ele.getImage(), ele.getLocation().getX() * 32, ele.getLocation().getY() * 32, null);
		}

		f = new Font ("Consola", Font.BOLD, 20);
		g.setFont(f);
		g.setColor(Color.WHITE);

		g.drawString("R to retry", 525, 414);

		if(!this.model.getLevel().getHero().isAlive()) 
		{
			g.drawString("GAME OVER", 250, 414);
		}
		
		if(this.model.getLevel().isFinished())
		{
			g.drawString("SUCCESS !", this.getWidth()/2-45, this.getHeight()/2-32);
		}
		
		g.setColor(Color.YELLOW);

		g.drawString("Score : "+model.getLevel().getHero().getScore().toString(), 20, 414);
		
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
		this.model = (IModel) observable;
		this.repaint();
	}

	
	
}
