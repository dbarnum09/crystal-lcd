package com.barnum.lcd.serial;

import jssc.SerialPort;

public class JSSCSerialPort extends com.barnum.lcd.serial.SerialPort {
	SerialPort port;

	@Override
	public String getPortName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isOpened() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean openPort() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean setParams(int baudRate, int dataBits, int stopBits,
			int parity) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean writeString(String string) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean writeBytes(byte[] buffer) {
		// TODO Auto-generated method stub
		return false;
	}

}
