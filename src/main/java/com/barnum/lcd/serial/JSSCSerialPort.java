package com.barnum.lcd.serial;

import jssc.SerialPort;
import jssc.SerialPortException;

public class JSSCSerialPort extends com.barnum.lcd.serial.SerialPort {

	SerialPort port;

	@Override
	public String getPortName() {
		return port.getPortName();
	}

	@Override
	public boolean isOpened() {
		return port.isOpened();
	}

	@Override
	public boolean openPort() {
		try {
			return port.openPort();
		} catch (SerialPortException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean setParams(int baudRate, int dataBits, int stopBits,
			int parity) {
		try {
			return port.setParams(baudRate, dataBits, stopBits, parity);
		} catch (SerialPortException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean writeString(String string) {
		try {
			return port.writeString(string);
		} catch (SerialPortException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean writeBytes(byte[] buffer) {
		try {
			port.writeBytes(buffer);
		} catch (SerialPortException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public void init(String portName) {
		port = new SerialPort(portName);
	}

	@Override
	public void setPortName(String name) {

	}

	@Override
	public boolean purgePort() {
		try {
			return port.purgePort(SerialPort.PURGE_TXCLEAR);
		} catch (SerialPortException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean closePort() {
		try {
			return port.closePort();
		} catch (SerialPortException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

}
