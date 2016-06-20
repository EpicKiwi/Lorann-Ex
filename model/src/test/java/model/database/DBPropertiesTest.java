package model.database;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Tests for the DBProperties Class
 */
public class DBPropertiesTest {

    DBProperties t;

    @Before
    public void setUp() throws Exception {
        t = new DBProperties();
    }

    @Test
    public void testGetLoginGetPasswordShouldReturnValidStrings() throws Exception {
        assertNotNull("Login field can't be null",t.getLogin());
        assertNotEquals("It should have a login","",t.getLogin());
        assertNotNull("Password field can't be null",t.getPassword());
        //Password field can be empty
    }

    @Test
    public void testGetUrlShouldReturnValidJdbcMysqlUrl() throws Exception {
        assertNotNull("URL field is null",t.getUrl());
        assertNotEquals("It should have an URL","",t.getUrl());
        assertTrue("The Url is not a valid JDBC Url with Mysql driver",
                t.getUrl().matches("^jdbc:mysql://(.+)(:[0-9]+)?/(.+)[?]autoReconnect=true&useSSL=false$"));
    }
}