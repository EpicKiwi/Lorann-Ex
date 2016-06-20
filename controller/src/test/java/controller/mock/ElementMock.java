package controller.mock;

import contract.*;

import java.awt.*;

public class ElementMock implements IElement,IValuable {

    ILocation l;
    boolean p;
    Behavior b;

    public ElementMock(int x, int y, boolean permeable) {
        this.l = new LocationMock();
        this.l.setY(y);
        this.l.setX(x);
        this.p = permeable;
    }

    public void onCollision(IElement other, ILevel level) {
        // UNUSED METHOD
    }

    public Behavior getBehavior() {
        return b;
    }

    public void setBehavior(Behavior behavior) {
        b = behavior;
    }


    public ILocation getLocation() {
        return this.l;
    }

    public void setLocation(ILocation location) {
        //UNUSED METHOD
    }

    public void setLocation(int x, int y) {
        this.l.setX(x);
        this.l.setY(y);
    }

    public ISprite getSprite() {
        //UNUSED METHOD
        return null;
    }

    public void setSprite(ISprite sprite) {
        //UNUSED METHOD
    }

    public boolean isPermeable() {
        return this.p;
    }

    public void setPermeable(boolean p) {
        this.p = p;
    }

    public Image getImage() {
        return null;
    }

    public int getValue() {
        return 267;
    }
}
