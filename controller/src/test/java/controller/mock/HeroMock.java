package controller.mock;

import contract.*;

import java.awt.*;

public class HeroMock extends EntityMock implements IHero {

    boolean alive;
    Integer score;
    boolean spell;

    public HeroMock(int x, int y, Direction d) {
        super(x, y, true, d);
        this.alive = this.spell = true;
        this.score = 0;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public boolean isSpell() {
        return spell;
    }

    public void setSpell(boolean spell) {
        this.spell = spell;
    }

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }
}
