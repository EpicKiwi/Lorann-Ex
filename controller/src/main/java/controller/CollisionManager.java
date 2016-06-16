package controller;

import contract.IElement;
import contract.IModel;

public class CollisionManager {
    private static CollisionManager ourInstance;
    private IModel model;

    public static CollisionManager getInstance() {
        if(ourInstance == null)
            System.err.println("Move manager not initialized");
        return ourInstance;
    }

    public static void init(IModel model){
        ourInstance = new CollisionManager(model);
    }

    private CollisionManager(IModel model) {
        this.model = model;
    }

    // METHODS //

    void performCollision(IElement element){
        //TODO Perform entity
    }
}
