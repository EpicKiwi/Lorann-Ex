package model.database;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * An Interface for the differents possibility of storage in the DB
 * @Marie
 */
public interface IStockable {

    /**
     * A method loading the object from a result set
     * @return
     */
    void load(ResultSet raw) throws SQLException;

    /**
     * Get the name of the table
     * @return
     */

    String getTableName();
    /**
     * Get the Query / element of the table
    * @return
     */
    String getLoadQuery(int id);

}
