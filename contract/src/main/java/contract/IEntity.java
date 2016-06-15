package contract;

/**
 * Interface representing the entities of the level
 */
<<<<<<< HEAD
public interface IEntity extends IElement 
{
	
=======
public interface IEntity extends IElement {
    Direction getDirection();
    void setDirection(Direction direction);
    void moveTo(int x, int y);
>>>>>>> 6e9b3e2ced4adf0a68e073449ff33f9c34579e2a
}
