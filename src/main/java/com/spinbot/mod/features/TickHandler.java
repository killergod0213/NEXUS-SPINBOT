package com.spinbot.mod.features;

import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.MinecraftClient;

@Environment(EnvType.CLIENT)
public class TickHandler {
	public static void init() {
		ClientTickEvents.END_CLIENT_TICK.register(client -> {
			if (client.player != null && SpinbotFeature.isEnabled()) {
				SpinbotFeature.spin();
				// Apply rotation
				float yaw = SpinbotFeature.getYaw();
				client.player.setYaw(yaw);
			}
		});
	}
}
