package com.spinbot.mod;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.Environment;
import net.fabricmc.api.EnvType;
import com.spinbot.mod.features.SpinbotFeature;
import com.spinbot.mod.features.KeyBindManager;
import com.spinbot.mod.features.TickHandler;
import com.spinbot.mod.gui.RenderManager;

@Environment(EnvType.CLIENT)
public class SpinbotModClient implements ClientModInitializer {

	@Override
	public void onInitializeClient() {
		SpinbotMod.LOGGER.info("Spinbot Mod Client initialized!");
		
		// Initialize features
		SpinbotFeature.init();
		KeyBindManager.init();
		TickHandler.init();
		RenderManager.init();
	}
}
