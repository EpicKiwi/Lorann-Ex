package controller.mock;

import contract.*;

import java.awt.*;
import java.util.Random;

public class HeroMock implements IHero {

    ILocation l;
    Random r;

    public HeroMock() {
        r = new Random();
        this.l = new LocationMock();
        this.l.setX(this.r.nextInt(200)-100);
        this.l.setY(this.r.nextInt(200)-100);
    }

    public Integer getScore() {
        return null;
    }

    public void setScore(Integer score) {

    }

    public boolean isSpell() {
        return false;
    }

    public void setSpell(boolean spell) {

    }

    public boolean isAlive() {
        return false;
    }

    public void setAlive(boolean alive) {

    }

    public Direction getDirection() {
        return null;
    }

    public void setDirection(Direction direction) {

    }

    public void moveTo(int x, int y) {

    }

    public void onCollision(IElement other, ILevel level) {

    }

    public Behavior getBehavior() {
        return null;
    }

    public ILocation getLocation() {
        return this.l;
    }

    public void setLocation(ILocation location) {

    }

    public void setLocation(int x, int y) {

    }

    public ISprite getSprite() {
        return null;
    }

    public void setSprite(ISprite sprite) {

    }

    public boolean isPermeable() {
        return false;
    }

    public Image getImage() {
        return null;
    }
}
