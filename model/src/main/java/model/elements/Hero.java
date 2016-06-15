package model.elements;

/**
 * The hero of the game (Lorann)
 */
public class Hero extends Entity {
    /** The indicator of the capacity to the hero to launch a RAINBOW SPELLr <b>*o*</b> */
    private boolean spell = true;
    /** The score of the player */
   private Integer score = 0;

    /**
     * Localisation and image hero
     *
     * @param x
     * @param y
     * @param image
     */
    public Hero(int x, int y) {
        super(x, y, "sprites/lorann_l.png");
    }

    /**
     * Get the score of hero
     * @return
     * The score
     */

    public Integer getScore() {
        return score;
    }
    /**
     * Set The score of hero
     * @param score
     * The score
     */
    public void setScore(Integer score) {
        this.score = score;
    }

    /**
     * Get the spell
     * @return
     * The spell
     */
    public boolean isSpell() {
        return spell;
    }
    /**
     * Set the spell of hero
     * @param spell
     * The spell
     */
    public void setSpell(boolean spell) {
        this.spell = spell;
    }
}
