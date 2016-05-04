package com.barnum.lcd;

public enum LCDControlCode {

	/**
	 * Moves cursor to the top left character position. No data is changed.
	 * Identical to Control+Q,0,0.
	 */
	CURSOR_HOME((byte) 1),
	/**
	 * Display is blanked, no data is changed.
	 */
	HIDE_DISPLAY((byte) 2),
	/**
	 * Clears the display and returns cursor to Home position (upper left). All
	 * data is erased.
	 */
	RESTORE_DISPLAY((byte) 3),
	/**
	 * Restores blanked display; nothing else is changed.
	 */
	BACKLIGHT_CONTROL((byte) 14);

	private final byte controlCode;

	LCDControlCode(byte code) {
		this.controlCode = code;
	}

	byte byteCode() {
		return controlCode;
	}
}
