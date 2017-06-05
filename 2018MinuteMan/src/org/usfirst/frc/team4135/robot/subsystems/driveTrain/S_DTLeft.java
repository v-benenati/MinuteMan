package org.usfirst.frc.team4135.robot.subsystems.driveTrain;

import org.usfirst.frc.team4135.robot.commands.DriveLinearLeft;

import edu.wpi.first.wpilibj.Encoder;
import robotMap.outputs.MotorControllerMap;

/**
 * Subsystem controlling left drivetrain side
 *
 * @author Vincent Benenati
 */
public class S_DTLeft extends S_DTSide {
	
	private static S_DTLeft dtLeft;
	
	private static int[] motorIDs = { MotorControllerMap.DT_LEFT_FRONT,
			                   		  MotorControllerMap.DT_LEFT_MIDDLE,
			                          MotorControllerMap.DT_LEFT_BACK};
	private static boolean[] motorInversions = { MotorControllerMap.DT_LEFT_FRONT_INVERTED,
			                                     MotorControllerMap.DT_LEFT_MIDDLE_INVERTED,
			                                     MotorControllerMap.DT_LEFT_BACK_INVERTED};
	private static Encoder encoder;
    
	private S_DTLeft(Encoder encoder){
        super(motorIDs, motorInversions, encoder);
    }
	
	public static S_DTLeft getInstance(){
		if(dtLeft == null){
			dtLeft = new S_DTLeft(encoder);
		}
		return dtLeft;
	}

	public static void linkEncoder(Encoder encoder){
		S_DTLeft.encoder = encoder;
	}

	
	
    @Override
    public void initDefaultCommand() {
        setDefaultCommand(new DriveLinearLeft());
    }
}
