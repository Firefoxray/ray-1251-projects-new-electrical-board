package org.usfirst.frc.team1251.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team1251.robot.commands.DeferredCmdSupplier;

abstract public class DoubleSolenoidGearShifter extends Subsystem {

    private Gear currentGear;
    boolean isInverted = false;
    DoubleSolenoid solenoid;

    public enum Gear {
        HIGH, LOW
    }

    private final DeferredCmdSupplier<Command> defaultCommand;

    DoubleSolenoidGearShifter(DeferredCmdSupplier<Command> defaultCommand) {
        this.defaultCommand = defaultCommand;
    }

    @Override
    protected void initDefaultCommand() {
        this.setDefaultCommand(this.defaultCommand.get());
    }

    public void setGear(Gear goal) {
        // If the goal matches the current gear, do nothing.
        if (this.currentGear == goal) {
            return;
        }

        // Examine the goal
        if (goal == Gear.HIGH) {
            this.solenoid.set(this.isInverted ? DoubleSolenoid.Value.kReverse : DoubleSolenoid.Value.kForward);
        } else {
            // If not high, then low. That's the only other option.
            this.solenoid.set(this.isInverted ? DoubleSolenoid.Value.kForward : DoubleSolenoid.Value.kReverse);
        }

        this.currentGear = goal;
    }

    public Gear getGear() {
        return this.currentGear;
    }
}
