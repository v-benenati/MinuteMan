package org.usfirst.frc.team4135.robot.triggers;

import edu.wpi.first.wpilibj.buttons.Trigger;

/**
 *
 */
public class MultiTrigger extends Trigger {
	
	private Trigger[] triggers;
	
	public MultiTrigger(Trigger[] triggers){
		this.triggers = triggers;
	}

    public boolean get() {
        for(int triggerNum = 0; triggerNum < triggers.length; triggerNum++){
        	if(!triggers[triggerNum].get()){
        		return false;
        	}
        }
        return true;
    }
}
