package model.elements;

import contract.AIType;

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
     * @param aiType
     * Ai of monster
     */
	public Monster(int x, int y, String image, AIType aiType) {
		super(x, y, image);
        this.aiType = aiType;
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

    public String getType() {
        return "monster";
    }
}
