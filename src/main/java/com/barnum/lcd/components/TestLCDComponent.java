package com.barnum.lcd.components;

import com.barnum.lcd.modules.TestLCDModule;
import com.barnum.lcd.serial.SerialPort;

import dagger.Component;

@Component(modules = TestLCDModule.class)
public interface TestLCDComponent {

	SerialPort serialPort();
}
