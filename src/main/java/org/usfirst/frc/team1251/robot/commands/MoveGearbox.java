package org.usfirst.frc.team1251.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team1251.robot.subsystems.Gearbox;
import org.usfirst.frc.team1251.robot.teleopInput.driverInput.HumanInput;


public class MoveGearbox extends Command {

    private final HumanInput humanInput;
    private final Gearbox gearbox;

    public MoveGearbox(HumanInput humanInput, Gearbox gearbox){
        this.humanInput = humanInput;
        this.gearbox = gearbox;
        requires(this.gearbox);
    }

    @Override
    protected void execute(){
        double gearboxForwardSpeed = this.humanInput.getGearboxForwardSpeed();
        double gearboxReverseSpeed = this.humanInput.getGearboxReverseSpeed();

        if (gearboxForwardSpeed > 0) {
            this.gearbox.forward(gearboxForwardSpeed);
        } else if (gearboxReverseSpeed > 0) {
            this.gearbox.reverse(gearboxReverseSpeed);
        } else {
            this.gearbox.stop();
        }
    }

    @Override
    public void end() {
        this.gearbox.stop();
    }

    @Override
    protected boolean isFinished() {
        return false;
    }
}
