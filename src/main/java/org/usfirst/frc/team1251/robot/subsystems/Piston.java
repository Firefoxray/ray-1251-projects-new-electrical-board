package org.usfirst.frc.team1251.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team1251.robot.RobotMap;
import org.usfirst.frc.team1251.robot.commands.DeferredCmdSupplier;

public class Piston extends DoubleSolenoidGearShifter{

    public Piston(DeferredCmdSupplier<Command> defaultCommand)
    {
        super(defaultCommand);
        this.isInverted = false;
        this.solenoid = new DoubleSolenoid(RobotMap.PISTON_OUT, RobotMap.PISTON_IN);
    }
}
