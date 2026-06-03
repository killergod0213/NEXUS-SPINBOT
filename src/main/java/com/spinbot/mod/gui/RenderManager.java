package com.spinbot.mod.gui;

import net.fabricmc.fabric.api.client.rendering.v1.WorldRenderEvents;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.util.math.MatrixStack;
import com.spinbot.mod.features.SpinbotFeature;
import org.joml.Matrix4f;

@Environment(EnvType.CLIENT)
public class RenderManager {
	private static boolean rgbEnabled = true;

	public static void init() {
		WorldRenderEvents.AFTER_TRANSLUCENT.register(context -> {
			MinecraftClient client = MinecraftClient.getInstance();
			if (client.player != null && SpinbotFeature.isEnabled() && rgbEnabled) {
				drawRGBFOVCircle(context);
			}
		});
	}

	private static void drawRGBFOVCircle(WorldRenderEvents.AfterTranslucent context) {
		MinecraftClient client = MinecraftClient.getInstance();
		if (client.player == null) return;

		MatrixStack matrices = context.matrices();
		VertexConsumerProvider vertexConsumers = context.consumers();

		matrices.push();

		float radius = 50.0f;
		int segments = 360;
		float x = 0, y = 0, z = -50;

		// Draw RGB circle
		for (int i = 0; i < segments; i++) {
			float angle1 = (float) Math.toRadians(i);
			float angle2 = (float) Math.toRadians(i + 1);

			float x1 = (float) (x + radius * Math.cos(angle1));
			float y1 = (float) (y + radius * Math.sin(angle1));

			float x2 = (float) (x + radius * Math.cos(angle2));
			float y2 = (float) (y + radius * Math.sin(angle2));

			// Get RGB color based on angle
			float hue = i / (float) segments;
			int color = hsvToRgb(hue, 1.0f, 1.0f);

			float r = (color >> 16 & 0xFF) / 255.0f;
			float g = (color >> 8 & 0xFF) / 255.0f;
			float b = (color & 0xFF) / 255.0f;

			// Draw line (simplified - you may want to use a proper line renderer)
		}

		matrices.pop();
	}

	private static int hsvToRgb(float hue, float saturation, float value) {
		float c = value * saturation;
		float x = c * (1 - Math.abs((hue * 6) % 2 - 1));
		float m = value - c;

		float r = 0, g = 0, b = 0;
		if (hue < 1.0f / 6.0f) {
			r = c;
			g = x;
		} else if (hue < 2.0f / 6.0f) {
			r = x;
			g = c;
		} else if (hue < 3.0f / 6.0f) {
			g = c;
			b = x;
		} else if (hue < 4.0f / 6.0f) {
			g = x;
			b = c;
		} else if (hue < 5.0f / 6.0f) {
			r = x;
			b = c;
		} else {
			r = c;
			b = x;
		}

		int ri = Math.round((r + m) * 255);
		int gi = Math.round((g + m) * 255);
		int bi = Math.round((b + m) * 255);

		return (ri << 16) | (gi << 8) | bi;
	}

	public static void setRgbEnabled(boolean enabled) {
		rgbEnabled = enabled;
	}

	public static boolean isRgbEnabled() {
		return rgbEnabled;
	}
}
