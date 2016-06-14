package model.database;

/**
 * Created by Marie on 14/06/2016.
 */
public interface IStockable {

    public String getSaveQuery();
    public String load();
    public String getTableName();
}
