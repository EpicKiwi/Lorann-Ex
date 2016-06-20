package controller.mock;

import contract.*;

import java.util.ArrayList;

public class LevelMock implements ILevel {

    IHero h;
    IElement[][] e;
    ArrayList<IEntity> a;
    boolean fin;

    public LevelMock(IHero h) {
        this.h = h;
        this.e = new IElement[20][10];
        this.a = new ArrayList<IEntity>();
        fin = false;
    }

    public void addEntity(IEntity entity) {
        a.add(entity);
    }

    public void removeEntity(IEntity entity) {
        a.remove(entity);
    }

    public int getNumber() {
        // UNUSED METHOD
        return 0;
    }

    public void setNumber(int number) {
        // UNUSED METHOD
    }

    public IDimention getDimention() {
        return new IDimention() {
            public int getWidth() {
                return 10;
            }

            public void setWidth(int width) {
                // UNUSED METHOD
            }

            public int getHeight() {
                return 20;
            }

            public void setHeight(int height) {
                // UNUSED METHOD
            }
        };
    }

    public void setDimention(IDimention dimention) {
        // UNUSED METHOD
    }

    public IHero getHero() {
        return h;
    }

    public void setHero(IHero hero) {
        // UNUSED METHOD
    }

    public IElement[][] getElements() {
        return this.e;
    }

    public void setElements(IElement[][] elements) {
        // UNUSED METHOD
    }

    public IElement getElement(int x, int y) {
        // UNUSED METHOD
        return this.e[y][x];
    }

    public void setElement(int x, int y, IElement element) {
        // UNUSED METHOD
        this.e[y][x] = element;
    }

    public ArrayList<IEntity> getEntities() {
        return this.a;
    }

    public void createSpell(int x, int y, Direction direction) {
        this.addEntity(new AiMock(x,y,direction,AIType.STRAIGHT));
    }

    public void destroyElement(IElement element) {
        this.a.remove(element);
    }

    public boolean isFinished() {
        return fin;
    }

    public void setFinished(boolean finished) {
        this.fin = finished;
    }

    public int getId() {
        // UNUSED METHOD
        return 0;
    }

    public int getValue() {
        // UNUSED METHOD
        return 0;
    }
}
