package com.barnum.lcd.modules;

import com.barnum.lcd.components.DaggerTestLCDComponent;
import com.barnum.lcd.components.TestLCDComponent;
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

	public static void main(String[] args) {
		TestLCDComponent testComponent = DaggerTestLCDComponent.builder()
				.build();
		SerialPort port = testComponent.serialPort();
		System.err.println(port.getPortName());
	}
}
