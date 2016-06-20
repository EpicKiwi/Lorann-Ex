package controller;

import controller.Clock;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * The test class of the class Clock
 * @see Clock
 */
public class ClockTest {

    Clock clock;

    @Before
    public void setUp() throws Exception {
        this.clock = new Clock(null);
    }

    @Test
    public void getTickNumber() throws Exception {
        assertEquals(0,this.clock.getTickNumber());
    }

    @Test
    public void getTickInterval() throws Exception {
        assertEquals(Clock.DEFAULT_TICK_INTERVAL,this.clock.getTickInterval());
    }

    @Test
    public void setTickInterval() throws Exception {
        assertEquals(Clock.DEFAULT_TICK_INTERVAL,this.clock.getTickInterval());
        this.clock.setTickInterval(2);
        assertEquals(2,this.clock.getTickInterval());
    }

    @Test
    public void run() throws Exception {
        this.clock.run();
        assertEquals(1,this.clock.getTickNumber());
    }
}