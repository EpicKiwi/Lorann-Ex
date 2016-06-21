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

    /**
     * All the collision of the game
     * @param element
     * Element of collision manager
     * @param other
     * other collision
     */
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
    
	/**
	 * Collision between elements
	 * @param element
     * Collision between elements
	 * @param other
     * collision between other
	 */
    void performCrossedCollision(IElement element, IElement other){
        if(element.getBehavior() != null)
            this.performCollision(element,other);
        if(other.getBehavior() != null)
            this.performCollision(other,element);
    }
    
	/**
	 * Method for when the hero die
	 * @param element
     * Element for the death of the hero
	 * @param other
     * Other for the death of the hero
	 */
    private void performDeath(IElement element, IElement other){
        if(other instanceof IHero){
            ((IHero) other).setAlive(false);
        }
    }

    /**
     * Add point to the score
     * @param element
     * element to allow add the point
     * @param other
     * other to allow add the point
     */
    private void performMorePoint(IElement element, IElement other){
        if(other instanceof IHero && element instanceof IValuable){
            ((IHero) other).setScore(((IHero) other).getScore()+((IValuable) element).getValue());
        }
    }

    /**
     * Unlock all the doors in the level
     * @param element
     * element which allow unlock the door
     * @param other
     * other which allow unlock the door
     */
    private void performUnlock(IElement element, IElement other){
        if(other instanceof IHero) {
            ILevel level = this.model.getLevel();
            for (int y = 0; y < level.getDimention().getHeight(); y++) {
                for (int x = 0; x < level.getDimention().getWidth(); x++) {
                    IElement ele = level.getElement(x, y);
                    if (ele instanceof IDoor) {
                        ((IDoor) ele).setUnlocked(true);
                    }
                }
            }
            if(element instanceof IValuable) {
                IHero h = this.model.getLevel().getHero();
                h.setScore(h.getScore() + ((IValuable) element).getValue());
            }
        }
    }

    /**
     * The spell destroy the monster
     * @param element
     * Spell which destroy the element
     * @param other
     * Spell which destroy other
     */
    private void performSpell(IElement element, IElement other){
        if(other instanceof IHero){
            ((IHero) other).setSpell(true);
            this.model.getLevel().destroyElement(element);
        } else if(other instanceof IMonster){
            this.model.getLevel().destroyElement(other);
            IHero h = this.model.getLevel().getHero();
            h.setScore(h.getScore() + ((IMonster) other).getValue());
        }
    }

    /**
     * End the level and load the next one
     * @param element
     * Load the element
     * @param other
     * Load other
     */
    private void performEnd(IElement element, IElement other){
        if(other instanceof IHero){
            if(!this.model.getLevel().isFinished()) {
                this.model.getLevel().setFinished(true);
                IHero h = this.model.getLevel().getHero();
                h.setScore(h.getScore() + this.model.getLevel().getValue());
            } else {
                this.model.loadNextLevel();
            }
        }
    }
}
