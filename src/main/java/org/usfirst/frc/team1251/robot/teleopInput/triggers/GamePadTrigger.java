package org.usfirst.frc.team1251.robot.teleopInput.triggers;

import edu.wpi.first.wpilibj.buttons.Trigger;
import org.usfirst.frc.team1251.robot.teleopInput.gamepad.LegacyGamePad;

/**
 * A base class for tele-op triggers which are based off of input from a game pad.
 *
 * To implement, simply extend and provide a `get()` method which inspects appropriate button states.
 */
abstract public class GamePadTrigger extends Trigger {

    protected final LegacyGamePad gamePad;

    GamePadTrigger(LegacyGamePad gamePad) {
        this.gamePad = gamePad;
    }
}
