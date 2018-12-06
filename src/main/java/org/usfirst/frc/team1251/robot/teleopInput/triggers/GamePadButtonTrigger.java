package org.usfirst.frc.team1251.robot.teleopInput.triggers;

import edu.wpi.first.wpilibj.buttons.Button;
import org.usfirst.frc.team1251.robot.teleopInput.gamepad.GamePadButton;


/**
 * A trigger based off of a single game pad button.
 *
 * Example:
 *
 *  class Robot ... {
 *      private final Button X = new GamePadButtonTrigger(driverPad.X());
 *      ...
 *
 *  }
 *
 *
 *  X.whenActive(new OpenClawCommand());
 */
public class GamePadButtonTrigger extends Button {

    private final GamePadButton button;

    public GamePadButtonTrigger(GamePadButton button) {
        this.button = button;
    }

    @Override
    public boolean get() {
        return button.isPressed();
    }
}
