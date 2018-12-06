package org.usfirst.frc.team1251.robot.teleopInput.gamepad;

import edu.wpi.first.wpilibj.GenericHID;

public class ModernGamePad extends GamePad {

    private final GenericHID rawDevice;

    public ModernGamePad(GenericHID rawDevice) {

        this.rawDevice = rawDevice;

        this.a = new DigitalButton(1, rawDevice);
        this.b = new DigitalButton(2, rawDevice);
        this.x = new DigitalButton(3, rawDevice);
        this.y = new DigitalButton(4, rawDevice);
        this.lb = new DigitalButton(5, rawDevice);
        this.rb = new DigitalButton(6, rawDevice);
        this.select = new DigitalButton(7, rawDevice);
        this.start = new DigitalButton(8, rawDevice);
        this.rsClick = new DigitalButton(10, rawDevice);
        this.lsClick = new DigitalButton(9, rawDevice);

        this.lt = new AnalogTriggerButton(2, rawDevice);
        this.rt = new AnalogTriggerButton(3,rawDevice);

        this.ls = new Stick(0, 1, rawDevice);
        this.rs = new Stick(4, 5, rawDevice);
    }

    @Override
    public void rumbleLeft(double value) {
        this.rawDevice.setRumble(GenericHID.RumbleType.kLeftRumble, value);
    }

    @Override
    public void rumbleRight(double value) {
        this.rawDevice.setRumble(GenericHID.RumbleType.kRightRumble, value);
    }
}
