package com.barnum.lcd;

import javax.inject.Inject;

import com.barnum.lcd.components.DaggerProductionLCDComponent;
import com.barnum.lcd.serial.SerialPort;

import dagger.Module;

@Module
public class LCD {

	private static final int PARITY = 0;
	private static final int STOP_BITS = 1;
	private static final int DATA_BITS = 8;
	private static final int BAUD_RATE = 19200;

	// "/dev/tty.usbserial-CF005245"
	@Inject
	SerialPort sPort;

	@Inject
	public LCD() {

	}

	/**
	 * Initializes the port with default options and opens it for serial
	 * communication.
	 * 
	 * @param portName
	 * @throws LCDException
	 */
	public void init(String portName) throws LCDException {
		sPort.init(portName);
		sPort.openPort();
		sPort.setParams(BAUD_RATE, DATA_BITS, STOP_BITS, PARITY);
	}

	public void cleanUp() {
		sPort.closePort();
	}

	public void sendLCDCommand(LCDControlCode command, byte args[])
			throws LCDException {

		byte buffer[] = new byte[1];
		buffer[0] = command.byteCode();
		byte[] commandBuffer = null;
		if (args == null || args.length == 0) {
			commandBuffer = buffer;
		} else {
			commandBuffer = new byte[args.length + buffer.length];
			System.arraycopy(buffer, 0, commandBuffer, 0, args.length);
			System.arraycopy(args, 0, commandBuffer, args.length, buffer.length);
		}

		try {
			sPort.writeBytes(commandBuffer);
		} catch (Exception e) {
			throw new LCDException(e);
		}
	}

	public void turnOffScreen() throws LCDException {
		byte off[] = { (byte) 0 };
		sendLCDCommand(LCDControlCode.HIDE_DISPLAY, null);
		// try {
		// Thread.sleep(17);
		// } catch (InterruptedException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		sendLCDCommand(LCDControlCode.BACKLIGHT_CONTROL, off);

	}

	public void turnOnScreen() throws LCDException {
		byte on[] = { (byte) 100 };
		sendLCDCommand(LCDControlCode.BACKLIGHT_CONTROL, on);
		sendLCDCommand(LCDControlCode.RESTORE_DISPLAY, null);

	}

	public void writeString(final String message) {
		sPort.writeString(message);
	}

	public static void main(String[] args) {
		LCD lcd = DaggerProductionLCDComponent.create().getLcd();
		try {
			lcd.init("/dev/tty.usbserial-CF005245");
			System.out.println("Turning Off");
			lcd.turnOffScreen();
			System.out.println("Sleeping");
			Thread.sleep(5000);
			System.out.println("Turning On");
			lcd.turnOnScreen();
			lcd.writeString("Oliver Jason Barnum");

		} catch (LCDException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
