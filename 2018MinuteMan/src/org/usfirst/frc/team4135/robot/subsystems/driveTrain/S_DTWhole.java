package org.usfirst.frc.team4135.robot.subsystems.driveTrain;

import org.usfirst.frc.team4135.robot.Robot;
import org.usfirst.frc.team4135.robot.SubsystemStates;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class S_DTWhole extends Subsystem {
	
	private static S_DTWhole dtWhole;
	private static S_DTLeft dtLeft;
	private static S_DTRight dtRight;

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	private static RobotDrive robotDrive;
	
	private S_DTWhole(S_DTLeft dtLeft, S_DTRight dtRight){
		robotDrive = new RobotDrive(dtLeft, dtRight);
	}
	
	public static S_DTWhole getInstance(){
		if(dtWhole == null){
			dtWhole = new S_DTWhole(dtLeft, dtRight);
		}
		return dtWhole;
	}
	
	public static void linkDTSides(S_DTLeft dtLeft, S_DTRight dtRight){
		S_DTWhole.dtLeft = dtLeft;
		S_DTWhole.dtRight = dtRight;
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    /**
     * Toggle current drive gear
     *
     * @param gear Gear to shift to
     */
    public static void shift(SubsystemStates.DriveGear gear) {
        switch (gear) {
            case LOW:
                Robot.adaptor.shifter.set(DoubleSolenoid.Value.kForward);
                SubsystemStates.driveGear = SubsystemStates.DriveGear.LOW;
                break;
            case HIGH:
                Robot.adaptor.shifter.set(DoubleSolenoid.Value.kReverse);
                SubsystemStates.driveGear = SubsystemStates.DriveGear.HIGH;
                break;
        }
    }
    
    public void arcadeDrive(Joystick joystick, boolean squaredInputs){
    	robotDrive.arcadeDrive(joystick, squaredInputs);
    }
    
    public void safeArcadeDrive(Joystick joystick, JoystickButton safetyButton, boolean squaredInputs){
    	if(safetyButton.get()){
    		robotDrive.arcadeDrive(joystick, squaredInputs);
    	}
    	else{
    		robotDrive.stopMotor();
    	}
    }
    
    public void tankDrive(Joystick leftJoystick, Joystick rightJoystick, boolean squaredInputs){
    	robotDrive.tankDrive(leftJoystick, rightJoystick, squaredInputs);
    }
    
    public void safeTankDrive(Joystick leftJoystick, Joystick rightJoystick, JoystickButton[] safetyButtons, boolean squaredInputs){
    	if(getAll(safetyButtons)){
    		robotDrive.tankDrive(leftJoystick, rightJoystick, squaredInputs);
    	}
    	else{
    		robotDrive.stopMotor();
    	}
    }
    
    private boolean getAll(JoystickButton[] buttons){
    	for(int buttonNum = 0; buttonNum < buttons.length; buttonNum++){
    		if(!buttons[buttonNum].get()){
    			return false;
    		}
    	}
    	return true;
    }
  
}

