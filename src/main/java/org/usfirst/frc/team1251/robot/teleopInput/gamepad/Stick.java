package org.usfirst.frc.team1251.robot.teleopInput.gamepad;

import edu.wpi.first.wpilibj.GenericHID;

/**
 * Represents a stick on the controller. Each stick can report its horizontal and vertical values which each range
 * from -1 to 1.
 */
public class Stick {

    private final int verticalAxisID;
    private final int horizontalAxisID;
    private final GenericHID rawDevice;

    /**
     * @param horizontalAxisID The raw axis to inspect to get the horizontal position of the stick.
     * @param verticalAxisID The raw axis to inspect to get the vertical position of the stick.
     * @param rawDevice The raw HID that contains this stick.
     */
    Stick(int horizontalAxisID, int verticalAxisID, GenericHID rawDevice) {
        this.verticalAxisID = verticalAxisID;
        this.horizontalAxisID = horizontalAxisID;
        this.rawDevice = rawDevice;
    }

    /**
     * Provides the current vertical position of the stick.
     *
     * @return A value between -1 and 1 where < 0 represents a downward position and +1 represents an
     *         upward position.
     */
    public double getVertical() {
        return this.getVertical(.05);
    }

    /**
     * Provides the current vertical position of the stick ignoring values within the given deadZone.
     *
     * The deadZone extends out in all directions. Therefore, if the deadZone is given as 0.20 and the stick is at
     * 0.19 or -0.19, the return value would be 0.
     *
     * @param deadZone The distance from the center which should be ignored.
     *
     * @return A value between -1 and 1 where < 0 represents a downward position and > 0 represents an
     *     upward position.
     */
    public double getVertical(double deadZone) {
        return this.applyDeadZone(deadZone, rawDevice.getRawAxis(this.verticalAxisID) * -1);
    }

    /**
     * Provides the current horizontal position of the stick.
     **
     * @return A value between -1 and 1 where < 0 represents a leftward position and > 0 represents an
     *     rightward position.
     */
    public double getHorizontal() {
        return this.getHorizontal(.05);

    }

    /**
     * Provides the current horizontal position of the stick ignoring values within the given deadZone.
     *
     * The deadZone extends out in all directions. Therefore, if the deadZone is given as 0.20 and the stick is at
     * 0.19 or -0.19, the return value would be 0.
     *
     * @param deadZone The distance from the center which should be ignored.
     *
     * @return A value between -1 and 1 where < 0 represents a leftward position and > 0 represents an
     *     rightward position.
     */
    public double getHorizontal(double deadZone) {
        return this.applyDeadZone(deadZone, rawDevice.getRawAxis(this.horizontalAxisID));
    }

    /**
     * A helper which will apply a deadZone against a given axis value. Any value within the dead zone (positive or
     * negative) will be ignored. Any value which extends beyond the dead zone will be stretched back out into a
     * value between 0 and 1.
     *
     * @param deadZone The deadZone to apply. Dead zones apply in all directions, so the absolute value of this
     *                 parameter will be used.
     * @param axisValue The axis value to apply the deadZone to.
     *
     * @return The adjusted axis value.
     */
    private double applyDeadZone(double deadZone, double axisValue) {

        // Lifted logic from `DifferentialDrive.applyDeadBand()`
        if (Math.abs(axisValue) > deadZone) {
            if (axisValue > 0.0) {
                return (axisValue - deadZone) / (1.0 - deadZone);
            } else {
                return (axisValue + deadZone) / (1.0 - deadZone);
            }
        } else {
            return 0.0;
        }
    }
}
