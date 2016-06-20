package contract;

/**
 * @author Baptiste
 * Interface representing the entities of the level
 */
public interface IEntity extends IElement {
	
	/**
	 * get the direction of an entity
	 * @return
	 */
    Direction getDirection();
    
    /**
     * set the direction of an entity
     * @param direction
     */
    void setDirection(Direction direction);
    
    /**
     * define where the entity has to move
     * @param x
     * @param y
     */
    void moveTo(int x, int y);
}
