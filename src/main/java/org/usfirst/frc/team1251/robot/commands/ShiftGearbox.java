package org.usfirst.frc.team1251.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team1251.robot.subsystems.DoubleSolenoidGearShifter;
import org.usfirst.frc.team1251.robot.subsystems.GearboxShifter;

public class ShiftGearbox extends Command {
    private final GearboxShifter shifter;
    private final DoubleSolenoidGearShifter.Gear goal;

    public ShiftGearbox(GearboxShifter shifter, GearboxShifter.Gear goal) {
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