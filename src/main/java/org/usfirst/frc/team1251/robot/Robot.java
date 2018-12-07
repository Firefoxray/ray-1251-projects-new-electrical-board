package org.usfirst.frc.team1251.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc.team1251.robot.commands.*;
import org.usfirst.frc.team1251.robot.subsystems.*;
import org.usfirst.frc.team1251.robot.teleopInput.driverInput.HumanInput;
import org.usfirst.frc.team1251.robot.teleopInput.gamepad.GamePad;
import org.usfirst.frc.team1251.robot.teleopInput.gamepad.ModernGamePad;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

    //private PowerDistributionPanel pdp = new PowerDistributionPanel();
    private HumanInput humanInput;


    //Subsystem Init
    private Gearbox gearbox;
    private SmallMotor smallMotor;
    private MoveGearbox moveGearboxCmd;
    private MoveSmallMotor moveSmallMotorCmd;

    //Command Init
    private MoveSmallMotor moveSmallMotor;
    private MovePiston movePiston;
    private MoveGearbox moveGearbox;
    private ShiftGearbox shiftGearbox;



    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {

        // Set up driver input
        GamePad gamePad = new ModernGamePad(new Joystick(0));
        GamePad dummyGamePad = new ModernGamePad(new Joystick(1));

        HumanInput humanInput = new HumanInput(gamePad, dummyGamePad);

        SmartDashboard.putBoolean("Reset Encoders", false);

        // Create virtual sensors (used by mechanisms, subsystems and commands)

        // Create subsystems (used by commands)
        // Use `DeferredCmdSupplier` to handle the chicken/egg problem with default commands
        DeferredCmdSupplier<Command> gearboxDefaultCmdSupplier = new DeferredCmdSupplier<>();
        Gearbox gearbox = new Gearbox(gearboxDefaultCmdSupplier);

        DeferredCmdSupplier<Command> smallMotorDefaultCmdSupplier = new DeferredCmdSupplier<>();
        SmallMotor smallmotor = new SmallMotor(smallMotorDefaultCmdSupplier);

        GearboxShifter gearboxShifter = new GearboxShifter(new DeferredCmdSupplier<>());
        Piston piston = new Piston(new DeferredCmdSupplier<>());

        // Create commands
        MoveGearbox moveGearbox = new MoveGearbox(humanInput, gearbox);
        MoveSmallMotor moveSmallMotor = new MoveSmallMotor(humanInput, smallmotor);
        ShiftGearbox shiftGearboxHigh= new ShiftGearbox(gearboxShifter, GearboxShifter.Gear.HIGH);
        ShiftGearbox shiftGearboxLow = new ShiftGearbox(gearboxShifter, GearboxShifter.Gear.LOW);
        MovePiston movePistonHigh = new MovePiston(piston, Piston.Gear.HIGH );
        MovePiston movePistonLow = new MovePiston(piston, Piston.Gear.LOW );

        // Assign default commands
        gearboxDefaultCmdSupplier.set(moveGearbox);
        smallMotorDefaultCmdSupplier.set(moveSmallMotor);


        // assign driver-initiated command triggers.
        humanInput.attachCommandTriggers(shiftGearboxHigh, shiftGearboxLow, movePistonHigh, movePistonLow);

        this.humanInput = humanInput;
        this.gearbox = gearbox;
        this.smallMotor = smallmotor;
        //this.moveGearbox = moveGearbox;
        //this.moveSmallMotor = moveSmallMotor;
        this.shiftGearbox=shiftGearboxHigh;
        this.shiftGearbox=shiftGearboxLow;
        this.movePiston = movePistonHigh;
        this.movePiston = movePistonLow;
        this.moveGearboxCmd = moveGearbox;
        this.moveSmallMotorCmd = moveSmallMotor;
        //this.moveSmallMotorCmd = moveSmallMotor;

    }

    /**
     * This function is called once each time the robot enters Disabled mode.
     * You can use it to reset any subsystem information you want to clear when
     * the robot is disabled.
     */
    public void disabledInit() {

    }

    public void disabledPeriodic() {
        Scheduler.getInstance().run();
    }

    /**
     * This autonomous (along with the chooser code above) shows how to select between different autonomous modes
     * using the dashboard. The sendable chooser code works with the Java SmartDashboard. If you prefer the LabVIEW
     * Dashboard, remove all of the chooser code and uncomment the getString code to get the auto name from the text box
     * below the Gyro
     * <p>1
     * You can add additional auto modes by adding additional commands to the chooser code above (like the commented example)
     * or additional comparisons to the switch structure below with additional strings & commands.
     */
    /**public void autonomousInit() {
        System.out.println("Auto Init");
        MotorFactory.setBrakeMode(false);
    }
     **/

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }

    public void teleopInit() {
        // This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to
        // continue until interrupted by another command, remove
        // this line or comment it out.
        this.gearbox.setDefaultCommand(this.moveGearboxCmd);
        this.smallMotor.setDefaultCommand(this.moveSmallMotorCmd);
        //MotorFactory.setBrakeMode(false);
    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
    }

    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
        LiveWindow.run();
    }

}