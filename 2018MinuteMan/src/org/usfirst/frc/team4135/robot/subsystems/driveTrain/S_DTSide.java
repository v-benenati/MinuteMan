package org.usfirst.frc.team4135.robot.subsystems.driveTrain;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class S_DTSide extends Subsystem implements SpeedController {

	private static final int MOTOR_NUM = 3;
	private CANTalon[] motorControllers = new CANTalon[MOTOR_NUM];
    private Encoder encoder;
    private boolean isSideInverted = false;
    private double  currentSpeed = 0;
    private double distToTurn = 0;

    public S_DTSide(int[] motorIDs, boolean[] motorInversions, Encoder encoder) {
        for(int motorNum = 0; motorNum < MOTOR_NUM; motorNum++){
        	this.motorControllers[motorNum] = new CANTalon(motorIDs[motorNum]);
        	this.motorControllers[motorNum].setInverted(motorInversions[motorNum]);
        }
        this.encoder = encoder;
    }
    
    @Override
	protected void initDefaultCommand() {

		// TODO Auto-generated method stub

	}

    /**
     * Reset encoder ticks
     */
    public void resetEncoder() {
        this.encoder.reset();
    }

    /**
     * Set motor to speed
     *
     * @param speed Speed
     */
    public void set(double speed) {
    	for(int motorNum = 0; motorNum < MOTOR_NUM; motorNum++){
        	motorControllers[motorNum].set(speed);
        }
    	currentSpeed = speed;
    }

    /**
     * Halt motor
     */
    public void halt() {
    	set(0);
    }

    public double getDistToTurn() {
        return distToTurn;
    }

    public void setDistToTurn(double distToTurn) {
        this.distToTurn = distToTurn;
    }
    
    public void disable(){
    	for(int motorNum = 0; motorNum < MOTOR_NUM; motorNum++){
        	motorControllers[motorNum].disable();
        }
    }
    
    public double get(){
    	return currentSpeed;
    }
    
    public boolean getInverted(){
    	return isSideInverted;
    }    
   
    public void setInverted(boolean isInverted){
    	if(isInverted != isSideInverted){
    		for(int motorNum = 0; motorNum < MOTOR_NUM; motorNum++){
    			motorControllers[motorNum].setInverted(!motorControllers[motorNum].getInverted());
        	}
    		isSideInverted = isInverted;
    	}
    }
    
    public void stopMotor(){
    	halt();
    }

	@Override
	public void pidWrite(double output) {
		set(output);
	}
	
	public void setToBrake(boolean statement){
		for(int motorNum = 0; motorNum < MOTOR_NUM; motorNum++){
			motorControllers[motorNum].enableBrakeMode(statement);
	    }
	}

	
}

