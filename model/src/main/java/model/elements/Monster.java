package model.elements;

import model.pathAi.PathAI;

/**
 *@Marie
 * Monster of the game
 */
public class Monster extends AI {

    /**
     * Localisation and image monster
     * @param x
     * Localisation x monster
     * @param y
     * Localisation y monster
     * @param image
     * Image of monster
     * @param path
     * Ai of monster
     */
	public Monster(int x, int y, String image, PathAI path) {
		super(x, y, image);

	}
    /**
     * Localisation and sprite monster
     * @param x
     * Localisation x
     * @param y
     * Localisation y
     */
    public Monster(int x, int y) {
        super(x, y, "sprites/monster_1.png");
    }

}
