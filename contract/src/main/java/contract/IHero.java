package contract;

/**
 * Created by baptiste on 15/06/16.
 */
public interface IHero extends IEntity {

    Integer getScore();

    void setScore(Integer score);

    boolean isSpell();

    void setSpell(boolean spell);
}
