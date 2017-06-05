package org.usfirst.frc.team4135.robot;

/**
 * Defines all possible states a given subsystem can be in
 *
 * @author Vincent Benenati
 */
public class SubsystemStates {
	
	/*
	 * TODO create default state for all subsystem enums
	 */
	public static DriveGear driveGear;
	public static MatchTimeManagerMode matchTimeManagerMode;
	
	public enum DriveGear{
		LOW, HIGH
	}
	
	public enum MatchTimeManagerMode{
		AUTO, TELE
	}
}