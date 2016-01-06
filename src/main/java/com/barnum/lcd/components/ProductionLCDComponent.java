package com.barnum.lcd.components;

import com.barnum.lcd.LCD;
import com.barnum.lcd.modules.ProductionLCDModule;

import dagger.Component;

@Component(modules = ProductionLCDModule.class)
public interface ProductionLCDComponent {
	LCD getLcd();
}
