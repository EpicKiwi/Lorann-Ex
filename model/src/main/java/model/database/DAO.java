package model.database;

//import java.util.logging.Level;

import java.sql.ResultSet;

/**
 * Created by Marie on 14/06/2016.
 */
public class DAO {

    public DAO (IStockable table){
    }

    public boolean save(){
        return true;
    }
    public  boolean load(Integer id){
        return true;
    }
    public ResultSet finAll(){
        return null;
    }

}
