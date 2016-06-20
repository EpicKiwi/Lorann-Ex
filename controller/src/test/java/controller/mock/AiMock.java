package controller.mock;

import contract.AIType;
import contract.Direction;
import contract.IAI;

public class AiMock extends EntityMock implements IAI {

    AIType t;

    public AiMock(int x, int y, Direction d, AIType t) {
        super(x, y, true, d);
        this.t = t;
    }

    public AIType getAiType() {
        return t;
    }

    public void setAiType(AIType aiType) {
        t = aiType;
    }
}
