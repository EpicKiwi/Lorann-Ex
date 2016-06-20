package controller.mock;

import contract.AIType;
import contract.Direction;
import contract.IMonster;

public class MonsterMock extends AiMock implements IMonster {
    public MonsterMock(int x, int y, Direction d, AIType t) {
        super(x, y, d, t);
    }
}
