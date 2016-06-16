package controller;

import java.util.Observable;

public class Clock extends Observable implements Runnable {

    /** The number of ticks since the beginning of the game */
    private int tickNumber;
    /** The interval between two ticks */
    private long tickInterval;
    /** Representing if the clock is stopped or started */
    private boolean stopped;
    /** The default interval between two ticks */
    public static int DEFAULT_TICK_INTERVAL = 500;

    /**
     * Instantiates a new Clock
     */
    public Clock() {
        this.tickNumber = 0;
        this.setTickInterval(DEFAULT_TICK_INTERVAL);
    }

    /**
     * Instantiates a new clock with a specified interval
     *
     * @param tickInterval
     * the interval between two ticks
     */
    public Clock(int tickInterval) {
        this.tickNumber = 0;
        this.setTickInterval(tickInterval);
        this.stopped = false;
    }

    /**
     * The method executed in the new thread
     */
    public void run() {
        while(true) {
            this.setChanged();
            this.notifyObservers(stopped);
            try {
                Thread.sleep(this.tickInterval);
            } catch (InterruptedException e) {
                System.err.println("Clock thread interrupted");
                e.printStackTrace();
            }
            this.tickNumber++;
        }
    }

    // GETTERS & SETTERS //

    /**
     * Get the number of tick since the beginning
     * @return
     * The number of ticks since the beginning
     */
    public int getTickNumber() {
        return tickNumber;
    }

    /**
     * Get the interval between two ticks
     * @return
     * The interval in miliseconds
     */
    public long getTickInterval() {
        return tickInterval;
    }

    /**
     * Set the interval between two ticks
     * @param tickInterval
     * The new interval in milliseconds
     */
    public synchronized void setTickInterval(long tickInterval) {
        this.tickInterval = tickInterval;
    }

    /**
     * Get if the clock is stopped
     * @return
     * True if the clock is stopped
     */
    public boolean isStopped() {
        return stopped;
    }

    /**
     * Stop the clock
     */
    public void stopClock() {
        this.stopped = true;
    }
}
