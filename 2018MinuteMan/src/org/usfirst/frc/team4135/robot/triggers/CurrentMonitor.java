package org.usfirst.frc.team4135.robot.triggers;

import org.usfirst.frc.team4135.robot.Robot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.buttons.Trigger;

/**
 *
 */
public class CurrentMonitor extends Trigger {
	
	private int monitoredChannel;
	private double stallCurrent;
	private boolean overCurrent;
	private boolean triggered;
	private double coolDownTime; // once triggered how long it is active
	private double triggerTime;  // how long it has to hit the stall current to activate
	private boolean startedCoolDown;
	private Timer timer;
	
	public CurrentMonitor(int monitoredChannel, double stallCurrent, double triggerTime, double coolDownTime){
		this.monitoredChannel = monitoredChannel;
		this.stallCurrent = stallCurrent;
		this.triggerTime = triggerTime;
		this.coolDownTime = coolDownTime;
		timer = new Timer();
	}

    public boolean get(){
    	isTriggered();
    	isCooledDown();
    	return triggered;
    }
    
    public boolean isTriggered(){
    	if(!triggered){
	    	if(!overCurrent && Robot.adaptor.pdp.getCurrent(monitoredChannel) >= stallCurrent){
	    		timer.start();
	    		overCurrent = true;
	    	}
	    	if(Robot.adaptor.pdp.getCurrent(monitoredChannel) < stallCurrent){
	    		timer.reset();
	    		overCurrent = false;
	    	}
	    	if(timer.get() >= triggerTime){
	    		triggered = true;
	    		timer.reset();
	    		return true;
	    	}
	    	else{
	    		return false;
	    	}
    	}
    	else{
    		return true;
    	}
    }
    
    public boolean isCooledDown(){
    	if(triggered){
    		if(!startedCoolDown){
    			timer.start();
    			startedCoolDown = true;
    		}
    		else if(timer.get() >= coolDownTime){
    			timer.reset();
    			startedCoolDown = false;
    			triggered = false;
    			return true;
    		}
    		return false;
    	}
    	else{
    		return false;
    	}
    }
}
