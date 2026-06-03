package com.spinbot.mod;

import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SpinbotMod implements ModInitializer {
	public static final String MOD_ID = "spinbot";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		LOGGER.info("Spinbot Mod initialized!");
	}
}
