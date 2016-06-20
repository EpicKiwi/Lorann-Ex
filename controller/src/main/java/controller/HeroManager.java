package controller;

import contract.Direction;
import contract.IHero;
import contract.IModel;

class HeroManager {
    private static HeroManager ourInstance;
    private IModel model;
    private MoveManager mm;

    public static HeroManager getInstance() {
        if(ourInstance == null)
            System.err.println("Hero Manager not initialized");
        return ourInstance;
    }

    public static void init(IModel model){
        ourInstance = new HeroManager(model);
    }

    private HeroManager(IModel model) {
        this.model = model;
        this.mm = MoveManager.getInstance();
    }

    // METHODS //

    /**
     * Direction of the hero
     * @param direction
     * @return A boolean representing if the movement was possible
     */
    public boolean move(Direction direction){
        IHero h = this.model.getLevel().getHero();
        if(!h.isAlive() || this.model.getLevel().isFinished())
            return false;
        int nextX = h.getLocation().getX();
        int nextY = h.getLocation().getY();
        switch (direction){
            case UP:
                nextY--;
                break;
            case DOWN:
                nextY++;
                break;
            case LEFT:
                nextX--;
                break;
            case RIGHT:
                nextX++;
                break;
            default:
                System.out.println("Invalid direction move");
                break;
        }
        h.setDirection(direction);
        return mm.safeMoveTo(h,nextX,nextY);
    }

    /**
     * Spell of the hero
     */
    public void sendSpell(){
        IHero h = this.model.getLevel().getHero();
        if(!h.isAlive())
            return;
        if(!h.isSpell())
            return;
        int spellX = h.getLocation().getX();
        int spellY = h.getLocation().getY();
        switch(h.getDirection()){
            case UP:
                spellY--;
                break;
            case DOWN:
                spellY++;
                break;
            case LEFT:
                spellX--;
                break;
            case RIGHT:
                spellX++;
                break;
            default:
                System.err.println("Not valid direction spell");
                break;
        }
        if(mm.canMoveOn(spellX,spellY))
            this.model.getLevel().createSpell(spellX,spellY,h.getDirection());
        h.setSpell(false);
    }
}
