package model;


import contract.*;
import model.elements.Element;
import model.elements.Hero;
import model.elements.Spell;

import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *@author Marie
 * level of the game
 */
public class Level implements ILevel {

    private int number;
    private boolean exit = false;

    private ArrayList<IEntity> entities;
    /**
     * Interface of Element
     */
    private IElement elements[][];

    /**
     * Interface of hero
     */

    private IHero hero;

    /**
     * Interface of dimention
     */
    private IDimention dimention;

    /**
     * Indicate if the level is finished
     */
    private boolean finished;
    

    /**
     * Localisation of elements
     * @param width
     * @param height
     * @param hero
     *
     */
    public Level(int width, int height, Hero hero, int number) {
        this.dimention = new Dimention(width,height);
        this.hero = hero;
        this.number = number;
        this.elements = new Element[height][width];
        this.entities = new ArrayList<IEntity>();

    }

    public Level(int id, String id1) {
    }

    public Level(int id) {

    }


    public boolean setElement(Integer x, Integer y, IElement element){
        return false;
    }

    /**
     * Add the entity
     * @param entity
     */
    public void addEntity(IEntity entity){
        this.entities.add(entity);
    }

    /**
     * Remove the entity
     * @param entity
     */
    public void removeEntity(IEntity entity){
        this.entities.remove(entity);
    }

    public String getTableName() {
        return ("level");
    }

    public String getLoadQuery(int id) {
        return null;
    }
    //GETTER & SETTER

    /**
     * Get the number of level
     * @return
     * The number
     */
    public int getNumber() {
        return number;
    }
    /**
     * Set the number of level
     * @param number
     * The number
     */
    public void setNumber(int number) {
        this.number = number;
    }
    /**
     * Get the dimention of level
     * @return
     * The dimention
     */
    public IDimention getDimention() {
        return dimention;
    }
    /**
     * Set the dimention of level
     * @param dimention
     * The dimention
     */
    public void setDimention(IDimention dimention) {
        this.dimention = dimention;
    }
    /**
     * Get the hero of level
     * @return
     * The Hero
     */
    public IHero getHero() {
        return hero;
    }
    /**
     * Set the hero of level
     * @param hero
     * The hero
     */
    public void setHero(IHero hero) {
        this.hero = hero;
    }

    public IElement[][] getElements() {
        return elements;
    }
    /**
     * Set the element of the level
    * @return
     *The element
    */
    public void setElements(IElement[][] elements) {
        this.elements = elements;
    }
    /**
     * Get the element of level
     * @return
     * The element
     */
    public IElement getElement(int x, int y){
        return this.elements[y][x];
    }

    /**
     * Localisation of element
     * @param x
     * localisation x
     * @param y
     * localisation y
     * @param element
     */
    public void setElement(int x, int y, IElement element){
        this.elements[y][x] = element;
    }
    /**
     * Get the entities of the level
     * @return
     * The entity
     */
    public ArrayList<IEntity> getEntities() {
        return (ArrayList<IEntity>) entities.clone();
    }
    /**
     * Set the entities of the level
     * @param entities
     * The entity
     */
    public void setEntities(ArrayList<IEntity> entities) {
        this.entities = entities;
    }
    /**
     * Is (get) the exit of the level
     * @return
     * The sprite
     */
    public boolean isExit() {
        return exit;
    }
    /**
     * Set exit of the level
     * @param exit
     * The exit
     */
    public void setExit(boolean exit) {
        this.exit = exit;
    }

    public boolean isFinished() {
        return finished;
    }

    public void setFinished(boolean finished) {
        this.finished = finished;
    }

    public void createSpell(int x, int y, Direction direction) {
        this.addEntity(new Spell(x,y,direction));
    }

    public void destroyElement(IElement element){
        if(element instanceof IEntity){
            this.entities.remove(element);
        } else {
            this.setElement(element.getLocation().getX(),element.getLocation().getY(),null);
        }
    }
}

