package com.spinbot.mod.features;

public class SpinbotFeature {
	public static boolean enabled = false;
	private static float spinSpeed = 5.0f; // degrees per tick
	private static float yaw = 0;

	public static void init() {
		// Initialize spinbot feature
	}

	public static void toggle() {
		enabled = !enabled;
	}

	public static boolean isEnabled() {
		return enabled;
	}

	public static void spin() {
		if (enabled) {
			yaw += spinSpeed;
			if (yaw >= 360) {
				yaw -= 360;
			}
		}
	}

	public static float getYaw() {
		return yaw;
	}

	public static void setSpinSpeed(float speed) {
		spinSpeed = speed;
	}

	public static float getSpinSpeed() {
		return spinSpeed;
	}

	public static void reset() {
		yaw = 0;
		enabled = false;
	}
}
