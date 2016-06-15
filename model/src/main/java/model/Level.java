package model;

import model.database.IStockable;
import model.elements.Element;
import model.elements.Entity;
import model.elements.Hero;

import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *@author Marie
 * level of the game
 */
public class Level implements IStockable {

    private int number;
    private boolean exit = false;

    private ArrayList<Entity> entities;
    /**
     * level of Element
     */
    private Element elements[][];
    /**
     * level of hero
     */

    private Hero hero;

    /**
     *level of dimention
     */

    private Dimention dimentation;


    public boolean setElement(Integer x, Integer y, Element element){
        return false;
    }
    private Integer number(){
        return null;
    }

    public void load(ResultSet raw) {

    }

    public String getTableName() {
        return ("level");
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Dimention getDimentation() {
        return dimentation;
    }

    public void setDimentation(Dimention dimentation) {
        this.dimentation = dimentation;
    }

    public Hero getHero() {
        return hero;
    }

    public void setHero(Hero hero) {
        this.hero = hero;
    }

    public Element[][] getElements() {
        return elements;
    }

    public void setElements(Element[][] elements) {
        this.elements = elements;
    }

    public Element getElement(int x, int y){
        return this.elements[y][x];
    }

    public void setElement(int x, int y, Element element){
        this.elements[y][x] = element;
    }

    public ArrayList<Entity> getEntities() {
        return entities;
    }

    public void setEntities(ArrayList<Entity> entities) {
        this.entities = entities;
    }

    public boolean isExit() {
        return exit;
    }

    public void setExit(boolean exit) {
        this.exit = exit;
    }
}

