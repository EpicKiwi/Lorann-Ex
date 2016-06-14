package model.database;

/**
 * An Interface for the differents possibility of storage in the DB
 * @Marie
 */
public interface IStockable {
    /**
     * A methods which allow to storage the data in the DB
     * @param
     * @param
     */


    public String getSaveQuery();
    public String load();
    public String getTableName();
}
