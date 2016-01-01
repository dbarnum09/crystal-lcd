package com.barnum.lcd;

import javax.inject.Inject;

import com.barnum.lcd.serial.SerialPort;

public class LCD {

	private static final int PARITY = 0;
	private static final int STOP_BITS = 1;
	private static final int DATA_BITS = 8;
	private static final int BAUD_RATE = 19200;

	// "/dev/tty.usbserial-CF005245"
	@Inject
	SerialPort sPort;

	/**
	 * Initializes the port with default options and opens it for serial
	 * communication.
	 * 
	 * @param portName
	 * @throws LCDException
	 */
	public void init(String portName) throws LCDException {
		sPort.openPort();
		sPort.setParams(BAUD_RATE, DATA_BITS, STOP_BITS, PARITY);
	}

	public void sendLCDCommand(byte command, byte args[]) throws LCDException {
		byte buffer[] = (args == null) ? new byte[1]
				: new byte[1 + args.length];
		buffer[0] = command;

		try {
			sPort.writeBytes(buffer);
		} catch (Exception e) {
			throw new LCDException(e);
		}
	}

	public void clearScreen() {

	}

	public static void main(String[] args) {
		LCD lcd = new LCD();
		try {
			lcd.init("/dev/tty.usbserial-CF005245");
			byte b = 0x0E;
			byte args1[] = { 0x2 };
			lcd.sendLCDCommand((byte) 0x2, null);
			lcd.sendLCDCommand((byte) 0x3, null);
		} catch (LCDException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
