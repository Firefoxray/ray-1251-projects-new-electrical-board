package org.usfirst.frc.team1251.robot.teleopInput.gamepad;

import edu.wpi.first.wpilibj.GenericHID;

public class DigitalTriggerButton implements TriggerButton {

    private final DigitalButton digitalButton;

    /**
     *
     * @param buttonID The raw button to inspect to determine the trigger's simple "on/off" state.
     * @param rawDevice The raw HID device that contains this button.
     */
    DigitalTriggerButton(int buttonID, GenericHID rawDevice) {
        this.digitalButton = new DigitalButton(buttonID, rawDevice);
    }

    @Override
    public boolean isPressed(double deadZone) {
        // Can't do anything with the dead zone. We're digital. Just delegate to the digital button.
        return this.digitalButton.isPressed();
    }


    @Override
    public double getValue() {
        return this.isPressed() ? 1 : 0;
    }


    @Override
    public double getValue(double deadZone) {
        // Can't do anything with the dead zone -- we're digital. Just delegate to standard getValue()
        return this.getValue();
    }

    /**
     * Indicates whether or not this button is currently pressed.
     *
     * @return Returns `true` if the button is pressed or `false` if it is not.
     */
    @Override
    public boolean isPressed() {
        return this.digitalButton.isPressed();
    }
}
