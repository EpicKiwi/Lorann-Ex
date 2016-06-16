package model.database;

//import java.util.logging.Level;

import model.elements.Element;

import java.sql.*;

/**
 * The class DAO
 * @Marie
 */
public class DAO {

    /**
     * A methodes to storage the data in DB
     *
     * @param table table of the DB
     */
    public DAO(IStockable table, Statement statement) {
    }

    /**
     * A methodes to save the data in DB
     *
     * @return false
     */
    public boolean save() {
        return false;
    }

    /**
     * A methode to loading the DB
     *
     * @return false
     */
    public boolean load(Integer id) {
        return false;
    }

    /**
     * A methode to get all result
     *
     * @return false
     */
    public ResultSet findAll() {
        return null;
    }

    // ResultSet
    ResultSet résultats = null;
    String requete = ("SELECT * FROM element");


    { //un objet de la classe statement permet d'envoyer des requetes SQL a base; s'ffectue a partir d'une instance de la classe connection
        Statement stmt = con.createStatement();
        try {
           ResultSet résultats = stmt.executeQuery("SELECT * FROM element");
        } catch (SQLException e) {
            e.printStackTrace();
            (SQLException e)
        }

    }

    }

