package controller.mock;

import contract.ILocation;

public class LocationMock implements ILocation{

    int x;
    int y;

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }
}
