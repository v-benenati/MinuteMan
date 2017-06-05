package org.usfirst.frc.team4135.robot.subsystems;

import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.command.Subsystem;
import robotMap.CoprocessorMap;

/**
 *
 */
public class S_Arduino extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	private static S_Arduino arduino;
	private static I2C wire;
	private static byte[] verificationKey;
	
	private S_Arduino(){
		wire = new I2C(CoprocessorMap.ARDUINO_PORT, CoprocessorMap.ARDUINO_ADDRESS);
    	verificationKey = "IronPatriots4135".getBytes();
	}
	
	public static S_Arduino getInstance(){
		if(arduino == null){
			arduino = new S_Arduino();
		}
		return arduino;
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void write(String message){
    	byte[] writeData = message.getBytes();
    	wire.transaction(writeData, writeData.length, null, 0);
    }
    
    public boolean verifyConnection(){
    	return wire.verifySensor(CoprocessorMap.ARDUINO_ADDRESS, verificationKey.length, verificationKey);
    }
    
    /*char[] charArray = message.toCharArray();
    	byte[] writeData = new byte[charArray.length];
    	for(int byteIndex = 0; byteIndex < charArray.length; byteIndex++){
    		writeData[byteIndex] = (byte) charArray[byteIndex];
    	}
    	wire.transaction(writeData, writeData.length, null, 0);
     * 
     */
}

