package org.usfirst.frc.team4135.robot.subsystems.driveTrain;

import org.usfirst.frc.team4135.robot.commands.DriveLinearRight;

import edu.wpi.first.wpilibj.Encoder;
import robotMap.outputs.MotorControllerMap;

/**
 * Subsystem controlling right drivetrain side
 *
 * @author Vincent Benenati
 */
public class S_DTRight extends S_DTSide {
	
	private static S_DTRight dtRight;
	
	private static int[] motorIDs = { MotorControllerMap.DT_RIGHT_FRONT,
			                   		  MotorControllerMap.DT_RIGHT_MIDDLE,
			                          MotorControllerMap.DT_RIGHT_BACK};
	private static boolean[] motorInversions = { MotorControllerMap.DT_RIGHT_FRONT_INVERTED,
			                                     MotorControllerMap.DT_RIGHT_MIDDLE_INVERTED,
			                                     MotorControllerMap.DT_RIGHT_BACK_INVERTED};
    private static Encoder encoder;
	
	private S_DTRight(Encoder encoder){
        super(motorIDs, motorInversions, encoder);
    }
	
	public static S_DTRight getInstance(){
		if(dtRight == null){
			dtRight = new S_DTRight(encoder);
		}
		return dtRight;
	}
	
	public static void linkEncoder(Encoder encoder){
		S_DTRight.encoder = encoder;
	}

    @Override
    public void initDefaultCommand() {
        setDefaultCommand(new DriveLinearRight());
    }
}
