package contract;

import java.util.ArrayList;
/**
 * The Interface ILevel
 *
 * @author Baptiste
 */
public interface ILevel extends IValuable {
    /**
     * A setter for element
     * @param x
     * @param y
     * @param element
     * Set element
     */
    boolean setElement(Integer x, Integer y, IElement element);
    /**
     * A method to add the entity
     * @param entity
     */

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
     * A method to get the dimention
     */
    IDimention getDimention();
    /**
     * A setter for dimention
     * @param dimention
     */
    void setDimention(IDimention dimention);
    /**
     * A getter for hero
     * @return
     */
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
    /**
     * A setter for entities
     * @param entities
     */
    void setEntities(ArrayList<IEntity> entities);
    /**
     * A getter for exit
     * @return
     */
    boolean isExit();
    /**
     * A setter for exit
     * @param exit
     */
    void setExit(boolean exit);
    /**
     * A method to create the spell
     * @param direction
     * @param x
     * @param y
     */
    void createSpell(int x, int y, Direction direction);
    /**
     * A method to destroy the element
     * @param element
     */
    public void destroyElement(IElement element);
    /**
     * A getter if the level is finished
     * @return
     */
    public boolean isFinished();
    /**
     * A setter if the level is finished
     * @param finished
     */
    public void setFinished(boolean finished);
}
