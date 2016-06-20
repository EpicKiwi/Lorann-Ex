package contract;

/**
 *@author Baptiste
 * Interface Hero
 */
public interface IHero extends IEntity {
    /**
     * A getter for the score
     * @return
     */
    Integer getScore();
    /**
     * A Setter for the score
     * @param score
     */

    void setScore(Integer score);
    /**
     * A getter if the spell is shooted
     * @return
     */

    boolean isSpell();
    /**
     * A setter if the spell is shooted
     * @param spell
     */

    void setSpell(boolean spell);
    /**
     * A getter if the hero is alive
     * @return
     */
    
    boolean isAlive();
    /**
     * A setter if the hero is alive
     * @param alive
     */
    
    void setAlive(boolean alive);

}
