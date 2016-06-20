package contract;

import java.util.ArrayList;

public interface ILevel extends IValuable {

    void addEntity(IEntity entity);

    void removeEntity(IEntity entity);

    IDimention getDimention();

    IHero getHero();

    void setHero(IHero hero);

    IElement[][] getElements();

    void setElements(IElement[][] elements);

    IElement getElement(int x, int y);

    void setElement(int x, int y, IElement element);

    ArrayList<IEntity> getEntities();

    void createSpell(int x, int y, Direction direction);

    void destroyElement(IElement element);

    boolean isFinished();

    void setFinished(boolean finished);

    int getId();

    void setId(int id);
}
