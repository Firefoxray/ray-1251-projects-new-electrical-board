package org.usfirst.frc.team1251.robot.teleopInput.gamepad;


/**
 * Represents one of the analog trigger buttons on the game pad. The trigger buttons can be represented as being
 * simply "on" or "off" but their value can be examined to determine how far the trigger is depressed.
 */
public interface TriggerButton extends GamePadButton {

    /**
     * Indicates whether or not the trigger is currently pressed when adjusted for a deadZone.
     *
     * @param deadZone A number between 0 and 1 representing how much pressure on the trigger to ignore.
     *
     * Note, for controllers which do not support analog feedback from trigger buttons a deadzone can not be applied.
     * In these cases, this method is still safe to call but the provided dead zone is effectively ignored.
     *
     * @return If the trigger value is higher than the deadZone then the value will be returned. Otherwise a value
     *         of 0 will be returned.
     */
     boolean isPressed(double deadZone);

    /**
     * A value between 0.0 and 1.0 as reported by the trigger. The higher the value, the harder the button is being
     * pressed.
     *
     * Note, not all game pads support analog feedback from trigger buttons. For controllers which do not, this will
     * always return 0.0 or 1.0 depending on whether the button is being pressed or not, respectively.
     *
     * @return The current value being reported by the trigger. This will be a number between 0 and 1.0. For controllers
     *         that support it, partial presses register somewhere above 0 and below 1.
     */
     double getValue();

    /**
     * A value between 0.0 and 1.0 as reported by the trigger. The higher the value, the harder the button is being
     * pressed.
     *
     * Note, for controllers which do not support analog feedback from trigger buttons a deadzone can not be applied.
     * In these cases, this method is still safe to call; it will always return 0 or 1, without regard to the
     * provided dead zone.
     *
     * @return A value representing the position of the trigger where 1 is fully depressed and 0 is not depressed
     *         at all. If the raw value of the trigger does not exceed the dead zone, then the value will be
     *         reported as 0.
     */
     double getValue(double deadZone);
}
