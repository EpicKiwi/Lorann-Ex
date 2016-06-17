package model.elements;

import contract.Behavior;
import contract.IDoor;
import contract.ISprite;
import model.Sprite;

import java.awt.*;

/**
 * The door of the level
 * @author Marie
 */
public class Door extends Element implements IDoor {

    protected boolean unlocked;

    protected ISprite lockedSprite;

    /**
     * localisation and image Door
     * @param x
     * @param y
     */
    public Door(int x, int y) {
        super(x, y, "sprites/gate_open.png");
        this.unlocked = false;
        this.lockedSprite = new Sprite("sprites/gate_closed.png");
        this.permeable = true;
        this.behavior = Behavior.DEATH;
    }

    /**
     * Get the type of this element
     * @return door
     */
    public String getType() {
        return "door";
    }

    @Override
    public Image getImage() {
        if(this.unlocked) {
            return super.getImage();
        } else {
            return this.lockedSprite.getImage();
        }
    }

    public boolean isUnlocked() {
        return unlocked;
    }

    public void setUnlocked(boolean unlocked) {
        this.unlocked = unlocked;
    }

    @Override
    public Behavior getBehavior() {
        if(this.unlocked)
            this.behavior = Behavior.END;
        else
            this.behavior = Behavior.DEATH;
        return this.behavior;
    }
}
