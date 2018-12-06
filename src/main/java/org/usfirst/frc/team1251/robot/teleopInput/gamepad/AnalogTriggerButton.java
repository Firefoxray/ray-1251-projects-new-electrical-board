package org.usfirst.frc.team1251.robot.teleopInput.gamepad;

import edu.wpi.first.wpilibj.GenericHID;

public class AnalogTriggerButton implements TriggerButton {

    private final int axisID;
    private final GenericHID rawDevice;
    private final static double PRESSED_DEAD_ZONE = .5;

    /**
     *
     * @param axisID   The raw axis which governs this trigger button.
     * @param rawDevice
     */
    public AnalogTriggerButton(int axisID, GenericHID rawDevice) {
        this.rawDevice = rawDevice;
        this.axisID = axisID;
    }

    @Override
    public boolean isPressed() {
        return this.isPressed(PRESSED_DEAD_ZONE);
    }

    @Override
    public boolean isPressed(double deadZone) {
        return this.getValue(deadZone) > 0;
    }

    @Override
    public double getValue() {
        return rawDevice.getRawAxis(this.axisID);
    }

    @Override
    public double getValue(double deadZone) {
        return Math.max(0, (this.getValue() - Math.abs(deadZone)));
    }
}
