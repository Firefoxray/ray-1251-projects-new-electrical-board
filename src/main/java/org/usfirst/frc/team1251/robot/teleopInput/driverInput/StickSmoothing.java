package org.usfirst.frc.team1251.robot.teleopInput.driverInput;

import org.usfirst.frc.team1251.robot.teleopInput.gamepad.Stick;

/**
 * Smooths out stick values over a defined number of past readings.
 */
public class StickSmoothing {

    /**
     * Identifies which axis to read on the stick.
     */
    public enum StickAxis {
        VERTICAL, HORIZONTAL
    }

    /**
     * A record of past readings used to smooth out the latest stick value.
     */
    private double[] smoothing;

    /**
     * The stick to apply smoothing to.
     */
    private final Stick stick;

    /**
     * The number of past readings to use to smooth out the current value.
     */
    private final int numSamples;

    /**
     * The axis to read.
     */
    private final StickAxis stickAxis;

    /**
     *
     * @param stick The stick to apply smoothing to.
     * @param axis  Indicates whether to read the vertical or horizontal axis value of the stick.
     * @param numSamples The number of samples to apply
     */
    public StickSmoothing(Stick stick, StickAxis axis, int numSamples) {
        this.stick = stick;
        this.stickAxis = axis;
        this.numSamples = numSamples;
        this.smoothing = new double[numSamples];
    }

    /**
     * Provides a value smoothed over the previous readings.
     *
     * Each time this method is called, the current
     *
     * @return The current value of the stick smoothed over previous readings.
     */
    public double getSmoothedValue() {
        if (stickAxis == StickAxis.HORIZONTAL) {
            return this.applySmoothing(this.stick.getHorizontal());
        } else {
            return this.applySmoothing(this.stick.getVertical());
        }
    }

    /**
     * Applies smoothing to the current stick value, adding the current value to the history of recent reads.
     *
     * @param currentValue The current stick reading.
     *
     * @return The current stick value smoothed over past readings.
     */
    private double applySmoothing(double currentValue) {
        double sum = 0.0;
        for (int i = 0; i < numSamples; i++) {
            if (i < numSamples - 1) {
                smoothing[i] = smoothing[i + 1];
                sum += smoothing[i];
            } else {
                smoothing[i] = currentValue;
                sum += currentValue;
            }
        }

        return sum / numSamples;
    }
}