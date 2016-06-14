package model.elements;

<<<<<<< HEAD
import model.pathAi.PathAI;
=======
import model.AnimatedSprite;
import model.Direction;
import model.Sprite;
import model.pathAi.Straight;
>>>>>>> 2526251d257f84941c78a627bee0e4872c930770

/**
 *@Marie
 * Spell of hero
 */
<<<<<<< HEAD
public class Spell extends  AI{

	public Spell(int x, int y, String image, PathAI path) {
		super(x, y, image, path);
		// TODO Auto-generated constructor stub
	}
=======
public class Spell extends AI{

    /**
     * Instanciate a spell object
     * @param x
     * The X position
     * @param y
     * The Y position
     * @param direction
     * The direction of the spell
     */
    public Spell(int x, int y, Direction direction) {
        super(x, y, new Sprite("sprites/fireball_1.png"));
        String imagesPaths[] = {
                "sprites/fireball_1.png",
                "sprites/fireball_2.png",
                "sprites/fireball_3.png",
                "sprites/fireball_4.png",
                "sprites/fireball_5.png"
        };
        this.sprite = new AnimatedSprite("sprites/fireball_1.png",imagesPaths);
        this.path = new Straight(this);
    }
>>>>>>> 2526251d257f84941c78a627bee0e4872c930770
}
