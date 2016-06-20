package controller.mock;

import contract.Direction;
import contract.IEntity;

public class EntityMock extends ElementMock implements IEntity {

    Direction d;

    public EntityMock(int x, int y, boolean permeable, Direction d) {
        super(x, y, permeable);
        this.d = d;
    }

    public Direction getDirection() {
        return this.d;
    }

    public void setDirection(Direction direction) {
        this.d = direction;
    }

    public void moveTo(int x, int y) {
        this.setLocation(x,y);
    }
}
