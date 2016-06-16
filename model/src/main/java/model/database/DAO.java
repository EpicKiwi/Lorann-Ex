package model.database;


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


    }

