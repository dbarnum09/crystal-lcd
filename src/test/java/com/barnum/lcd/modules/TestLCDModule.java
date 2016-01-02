package com.barnum.lcd.modules;

import com.barnum.lcd.LCD;
import com.barnum.lcd.LCDException;
import com.barnum.lcd.components.DaggerTestLCDComponent;
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

	@Provides
	LCD provideLCD() {
		return new LCD();
	}

	public static void main(String[] args) {
		LCD lcd = DaggerTestLCDComponent.create().getLcd();
		try {
			lcd.init("/test/port");
		} catch (LCDException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
