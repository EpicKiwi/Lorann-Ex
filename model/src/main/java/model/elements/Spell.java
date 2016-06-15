package model.elements;

import model.pathAi.PathAI;
import model.AnimatedSprite;
import model.Direction;
import model.Sprite;
import model.pathAi.Straight;

/**
 *@Marie
 * Spell of hero
 */
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
}
