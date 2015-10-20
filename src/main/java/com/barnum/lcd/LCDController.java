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
	
	public void init(String portName) throws LCDException {
		sPort = new SerialPort(portName);
		try {
			sPort.openPort();
			sPort.setParams(BAUD_RATE, DATA_BITS,STOP_BITS,PARITY);
		} catch (SerialPortException e) {
			// TODO Auto-generated catch block
			throw new LCDException(e);
		
		}
	}
	
	public static void main(String[] args) {
		LCDController controller = new LCDController();
		try {
			controller.init("/dev/tty.usbserial-CF005245");
		} catch (LCDException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
