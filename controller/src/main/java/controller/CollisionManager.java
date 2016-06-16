package controller;

import contract.IElement;
import contract.IModel;

class CollisionManager {
    private static CollisionManager ourInstance;
    private IModel model;

    static CollisionManager getInstance() {
        if(ourInstance == null)
            System.err.println("Move manager not initialized");
        return ourInstance;
    }

    static void init(IModel model){
        ourInstance = new CollisionManager(model);
    }

    private CollisionManager(IModel model) {
        this.model = model;
    }

    // METHODS //

    void performCollision(IElement element, IElement other){
        other.getBehavior();
    }

    void performCrossedCollision(){

    }
}
