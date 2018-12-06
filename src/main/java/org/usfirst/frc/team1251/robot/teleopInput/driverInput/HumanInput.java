package org.usfirst.frc.team1251.robot.teleopInput.driverInput;

import org.usfirst.frc.team1251.robot.commands.*;
import org.usfirst.frc.team1251.robot.teleopInput.gamepad.GamePad;
import org.usfirst.frc.team1251.robot.teleopInput.triggers.GamePadButtonTrigger;

/**
 *
 * This class translates driver input into easy-to-use values and command activations.
 *
 * All knowledge about which buttons/sticks do what is contained within this class -- no other code should be reading
 * directly from the driver input devices. By centralizing this knowledge, it becomes much easier to adjust the control
 * scheme since it is not scattered throughout the code base. This also uses "information hiding" to make sure that
 * the rest of the robot does care about the details of how driver input is interpreted.
 */
public class HumanInput {
    private static final double GEARBOX_DEAD_ZONE = 0.1;
    private static final double SMALL_MOTOR_DEAD_ZONE = 0.1;

    private final GamePadButtonTrigger shiftGearboxHighTrigger;
    private final GamePadButtonTrigger shiftGearboxLowTrigger;
    private final GamePadButtonTrigger movePistonOutTrigger;
    private final GamePadButtonTrigger movePistonInTrigger;


    private boolean commandTriggersAttached = false;

    /**
     * The number of input samples to use for smoothing out wheel speed input.
     */
    //private final static int WHEEL_SPEED_SMOOTHING_SAMPLES = 1;

    /**
     * The game pad which is used to move the robot around the field.
     *
     */
    public final GamePad driverGamePad;

    /**
     * The game pad which is used to interact with the crates (e.g. "power cubes").
     */
    public final GamePad operatorGamePad;

    public HumanInput(GamePad driverGamePad, GamePad operatorGamePad) {
        this.driverGamePad = driverGamePad;
        this.operatorGamePad = operatorGamePad;

        //Solenoid Triggers.
        this.shiftGearboxHighTrigger = new GamePadButtonTrigger(this.driverGamePad.x());
        this.shiftGearboxLowTrigger = new GamePadButtonTrigger(this.driverGamePad.y());
        this.movePistonOutTrigger = new GamePadButtonTrigger(this.driverGamePad.a());
        this.movePistonInTrigger = new GamePadButtonTrigger(this.driverGamePad.b());
    }

    public void attachCommandTriggers(ShiftGearbox shiftGearboxHigh,
                                      ShiftGearbox shiftGearboxLow,
                                      MovePiston movePistonOut,
                                      MovePiston movePistonIn) {
        // Prevent duplicate bindings.
        if (commandTriggersAttached) {
            return;
        }
        commandTriggersAttached = true;

        // Bind buttons.
        shiftGearboxHighTrigger.whenPressed(shiftGearboxHigh);
        shiftGearboxLowTrigger.whenPressed(shiftGearboxLow);

        movePistonOutTrigger.whenPressed(movePistonOut);
        movePistonInTrigger.whenPressed(movePistonIn);
    }

    public double getGearboxForwardSpeed() {
        double gearboxStick = driverGamePad.ls().getVertical(GEARBOX_DEAD_ZONE);
        if (gearboxStick > 0){
            return gearboxStick;
        } else {
            return 0;
        }
    }

    public double getGearboxReverseSpeed() {
        double gearboxStick = driverGamePad.ls().getVertical(SMALL_MOTOR_DEAD_ZONE);
        if (gearboxStick < 0){
            return Math.abs(gearboxStick);
        } else {
            return 0;
        }
    }

    public double getSmallMotorForwardSpeed() {
        double smallMotorStick = driverGamePad.rs().getVertical(SMALL_MOTOR_DEAD_ZONE);
        if (smallMotorStick < 0){
            return smallMotorStick;
        } else {
            return 0;
        }
    }

    public double getSmallMotorReverseSpeed() {
        double smallMotorStick = driverGamePad.rs().getVertical(SMALL_MOTOR_DEAD_ZONE);
        if (smallMotorStick < 0){
            return Math.abs(smallMotorStick);
        } else {
            return 0;
        }
    }

}