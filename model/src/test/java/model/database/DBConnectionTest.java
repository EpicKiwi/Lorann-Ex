package model.database;

import contract.Direction;
import org.junit.Before;
import org.junit.Test;

import java.sql.ResultSet;

import static org.junit.Assert.*;

/**
 * Test of the class DBConnection
 */
public class DBConnectionTest {

    DBConnection t;

    @Before
    public void setUp() throws Exception {
        t = DBConnection.getInstance();
    }

    @Test
    public void testGetInstaceShouldReturnCorrectInstance() throws Exception {
        assertNotNull("Instance can't be null",t);
    }

    @Test
    public void testGetConnectionShouldReturnCorrectOpenedWritableConnection() throws Exception {
        assertNotNull("Connection can't be null",t.getConnection());
        assertFalse("Connection should be opened",t.getConnection().isClosed());
        assertFalse("Connection should be writable",t.getConnection().isReadOnly());
    }

    @Test
    public void testFindAllLevelsShouldReturnResultLevelsOrdered() throws Exception {
        ResultSet res = t.findAllLevels();
        assertNotNull("Result can't be null",res);
        assertTrue("Result is empty",res.first());
        int lastNumber = res.getInt(2);
        while(res.next()){
            assertTrue("Result set should be ordered by number",res.getInt(2) >= lastNumber);
            assertTrue("Level's number should be greater than 0",res.getInt(2) > 0);
            assertTrue("Level's widths should be greater than 0",res.getInt(3) > 0);
            assertTrue("Level's heights should be greater than 0",res.getInt(4) > 0);
            lastNumber = res.getInt(2);
        }
    }

    @Test
    public void testFindLevelShouldReturnOneValidLevelResult() throws Exception {
        ResultSet res = t.findLevel(0);
        assertNotNull("Result set can't be null",res);
        assertTrue("Result is empty",res.first());
        assertTrue("Level's number should be greater than 0",res.getInt(2) > 0);
        assertTrue("Level's width should be greater than 0",res.getInt(3) > 0);
        assertTrue("Level's height should be greater than 0",res.getInt(4) > 0);
        assertFalse("Result contains more than one level",res.next());
    }

    @Test
    public void testFindElementsShouldReturnElementsOfLevel() throws Exception {
        ResultSet res = t.findElements(0);
        assertNotNull("Result set can't be null",res);
        assertTrue("A level should have more than 0 elements",res.first());
        res.beforeFirst();
        while(res.next()){
            assertNotNull("All elements should have a type",res.getString(2));
            assertTrue("All elements should have an X position greater than -1",res.getInt(3) > -1);
            assertTrue("All elements should have an Y position greater than -1",res.getInt(4) > -1);
        }
    }
}