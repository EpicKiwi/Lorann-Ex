package controller.mock;

import contract.*;

import java.awt.*;

public class HeroMock implements IHero {

    ILocation l;

    public HeroMock() {
        this.l = new LocationMock();
        this.l.setX(0);
        this.l.setY(0);
    }

    public Integer getScore() {
        // UNUSED METHOD
        return null;
    }

    public void setScore(Integer score) {
        // UNUSED METHOD
    }

    public boolean isSpell() {
        // UNUSED METHOD
        return false;
    }

    public void setSpell(boolean spell) {
        // UNUSED METHOD
    }

    public boolean isAlive() {
        // UNUSED METHOD
        return false;
    }

    public void setAlive(boolean alive) {
        // UNUSED METHOD
    }

    public Direction getDirection() {
        // UNUSED METHOD
        return null;
    }

    public void setDirection(Direction direction) {
        // UNUSED METHOD
    }

    public void moveTo(int x, int y) {
        // UNUSED METHOD
    }

    public void onCollision(IElement other, ILevel level) {
        // UNUSED METHOD
    }

    public Behavior getBehavior() {
        // UNUSED METHOD
        return null;
    }

    public ILocation getLocation() {
        // UNUSED METHOD
        return this.l;
    }

    public void setLocation(ILocation location) {
        // UNUSED METHOD
    }

    public void setLocation(int x, int y) {
        this.l.setX(x);
        this.l.setY(y);
    }

    public ISprite getSprite() {
        // UNUSED METHOD
        return null;
    }

    public void setSprite(ISprite sprite) {
        // UNUSED METHOD
    }

    public boolean isPermeable() {
        // UNUSED METHOD
        return false;
    }

    public Image getImage() {
        // UNUSED METHOD
        return null;
    }
}
