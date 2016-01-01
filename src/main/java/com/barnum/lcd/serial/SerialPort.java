package com.barnum.lcd.serial;

public abstract class SerialPort {

	public abstract String getPortName();
	
	public abstract boolean isOpened();
	
	public abstract boolean openPort();
	
	public abstract boolean setParams(int baudRate, int dataBits, int stopBits, int parity);
	
	public abstract boolean writeString(String string);
	
	public abstract boolean writeBytes(byte[] buffer);
	
}
