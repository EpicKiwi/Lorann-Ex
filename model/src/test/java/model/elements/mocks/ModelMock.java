package model.elements.mocks;

import model.Model;

public class ModelMock extends Model {

    @Override
    public boolean loadLevel(int id) {
        this.loadSafetyLevel();
        this.getLevel().setId(id);
        return true;
    }
}
