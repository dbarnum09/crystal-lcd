package com.barnum.lcd.components;

import com.barnum.lcd.LCD;
import com.barnum.lcd.modules.TestLCDModule;

import dagger.Component;

@Component(modules = TestLCDModule.class)
public interface TestLCDComponent {
	LCD getLcd();
}
