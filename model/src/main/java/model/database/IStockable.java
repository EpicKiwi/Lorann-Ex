package model.database;

import java.sql.ResultSet;

/**
 * An Interface for the differents possibility of storage in the DB
 * @Marie
 */
public interface IStockable {

    /**
     * A method loading the object from a result set
     * @return
     */
    void load(ResultSet raw);

    /**
     * Get the name of the table
     * @return
     */
    String getTableName();
}