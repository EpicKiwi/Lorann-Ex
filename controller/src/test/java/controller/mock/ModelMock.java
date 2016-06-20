package controller.mock;

import contract.IElement;
import contract.IHero;
import contract.ILevel;
import contract.IModel;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

/**
 * Mock class of a model
 */
public class ModelMock extends Observable implements IModel {

    IHero h;
    ILevel l;

    public ModelMock(IHero hero) {
        this.h = hero;
        l = new LevelMock(h);
    }

    public boolean loadLevel(int id) {
        return true;
    }

    public IElement getElement(int x, int y) {
        return l.getElement(x,y);
    }

    public IElement[][] getElements() {
        return l.getElements();
    }

    public void flush() {}

    public Observable getObservable() {
        return this;
    }

    public ILevel getLevel() {
        return l;
    }

    public boolean loadAllLevels() {
        return true;
    }

    public boolean loadNextLevel() {
        return true;
    }

    public ArrayList<Integer> getLevelsId() {
        return null;
    }
}
