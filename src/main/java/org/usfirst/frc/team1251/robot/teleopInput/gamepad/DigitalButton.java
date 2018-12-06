package org.usfirst.frc.team1251.robot.teleopInput.gamepad;

import edu.wpi.first.wpilibj.GenericHID;

/**
 * Represents a game pad button which can be simply represented as "on" or "off".
 * TODO-maybe: add isJustPressed()/isJustReleased() -- hard for analog trigger buttons.
 */
public class DigitalButton implements GamePadButton {

    private final int buttonID;
    private final GenericHID rawDevice;

    /**
     *
     * @param buttonID The raw button to inspect to determine the trigger's simple "on/off" state.
     * @param rawDevice The raw HID device that contains this button.
     */
     DigitalButton(int buttonID, GenericHID rawDevice) {
        this.buttonID = buttonID;
         this.rawDevice = rawDevice;
     }

    @Override
    public boolean isPressed() {
        return rawDevice.getRawButton(this.buttonID);
    }
}
