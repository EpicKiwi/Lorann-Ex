package controller;

import contract.Direction;
import contract.IAI;
import contract.IEntity;
import contract.IModel;

import java.util.Random;

class AIManager {
    private static AIManager ourInstance;
    private IModel model;
    private MoveManager mm;
    private static Random random;

    public static AIManager getInstance() {
        if(ourInstance == null)
            System.err.println("AI manager not initialized");
        return ourInstance;
    }

    public static void init(IModel model){
        ourInstance = new AIManager(model);
        random = new Random();
    }

    private AIManager(IModel model) {
        this.model = model;
        this.mm = MoveManager.getInstance();
    }

    // METHODS //
/**
 * All the movement that AI can do
 * @param entity
 */
    void performAi(IAI entity){
        switch (entity.getAiType()){
            case STRAIGHT:
                this.performStraight(entity);
                break;
            case DIAGONAL:
                this.performDiagonal(entity);
                break;
            case RANDOM:
                this.performRandom(entity);
                break;
            case FOLLOW:
                this.performFollow(entity);
                break;
        }
    }
/**
 * Diagonal movement for the AI
 * @param ai
 */
    void performDiagonal(IAI ai){
        int nextX, nextY;
        do {
            nextX = ai.getLocation().getX();
            nextY = ai.getLocation().getY();
            switch (ai.getDirection()) {
                case TOPLEFT:
                    nextX--;
                    nextY--;
                    break;
                case TOPRIGHT:
                    nextX++;
                    nextY--;
                    break;
                case BOTTOMLEFT:
                    nextX--;
                    nextY++;
                    break;
                case BOTTOMRIGHT:
                    nextX++;
                    nextY++;
                    break;
                default:
                    System.out.println("Invalid direction for "+ai.toString());
                    break;
            }
            if (!this.mm.canMoveOn(nextX, nextY)) {
                switch (ai.getDirection()){
                    case TOPLEFT:
                        ai.setDirection(Direction.TOPRIGHT);
                        break;
                    case TOPRIGHT:
                        ai.setDirection(Direction.BOTTOMLEFT);
                        break;
                    case BOTTOMLEFT:
                        ai.setDirection(Direction.BOTTOMRIGHT);
                        break;
                    case BOTTOMRIGHT:
                        ai.setDirection(Direction.TOPLEFT);
                        break;
                }
            }
        }while (!this.mm.canMoveOn(nextX, nextY));
        mm.safeMoveTo(ai,nextX,nextY);
    }
/**
 * Lateral movement from the AI
 * @param ai
 */
    void performStraight(IAI ai){
        int nextX, nextY;
        do{
            nextX = ai.getLocation().getX();
            nextY = ai.getLocation().getY();
            switch (ai.getDirection()){
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
                    System.out.println("Invalid direction for "+ai.toString());
                    break;
            }
            if(!this.mm.canMoveOn(nextX, nextY)){
                switch (ai.getDirection()){
                    case UP:
                        ai.setDirection(Direction.DOWN);
                        break;
                    case DOWN:
                        ai.setDirection(Direction.UP);
                        break;
                    case LEFT:
                        ai.setDirection(Direction.RIGHT);
                        break;
                    case RIGHT:
                        ai.setDirection(Direction.LEFT);
                        break;
                    default:
                        System.out.println("Invalid direction for "+ai.toString());
                        break;
                }
            }
        }while(!this.mm.canMoveOn(nextX, nextY));
        mm.safeMoveTo(ai,nextX,nextY);
    }
/**
 * Random movement for the AI
 * @param ai
 */
    void performRandom(IAI ai){
        int nextX;
        int nextY;
        do{
            nextX = ai.getLocation().getX();
            nextY = ai.getLocation().getY();
            nextX += random.nextInt(3)-1;
            nextY += random.nextInt(3)-1;
        }while(!this.mm.canMoveOn(nextX, nextY));
        mm.safeMoveTo(ai,nextX,nextY);
    }
/**
 * Make the AI follow the hero
 * @param ai
 */
    void performFollow(IAI ai){
        if(!this.model.getLevel().getHero().isAlive())
            return;
        double heroX = this.model.getLevel().getHero().getLocation().getX();
        double heroY = this.model.getLevel().getHero().getLocation().getY();
        double aiX = ai.getLocation().getX();
        double aiY = ai.getLocation().getY();
        double coef = (heroY-aiY)/(heroX-aiX);
        if(heroX-aiX >= 0){
            if(coef >= 1.5){
                ai.setDirection(Direction.DOWN);
            } else if(coef >= 0.5){
                ai.setDirection(Direction.BOTTOMRIGHT);
            } else if(coef >= -0.5){
                ai.setDirection(Direction.RIGHT);
            } else if(coef >= -1.5){
                ai.setDirection(Direction.TOPRIGHT);
            } else {
                ai.setDirection(Direction.UP);
            }
        } else {
            if(coef >= 1.5){
                ai.setDirection(Direction.UP);
            } else if(coef >= 0.5){
                ai.setDirection(Direction.TOPLEFT);
            } else if(coef >= -0.5){
                ai.setDirection(Direction.LEFT);
            } else if(coef >= -1.5){
                ai.setDirection(Direction.BOTTOMLEFT);
            } else {
                ai.setDirection(Direction.DOWN);
            }
        }
        this.stepInDirection(ai);
    }
/**
 * Make a step in a direction
 * @param entity
 * @return
 */
    boolean stepInDirection(IEntity entity){
        int nextX = entity.getLocation().getX();
        int nextY = entity.getLocation().getY();
        switch(entity.getDirection()){
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
            case TOPLEFT:
                nextX--;
                nextY--;
                break;
            case TOPRIGHT:
                nextX++;
                nextY--;
                break;
            case BOTTOMLEFT:
                nextX--;
                nextY++;
                break;
            case BOTTOMRIGHT:
                nextX++;
                nextY++;
        }
        return this.mm.safeMoveTo(entity,nextX,nextY);
    }
}
