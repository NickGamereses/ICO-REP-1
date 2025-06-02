package rbt;
import robocode.*;
import java.awt.Color;

/**
* DefMode - A Robocode robot
* @author: Roger Oba
* @date: September 2014
*
* This robot won 2nd place in an internal Robocode tournament. The 1st place had a complex algorithm with over 1k LOC, and most other participants had over 600 LOC ;)
*
* Benchmark: out of 10000 battles against the "Walls" robot, this robot won 9829 and lost 171 times (98.29%).
*/
public class DefMode extends AdvancedRobot {
  int gunDirection = 1;

  public void run() {
    // Mere aesthetic changes
    setBodyColor(Color.black);
    setRadarColor(Color.green);
    setGunColor(Color.black);
    setBulletColor(Color.orange);

    // Turns the gun infinitely, looking for enemies
    while (true) {
      turnGunRight(360);
    }
  }

  public void onScannedRobot(ScannedRobotEvent e) {
    // Turn the robot towards the enemy
    setTurnRight(e.getBearing());
    // Shoots always that it's aiming at the enemy
    setFire(3);
    // And move forward
    setAhead(100);
    // Inverts the gun direction on each turn
    gunDirection = -gunDirection;
    // Turn 360 degrees (clockwise or anti clockwise,)
    setTurnGunRight(360 * gunDirection);
    // Execute all the pending actions
    execute();
  }
}