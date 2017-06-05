package org.usfirst.frc.team4135.robot.triggers;


import org.usfirst.frc.team4135.robot.SubsystemStates.MatchTimeManagerMode;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.buttons.Trigger;

/**
 *
 */
public class MatchTimeMonitor extends Trigger {
	
	private double triggerTime;
	private boolean mode;
	
	public MatchTimeMonitor(MatchTimeManagerMode mode, double triggerTime){
		switch(mode){
			case AUTO:
				this.mode = false;
				break;
			case TELE:
				this.mode = true;
				break;
		}
		this.triggerTime = triggerTime;
	}

	public boolean get(){
    	if(mode == false){//Auto mode
    		if(DriverStation.getInstance().isAutonomous() && timeUntilEnd() <= triggerTime){
        		return true;
        	}
    	}
    	if(mode == true){//Tele mode
    		if(DriverStation.getInstance().isOperatorControl() && timeUntilEnd() <= triggerTime){
        		return true;
        	}
    	}
        return false;
    }
	
	public double timeUntilEnd(){
		return DriverStation.getInstance().getMatchTime();
	}
	
	
}
