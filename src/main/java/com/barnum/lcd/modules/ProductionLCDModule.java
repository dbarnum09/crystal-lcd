package com.barnum.lcd.modules;

import com.barnum.lcd.serial.JSSCSerialPort;
import com.barnum.lcd.serial.SerialPort;

import dagger.Module;
import dagger.Provides;

@Module
public class ProductionLCDModule {

	@Provides
	SerialPort provideSerialPort() {
		return new JSSCSerialPort();
	}
}
