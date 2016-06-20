package contract;

import java.util.ArrayList;
/**
 * The Interface ILevel
 *
 * @author Baptiste
 */
public interface ILevel extends IValuable {

    void addEntity(IEntity entity);
    /**
     * A method tp remove the entity
     * @param entity
     */

    void removeEntity(IEntity entity);

    /**
     * A getter to get the number
     * @param
     */
    int getNumber();
    /**
     * A setter for number
     * @param number
     */
    void setNumber(int number);
    /**
     * A getter to get the dimention
     */
    IDimention getDimention();
    /**
     * A setter for dimention
     * @param dimention
     */
    void setDimention(IDimention dimention);

    IHero getHero();
    /**
     * A setter for hero
     * @param hero
     */
    void setHero(IHero hero);
    /**
     * A getter for element
     * @return
     */
    IElement[][] getElements();
    /**
     * A setter for element
     * @param elements
     */
    void setElements(IElement[][] elements);
    /**
     * A getter for element
     * @return
     */
    IElement getElement(int x, int y);
    /**
     * A setter for element
     * @param element
     * @param x
     * @param y
     */
    void setElement(int x, int y, IElement element);
    /**
     * A getter for Entities
     * @return
     */
    ArrayList<IEntity> getEntities();

    void createSpell(int x, int y, Direction direction);
    /**
     * A method to destroy the element
     * @param element
     */
     void destroyElement(IElement element);
    /**
     * A getter if the level is finished
     * @return
     */
     boolean isFinished();
    /**
     * A setter if the level is finished
     * @param finished
     */
     void setFinished(boolean finished);

    int getId();
}
