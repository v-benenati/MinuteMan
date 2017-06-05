package org.usfirst.frc.team4135.robot;

import org.usfirst.frc.team4135.robot.subsystems.S_Arduino;
import org.usfirst.frc.team4135.robot.subsystems.driveTrain.S_DTLeft;
import org.usfirst.frc.team4135.robot.subsystems.driveTrain.S_DTRight;
import org.usfirst.frc.team4135.robot.subsystems.driveTrain.S_DTWhole;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PowerDistributionPanel;
import robotMap.CoprocessorMap;
import robotMap.inputs.EncoderMap;
import robotMap.outputs.SolenoidMap;

/**
 * Instantiation of subsystems and system hardware
 *
 * @author Vincent Benenati
 */

public class HardwareAdaptor {
	
	private static HardwareAdaptor adaptor;
	
	public PowerDistributionPanel pdp;
	public Compressor comp;
	
	public DoubleSolenoid shifter;
	
	public AHRS navx;
	
	public Encoder dtLeftEncoder;
	public Encoder dtRightEncoder;
	
	
	public S_DTLeft dtLeft;
	public S_DTRight dtRight;
	public S_DTWhole dtWhole;
	
	public S_Arduino arduino;
	
	private HardwareAdaptor(){
		pdp = new PowerDistributionPanel();
		comp = new Compressor();
		shifter = new DoubleSolenoid(SolenoidMap.SHIFTER_FORWARD, SolenoidMap.SHIFTER_REVERSE);
		
		navx = new AHRS(CoprocessorMap.NAVX_PORT);
		
		dtLeftEncoder = new Encoder(EncoderMap.DT_LEFT_A, EncoderMap.DT_LEFT_B, EncoderMap.DT_LEFT_INVERTED);
		S_DTLeft.linkEncoder(dtLeftEncoder);
		dtRightEncoder = new Encoder(EncoderMap.DT_RIGHT_A, EncoderMap.DT_RIGHT_B, EncoderMap.DT_RIGHT_INVERTED);
		S_DTRight.linkEncoder(dtRightEncoder);
		
		dtLeft = S_DTLeft.getInstance();
		dtRight = S_DTRight.getInstance();
		S_DTWhole.linkDTSides(dtLeft, dtRight);
		dtWhole = S_DTWhole.getInstance();
		
		arduino = S_Arduino.getInstance();
	}
	
	public static HardwareAdaptor getInstance(){
		if(adaptor == null){
			adaptor = new HardwareAdaptor();
		}
		return adaptor;
	}

}
