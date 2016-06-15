package model.elements;

import model.pathAi.PathAI;

/**
 *@Marie
 * Monster of the game
 */
public class Monster extends AI {



	public Monster(int x, int y, String image, PathAI path) {
		super(x, y, image);

	}

    public Monster(int x, int y) {
        super(x, y, "sprites/monster_1.png");
    }

}
