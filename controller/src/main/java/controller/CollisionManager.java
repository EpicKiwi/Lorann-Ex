package controller;

import contract.*;

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
        if(element.getBehavior() == null)
            return;
        switch (element.getBehavior()){
            case DEATH:
                performDeath(element,other);
                break;
            case MOREPOINT:
                performMorePoint(element,other);
                break;
            case END:
                performEnd(element,other);
                break;
            case UNLOCK:
                performUnlock(element,other);
                break;
            case SPELL:
                performSpell(element,other);
                break;
            default:
                System.err.println("Not implemented behavior "+element.getBehavior().toString());
                break;
        }
        if(element instanceof IItem && other instanceof IHero){
            this.model.getLevel().destroyElement(element);
        }
    }

    void performCrossedCollision(IElement element, IElement other){
        if(element.getBehavior() != null)
            this.performCollision(element,other);
        if(other.getBehavior() != null)
            this.performCollision(other,element);
    }

    void performDeath(IElement element, IElement other){
        if(other instanceof IHero){
            ((IHero) other).setAlive(false);
        }
    }

    void performMorePoint(IElement element, IElement other){
        if(other instanceof IHero){
            ((IHero) other).setScore(((IHero) other).getScore()+100);
        }
    }

    void performUnlock(IElement element, IElement other){
        ILevel level = this.model.getLevel();
        for (int y = 0; y < level.getDimention().getHeight(); y++)
        {
            for (int x = 0; x < level.getDimention().getWidth(); x++)
            {
                IElement ele = level.getElement(x,y);
                if(ele instanceof IDoor){
                    ((IDoor) ele).setUnlocked(true);
                }
            }
        }
    }

    void performSpell(IElement element, IElement other){
        if(other instanceof IHero){
            ((IHero) other).setSpell(true);
            this.model.getLevel().destroyElement(element);
        } else if(other instanceof IMonster){
            this.model.getLevel().destroyElement(other);
        }
    }

    void performEnd(IElement element, IElement other){
        if(other instanceof IHero){
            this.model.getLevel().setFinished(true);
        }
    }
}
