package model.elements;

import contract.AIType;
import contract.Direction;

import static contract.AIType.DIAGONAL;
import static contract.AIType.STRAIGHT;

/**
 *@Marie
 * Monster of the game
 */
public class Monster extends AI {

    /**
     * Localisation and sprite monster
     * @param x
     * Localisation x
     * @param y
     * Localisation y
     */
    public Monster(int x, int y, Direction direction) {
        super(x, y, "sprites/monster_1.png");
        this.direction = direction;
        this.aiType = STRAIGHT;
    }

    /**
     * Get the type of the element
     * @return monster
     */
    public String getType() {
        return "monster";
    }
}
