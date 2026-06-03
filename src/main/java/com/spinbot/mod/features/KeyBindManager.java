package com.spinbot.mod.features;

import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import org.lwjgl.glfw.GLFW;
import com.spinbot.mod.gui.SpinbotMenu;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

@Environment(EnvType.CLIENT)
public class KeyBindManager {
	public static KeyBinding toggleSpinbotKey;
	public static KeyBinding openMenuKey;

	public static void init() {
		toggleSpinbotKey = KeyBindingHelper.registerKeyBinding(new KeyBinding(
			"key.spinbot.toggle_spinbot",
			InputUtil.Type.KEYSYM,
			GLFW.GLFW_KEY_R,
			"category.spinbot"
		));

		openMenuKey = KeyBindingHelper.registerKeyBinding(new KeyBinding(
			"key.spinbot.open_menu",
			InputUtil.Type.KEYSYM,
			GLFW.GLFW_KEY_M,
			"category.spinbot"
		));

		ClientTickEvents.END_CLIENT_TICK.register(client -> {
			while (toggleSpinbotKey.wasPressed()) {
				SpinbotFeature.toggle();
			}
			while (openMenuKey.wasPressed()) {
				if (client.currentScreen == null || !(client.currentScreen instanceof SpinbotMenu)) {
					client.setScreen(new SpinbotMenu(null));
				}
			}
		});
	}
}
