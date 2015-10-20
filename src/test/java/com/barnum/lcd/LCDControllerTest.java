/**
 * 
 */
package com.barnum.lcd;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author dave.barnum
 *
 */
public class LCDControllerTest {

	private static final String TEST_SERIAL_PORT = "/dev/tty.usbserial-CF005245";
	private LCDController lcdController;
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		lcdController = new LCDController();
	}


	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testInit() {
		try {
			lcdController.init(TEST_SERIAL_PORT);
		} catch (LCDException e) {
			fail(e.getMessage());
		}
	}
	
	@Test(expected=LCDException.class)
	public void testInitFailure() throws LCDException {
		lcdController.init("/dev/nothere");	
		
	}

}
