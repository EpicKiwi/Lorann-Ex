package model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ModelTest {

    Model model;

    @Before
    public void setUp() throws Exception {
        this.model = new Model();
        this.model.loadLevel(0);
    }

    @Test
    public void getLevel() throws Exception {
        assertNotNull(this.model.getLevel());
    }

    @Test
    public void loadLevel() throws Exception {
        this.model.loadLevel(1);
        assertNotNull(this.model.getLevel());
    }

    @Test
    public void saveLevel() throws Exception {

    }

    @Test
    public void getObservable() throws Exception {
        this.model.loadLevel(1);
        assertNotNull(this.model.getObservable());
    }

}