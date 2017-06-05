package org.usfirst.frc.team4135.robot.triggers;

import org.usfirst.frc.team4135.robot.Robot;

import edu.wpi.first.wpilibj.buttons.Trigger;

/**
 *
 */
public class GlobalVoltageMonitor extends Trigger {
	
	public static final double BROWNOUT_VOLTAGE = 6.8;
	private double voltageBuffer;

	public GlobalVoltageMonitor(double voltageBuffer){
		this.voltageBuffer = voltageBuffer;
	}

	public boolean get() {
        if(Robot.adaptor.pdp.getVoltage() <= BROWNOUT_VOLTAGE + voltageBuffer){
        	return true;
        }
        else{
        	return false;
        }
    }
}
