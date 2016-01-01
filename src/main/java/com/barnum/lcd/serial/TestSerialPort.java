package com.barnum.lcd.serial;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestSerialPort extends SerialPort {

	private static final Logger logger = LoggerFactory
			.getLogger(TestSerialPort.class);
	private static final String TEST_PORT = "testPort";
	private static boolean opened = false;

	@Override
	public String getPortName() {
		return TEST_PORT;
	}

	@Override
	public boolean isOpened() {
		return opened;
	}

	@Override
	public boolean openPort() {
		opened = true;
		return opened;
	}

	@Override
	public boolean setParams(int baudRate, int dataBits, int stopBits,
			int parity) {
		logger.info("baud rate: " + baudRate);
		logger.info("data bits: " + dataBits);
		logger.info("stop bits: " + stopBits);
		logger.info("parity: " + parity);
		return true;
	}

	@Override
	public boolean writeString(String string) {
		logger.info("writeString: " + string);
		return true;
	}

	@Override
	public boolean writeBytes(byte[] buffer) {
		logger.info("writeBytes:" + Arrays.toString(buffer));
		return false;
	}
}
