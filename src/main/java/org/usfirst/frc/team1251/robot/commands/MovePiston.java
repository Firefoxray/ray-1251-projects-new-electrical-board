package org.usfirst.frc.team1251.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team1251.robot.subsystems.DoubleSolenoidGearShifter;
import org.usfirst.frc.team1251.robot.subsystems.Piston;

public class MovePiston extends Command {
    private final Piston shifter;
    private final DoubleSolenoidGearShifter.Gear goal;

    public MovePiston(Piston shifter, Piston.Gear goal) {

        this.shifter = shifter;
        this.goal = goal;
        this.setInterruptible(false);
        requires(this.shifter);
    }

    @Override
    protected void execute() {
        shifter.setGear(goal);
    }

    @Override
    protected boolean isFinished() {
        return false;
    }
}