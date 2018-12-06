package org.usfirst.frc.team1251.robot;

/**
 * Represents the bot's coordinates and heaing.
 *
 * All values are relative to the robot's starting position.
 *
 * The value of `x` changes as the Robot moves to the rightwards (increases) or leftwards (decreases) on the field.
 * The value of `y` changes as the Robot moves backwards (decreases) or forwards(increases) on the field.
 * The value of `heading` changes as the Robot turns rightwards (increases towards 180) or leftwards (decreases towards
 * -180);
 *
 * Note, the terms "rightwards", "leftwards", "forwards", and "backwards" are from the perspective of the Robot's
 * starting side on the field. For reference, in the following diagrams "R" marks the starting side of the robot on
 * the field.
 *
 *
 *
 *                            ▲                             ¦                             ▲
 *                            |                             ¦                             |
 *                       forward (+y)                       ¦                         backward (-y)
 *                        (heading 0)                       ¦                       (heading +/-180)
 *                            |                             ¦                             |
 *                      -------------                       ¦                       -------------
 *                     |             |                      ¦                      |      R      |
 *                     |             |                      ¦                      |             |
 * <- leftward (-x) -- | ----------- | -- rightward (+x) -> ¦ <- rightward (+x) -- | ----------- | -- leftward (-x)->
 *    (heading -90)    |             |    (heading 90)      ¦     (heading 90)     |             |    (heading -90)
 *                     |      R      |                      ¦                      |             |
 *                      -------------                       ¦                       -------------
 *                            |                             ¦                             |
 *                        backward (-y)                     ¦                        forward (+y)
 *                      (heading +/-180)                    ¦                         (heading 0)
 *                            |                             ¦                             |
 *                            ▼                             ¦                             ▼
 *
 *
 *
 */
public class RobotPosition
{
    private double x;
    private double y;
    private double heading;

    /**
     * Creates an instance to represent the current position of the robot.
     *
     * @param x The current x coordinate of the robot.
     * @param y The current y coordinate of the robot.
     * @param heading The direction the robot is facing in degrees ranging from -180 to 180.
     */
    RobotPosition(double x, double y, double heading) {
        this.x = x;
        this.y = y;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getHeading() {
        return heading;
    }

    public void setHeading(double heading) {
        this.heading = heading;
    }
}
