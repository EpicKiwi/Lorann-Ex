package controller;

import contract.Direction;
import contract.IAI;
import contract.IModel;

class AIManager {
    private static AIManager ourInstance;
    private IModel model;
    private MoveManager mm;

    public static AIManager getInstance() {
        if(ourInstance == null)
            System.err.println("AI manager not initialized");
        return ourInstance;
    }

    public static void init(IModel model){
        ourInstance = new AIManager(model);
    }

    private AIManager(IModel model) {
        this.model = model;
        this.mm = MoveManager.getInstance();
    }

    // METHODS //

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
        }
    }

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
                    nextY++;
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

    void performRandom(IAI ai){
        //TODO Random AI
    }
}
