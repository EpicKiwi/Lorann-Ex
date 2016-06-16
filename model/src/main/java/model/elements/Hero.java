package model.elements;

/**
 * The hero of the game (Lorann)
 */
public class Hero extends Entity implements contract.IHero {
    /** The indicator of the capacity to the hero to launch a RAINBOW SPELLr <b>*o*</b> */
    private boolean spell = true;
    /** The score of the player */
   private Integer score = 0;

    /**
     * Localisation and image hero
     *
     * @param x
     *position x
     * @param y
     * position y
     * sprites lorann
     */
    public Hero(int x, int y) {
        super(x, y, "sprites/lorann_l.png");
    }
    // GETTER & SETTER
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
     * Is (get) if the spell is cast
     * @return
     * The spell
     */
    public boolean isSpell() {
        return spell;
    }
    /**
     * Set the spell of hero if cast
     * @param spell
     * The spell
     */
    public void setSpell(boolean spell) {
        this.spell = spell;
    }

    /**
     * Get the type of the hero
     * @return
     * The hero
     */
    public String getType() {
        return "hero";
    }
    /**
     * Get the load Query
     * @return
     * Load query
     */
    public String getLoadQuery(int id) {
        return null;
    }
}
