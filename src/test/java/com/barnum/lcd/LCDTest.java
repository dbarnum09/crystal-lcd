/**
 * 
 */
package com.barnum.lcd;

import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.barnum.lcd.components.DaggerProductionLCDComponent;

/**
 * @author dave.barnum
 *
 */
public class LCDTest {

	private static final String TEST_SERIAL_PORT = "/dev/tty.usbserial-CF005245";
	private LCD lcd;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		lcd = DaggerProductionLCDComponent.create().getLcd();
		// lcd = DaggerTestLCDComponent.create().getLcd();
		lcd.init(TEST_SERIAL_PORT);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		lcd.cleanUp();
	}

	@Test
	public void testTurnOffSCreen() {
		try {
			lcd.turnOffScreen();
		} catch (LCDException e) {
			// TODO Auto-generated catch block
			fail(e.getMessage());
		}
	}

	@Test
	public void testTurnOnScreen() {
		try {
			lcd.turnOnScreen();
		} catch (LCDException e) {
			// TODO Auto-generated catch block
			fail(e.getMessage());
		}
	}
}
