package model.elements;

import contract.AIType;
import contract.Behavior;
import contract.Direction;
import model.Sprite;

import static contract.AIType.*;

/**
 *@Marie
 * Monster of the game
 */
public class Monster extends AI implements contract.IMonster {

    /**
     * Localisation and sprite monster
     * @param x
     *
     * Localisation x
     * @param y
     * Localisation y
     */
    public Monster(int x, int y, Direction direction) {
        super(x, y, "sprites/monster_1.png");
        this.direction = direction;
        this.behavior = Behavior.DEATH;
        switch(direction){
            case UP:
            case DOWN:
            case LEFT:
            case RIGHT:
                this.aiType = STRAIGHT;
                break;
            case TOPLEFT:
            case TOPRIGHT:
            case BOTTOMLEFT:
            case BOTTOMRIGHT:
                this.aiType = DIAGONAL;
                this.sprite = new Sprite("sprites/monster_2.png");
                break;
            case FOLLOW:
                this.aiType = FOLLOW;
                this.sprite = new Sprite("sprites/monster_4.png");
                break;
            default:
                this.aiType = RANDOM;
                this.sprite = new Sprite("sprites/monster_3.png");
                break;
        }
    }

    /**
     * Get the type of the element
     * @return monster
     */
    public String getType() {
        return "monster";
    }
}
