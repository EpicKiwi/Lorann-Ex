package model.elements;

import contract.AIType;
import model.AnimatedSprite;
import contract.Direction;
import model.Sprite;

/**
 *@Marie
 * Spell of hero
 */
public class Spell extends AI{

    /**
     * Instanciate a spell object
     * @param x*
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
        this.aiType = AIType.STRAIGHT;
    }

    public String getType() {
        return "spell";
    }
}
