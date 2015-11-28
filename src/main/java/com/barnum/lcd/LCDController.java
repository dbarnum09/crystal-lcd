package com.barnum.lcd;

import jssc.SerialPort;
import jssc.SerialPortException;
public class LCDController {
	
	private static final int PARITY = 0;
	private static final int STOP_BITS = 1;
	private static final int DATA_BITS = 8;
	private static final int BAUD_RATE = 19200;
	
	//"/dev/tty.usbserial-CF005245"
	SerialPort sPort;
	
	/**
	 * Initializes the port with default options and opens it for serial communication.
	 * @param portName
	 * @throws LCDException
	 */
	public void init(String portName) throws LCDException {
		sPort = new SerialPort(portName);
		try {
			sPort.openPort();
			sPort.setParams(BAUD_RATE, DATA_BITS,STOP_BITS,PARITY);
		} catch (SerialPortException e) {
			throw new LCDException(e);
		}
	}
	
	public void sendLCDCommand(byte command,byte args[]) throws LCDException {
		byte buffer[] = (args == null) ? new byte[1] : new byte[1 + args.length]; 
		buffer[0]= command;
	
		try {
			sPort.writeBytes(buffer);
		} catch (SerialPortException e) {
			throw new LCDException(e);
		}
	}
	
	public void clearScreen() {
		
	}
	
	public static void main(String[] args) {
		LCDController controller = new LCDController();
		try {
			controller.init("/dev/tty.usbserial-CF005245");
			byte b = 0x0E;
			byte args1[] = {0x2};
			controller.sendLCDCommand((byte) 0x2,null);
			controller.sendLCDCommand((byte) 0x3,null);
		} catch (LCDException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
