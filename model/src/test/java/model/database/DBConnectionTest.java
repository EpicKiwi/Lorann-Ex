package model.database;

import org.junit.Before;
import org.junit.Test;

import java.sql.ResultSet;

import static org.junit.Assert.*;

/**
 * Tests of the class DBConnection
 */
public class DBConnectionTest {

    DBConnection tst;

    @Before
    public void setUp() throws Exception {
        tst = DBConnection.getInstance();
    }

    @Test
    public void getConnection() throws Exception {
        assertFalse(tst.getConnection().isClosed());
    }

    @Test
    public void getInstance() throws Exception {
        assertNotNull(tst);
    }

    @Test
    public void findLevel() throws Exception {
        ResultSet res = tst.findLevel(0);
        assertNotNull(res);
        if(res.first()){
            assertEquals(20,res.getInt(3));
            assertEquals(12,res.getInt(4));
        } else {
            fail("No result for level 0");
        }
    }

    @Test
    public void findElements() throws Exception {
        ResultSet res = tst.findElements(0);
        assertNotNull(res);
        if(!res.first()){
            fail("No result for the elements of level 0");
        }
    }

    @Test
    public void findAllLevels() throws Exception {
        ResultSet res = tst.findAllLevels();
        assertNotNull(res);
        if(!res.first()){
            fail("No result for levels");
        }
    }
}