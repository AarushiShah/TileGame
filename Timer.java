/*
 * Filename: Timer.java
 * Author:   Aarushi Shah
 * UserId:   cs11fbbb
 * Date:     10/11/2018
 * Sources of help: Java: An Eventful Approach textbook (Figure 6.5)
 */

/**
 * Allows calculations of timing between events.
 */
public class Timer {

  private static final int MILLISECONDS_PER_SECOND = 1000;


  // Time when Timer started or reset
  private double startTime;


  /**
   * Creates timer, initializing startTime with current time.
   */
  public Timer() {
    startTime = System.currentTimeMillis();
  }

  /**
   * Returns number of milliseconds since last reset.
   *
   * @return number of milliseconds since last reset
   */
  public double elapsedMilliseconds() {
    return System.currentTimeMillis() - startTime;
  }

  /**
   * Returns number of seconds since last reset.
   *
   * @return number of seconds since last reset
   public double elapsedSeconds() {
    return this.elapsedMilliseconds() / MILLISECONDS_PER_SECOND;
  }

  /**
   * Resets startTime.
   */
  public void reset() {
    startTime = System.currentTimeMillis();
  }
}
