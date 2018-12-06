package org.usfirst.frc.team1251.robot.teleopInput.gamepad;


/**
 * Represents a single GamePad used to control the 2018 Robot during Tele-op.
 *
 * Examples:
 *
 *  // See if the 'A' button is pressed.
 *  OI.driverPad.A.isPressed();
 *
 *  // See if both 'A' and 'B' are pressed.
 *  OI.driverPad.A.isPressed() && OI.driverPad.B.isPressed()
 *
 *  // See if the left trigger is pressed.
 *  OI.driverPad.LT.isPressed();
 *
 *  // See if the left trigger is pressed more than 15%
 *  OI.driverPad.LT.isPressed(0.15); // 14% returns false, 15% returns false, 16% returns true
 *
 *  // See how far the left trigger is being pressed
 *  OI.driverPad.LT.getValue();
 *
 *  // See how far the left trigger is being pressed, ignoring the first 12%
 *  OI.driverPad.LT.getValue(0.12); // 11% returns 0, 12% returns 0, 13% returns 0.13
 *
 *  // Read the horizontal position of the left stick.
 *  OI.driverPad.leftStick.getHorizontal();
 *
 *  // Read the vertical position of the left stick, ignoring everything within the range of -0.10 and 0.10, inclusively.
 *  OI.driverPad.leftStick.getVertical(0.10); // -0.11 returns -0.11, -0.10 returns 0, 0.10 returns 0, 0.11 returns 0.11
 *
 */
abstract public class GamePad {
    GamePadButton a;
    GamePadButton b;
    GamePadButton x;
    GamePadButton y;
    GamePadButton rb;
    GamePadButton lb;
    GamePadButton rsClick;
    GamePadButton lsClick;
    GamePadButton start;
    GamePadButton select;
    TriggerButton lt;
    TriggerButton rt;
    Stick ls;
    Stick rs;


    public GamePadButton a() {
        return a;
    }

    
    public GamePadButton b() {
        return b;
    }

    
    public GamePadButton x() {
        return x;
    }

    
    public GamePadButton y() {
        return y;
    }

    
    public GamePadButton rb() {
        return rb;
    }

    
    public GamePadButton lb() {
        return lb;
    }

    
    public GamePadButton lsClick() {
        return lsClick;
    }

    
    public GamePadButton rsClick() {
        return rsClick;
    }

    
    public GamePadButton start() {
        return start;
    }

    
    public GamePadButton select() {
        return select;
    }

    
    public TriggerButton lt() {
        return lt;
    }

    
    public TriggerButton rt() {
        return rt;
    }

    
    public Stick ls() {
        return ls;
    }

    
    public Stick rs() {
        return rs;
    }

    abstract public void rumbleLeft(double value);
    abstract public void rumbleRight(double value);


}
