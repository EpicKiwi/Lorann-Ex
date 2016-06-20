package controller.mock;

import contract.*;

import java.util.ArrayList;

public class LevelMock implements ILevel {

    IHero h;
    IElement[][] e;
    ArrayList<IEntity> a;

    public LevelMock(IHero h) {
        this.h = h;
        this.e = new IElement[20][20];
        this.a = new ArrayList<IEntity>();
    }

    public void addEntity(IEntity entity) {

    }

    public void removeEntity(IEntity entity) {

    }

    public int getNumber() {
        return 0;
    }

    public void setNumber(int number) {

    }

    public IDimention getDimention() {
        return null;
    }

    public void setDimention(IDimention dimention) {

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

    }

    public IElement getElement(int x, int y) {
        return null;
    }

    public void setElement(int x, int y, IElement element) {

    }

    public ArrayList<IEntity> getEntities() {
        return this.a;
    }

    public void createSpell(int x, int y, Direction direction) {

    }

    public void destroyElement(IElement element) {

    }

    public boolean isFinished() {
        return false;
    }

    public void setFinished(boolean finished) {

    }

    public int getId() {
        return 0;
    }

    public int getValue() {
        return 0;
    }
}
