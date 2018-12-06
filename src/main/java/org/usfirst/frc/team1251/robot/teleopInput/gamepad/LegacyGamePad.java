package org.usfirst.frc.team1251.robot.teleopInput.gamepad;

import edu.wpi.first.wpilibj.GenericHID;

public class LegacyGamePad extends GamePad {

    public LegacyGamePad(GenericHID rawDevice) {
        this.a = new DigitalButton(2, rawDevice);
        this.b = new DigitalButton(3, rawDevice);
        this.x = new DigitalButton(1, rawDevice);
        this.y = new DigitalButton(4, rawDevice);
        this.lb = new DigitalButton(5, rawDevice);
        this.rb = new DigitalButton(6, rawDevice);
        this.select = new DigitalButton(9, rawDevice);
        this.start = new DigitalButton(10, rawDevice);
        this.rsClick = new DigitalButton(12, rawDevice);
        this.lsClick = new DigitalButton(11, rawDevice);
        this.lt = new DigitalTriggerButton(7, rawDevice);
        this.rt = new DigitalTriggerButton(8, rawDevice);

        this.ls = new Stick(0, 1, rawDevice);
        this.rs = new Stick(2, 3, rawDevice);
    }

    @Override
    public void rumbleLeft(double value) {
        // No rumble support.
    }

    @Override
    public void rumbleRight(double value) {
        // No rumble support.
    }
}
