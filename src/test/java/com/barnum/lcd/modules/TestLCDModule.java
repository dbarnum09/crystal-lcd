package com.barnum.lcd.modules;

import com.barnum.lcd.serial.SerialPort;
import com.barnum.lcd.serial.TestSerialPort;

import dagger.Module;
import dagger.Provides;

@Module
public class TestLCDModule {

	@Provides
	SerialPort provideSerialPort() {
		return new TestSerialPort();
	}
}
