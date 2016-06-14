package model.elements;

import model.AnimatedSprite;
import model.Sprite;
import model.pathAi.PathAI;

/**
 *@Marie
 * Spell of hero
 */
public class Spell extends AI{

    public Spell(int x, int y, PathAI path) {
        super(x, y, new Sprite("sprites/fireball_1.png"), path);
        String imagesPaths[] = {
                "sprites/fireball_1.png",
                "sprites/fireball_2.png",
                "sprites/fireball_3.png",
                "sprites/fireball_4.png",
                "sprites/fireball_5.png"
        };
        this.sprite = new AnimatedSprite("sprites/fireball_1.png",imagesPaths);
    }
}
