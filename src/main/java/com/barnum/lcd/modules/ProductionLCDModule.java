package com.barnum.lcd.modules;

import com.barnum.lcd.LCD;
import com.barnum.lcd.LCDException;
import com.barnum.lcd.components.DaggerProductionLCDComponent;
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

	@Provides
	LCD provideLCD() {
		return new LCD();
	}

	public static void main(String[] args) {
		LCD lcd = DaggerProductionLCDComponent.create().getLcd();
		try {
			lcd.init("/dev/tty.usbserial-CF005245");
			byte b = 0x0E;
			byte args1[] = { 0x2 };
			lcd.sendLCDCommand((byte) 0x2, null);
			lcd.sendLCDCommand((byte) 0x3, null);
		} catch (LCDException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
