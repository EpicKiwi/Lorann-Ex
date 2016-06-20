package controller.mock;

import contract.IElement;
import contract.ILevel;
import contract.IModel;

import java.util.ArrayList;
import java.util.Observable;

/**
 * Created by Marie on 20/06/2016.
 */
public class modelmock implements IModel {
    public boolean loadLevel(int id) {
        return false;
    }

    public IElement getElement(int x, int y) {
        return null;
    }

    public IElement[][] getElements() {
        return new IElement[0][];
    }

    public void flush() {

    }

    public Observable getObservable() {
        return null;
    }

    public ILevel getLevel() {
        return null;
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
