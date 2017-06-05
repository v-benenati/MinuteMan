package org.usfirst.frc.team4135.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import robotMap.inputs.JoystickMap;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	
	private static OI oi;
	
	private static final int JOYSTICK_NUM = 3;
	private static final int BUTTON_NUM = 12;
	
	private static Joystick driverLeft = new Joystick(JoystickMap.DRIVER_LEFT);
	private static Joystick driverRight = new Joystick(JoystickMap.DRIVER_RIGHT);
	private static Joystick gunner = new Joystick(JoystickMap.GUNNER);

	private static Joystick[] joysticks = {driverLeft, driverRight, gunner};
	private static JoystickButton[][]  buttons = new JoystickButton[JOYSTICK_NUM][BUTTON_NUM];


	private OI(){
		createButtons();
		
	}
	
	public static OI getInstance(){
		if(oi == null){
			oi = new OI();
		}
		return oi;
	}


	/**
	 * Populates the array "buttons" with buttons from 1 to 12 of each joystick.
	 * @author Vincent Benenati
	 * @author Robert Smith
	 */
	private void createButtons(){
		for(int joystickNum = 0; joystickNum < JOYSTICK_NUM; joystickNum++){
			for(int buttonNum = 0; buttonNum < BUTTON_NUM; buttonNum++){
				buttons[joystickNum][buttonNum] = new JoystickButton(joysticks[joystickNum], buttonNum + 1);
			}
		}
	}

	/**
	 * Enables the user to input joystick port and dersired
	 * button number, and receive a usable button.
	 *
	 * @author Vincent Benenati
	 * @author Robert Smith
	 * @param joystickNum Joystick number from 0 to 2
	 * @param buttonNum  Button number from 1 to 12
	 * @return JoystickButton
	 */
	public JoystickButton getJoystickButton(final int joystickNum, final int buttonNum){
		return buttons[joystickNum][buttonNum - 1];
	}

	/**
	 * Disregards unintentional input calibrated by the deadzone
	 *
	 * @author Vincent Benenati
	 * @param joystick the joystick to be monitored
	 * @param deadzone the size of deadzone from 0 to 1
	 * @return true if joystick is within deadzone
	 * <p>
	 * false if joystick is outside of deadzone
	 *
	 */
	public static boolean isDeadZone(Joystick joystick, double deadzone){
		if(Math.pow(joystick.getX(), 2) + Math.pow(joystick.getY(), 2) < Math.pow(deadzone, 2)){
			return true;
		}
			return false;
	}

	public Joystick getJoystick(final int joystickNum){
		return joysticks[joystickNum];
	}
















}
