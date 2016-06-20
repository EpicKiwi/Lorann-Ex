package controller.mock;

import contract.IElement;
import contract.IHero;
import contract.ILevel;
import contract.IModel;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by Marie on 20/06/2016.
 */
public class ModelMock extends Observable implements IModel {

    IHero h;

    public ModelMock() {
        h = new HeroMock();
    }

    public boolean loadLevel(int id) {
        return false;
    }

    public IElement getElement(int x, int y) {
        return null;
    }

    public IElement[][] getElements() {
        return new IElement[0][];
    }

    public void flush() {}

    public Observable getObservable() {
        return this;
    }

    public ILevel getLevel() {
        ILevel l = new LevelMock(this.h);
        return l;
    }

    public boolean loadAllLevels() {
        return false;
    }

    public boolean loadNextLevel() {
        return false;
    }

    public ArrayList<Integer> getLevelsId() {
        return null;
    }
}
