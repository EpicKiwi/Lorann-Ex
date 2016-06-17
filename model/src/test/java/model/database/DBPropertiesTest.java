package model.database;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Tests of the class CBProperties
 */
public class DBPropertiesTest {

    DBProperties tst;

    @Before
    public void setUp() throws Exception {
        tst = new DBProperties();
    }

    @Test
    public void getUrl() throws Exception {
        assertEquals("jdbc:mysql://89.234.180.20:3306/wbuiyx_marie?autoReconnect=true&useSSL=false",tst.getUrl());
    }

    @Test
    public void getLogin() throws Exception {
        assertEquals("wbuiyx_marie",tst.getLogin());
    }

    @Test
    public void getPassword() throws Exception {
        assertEquals("marie",tst.getPassword());
    }

}