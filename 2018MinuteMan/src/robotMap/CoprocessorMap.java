package robotMap;

import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.SPI;

public class CoprocessorMap {

	public static final SPI.Port NAVX_PORT = SPI.Port.kMXP;
	
	public static final I2C.Port ARDUINO_PORT = I2C.Port.kOnboard;
	public static final int ARDUINO_ADDRESS = 4;
}
