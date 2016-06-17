package contract;

import java.util.ArrayList;

public interface ILevel extends IValuable {
    boolean setElement(Integer x, Integer y, IElement element);

    void addEntity(IEntity entity);

    void removeEntity(IEntity entity);

    int getNumber();

    void setNumber(int number);

    IDimention getDimention();

    void setDimention(IDimention dimention);

    IHero getHero();

    void setHero(IHero hero);

    IElement[][] getElements();

    void setElements(IElement[][] elements);

    IElement getElement(int x, int y);

    void setElement(int x, int y, IElement element);

    ArrayList<IEntity> getEntities();

    void setEntities(ArrayList<IEntity> entities);

    boolean isExit();

    void setExit(boolean exit);

    void createSpell(int x, int y, Direction direction);

    public void destroyElement(IElement element);

    public boolean isFinished();

    public void setFinished(boolean finished);

    int getId();

    void setId(int id);
}
