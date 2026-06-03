package com.spinbot.mod.gui;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.gui.widget.SliderWidget;
import net.minecraft.text.Text;
import net.minecraft.util.math.MathHelper;
import com.spinbot.mod.features.SpinbotFeature;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

@Environment(EnvType.CLIENT)
public class SpinbotMenu extends Screen {
	private Screen parent;
	private ButtonWidget toggleButton;
	private SliderWidget speedSlider;

	public SpinbotMenu(Screen parent) {
		super(Text.literal("Spinbot Menu"));
		this.parent = parent;
	}

	@Override
	protected void init() {
		super.init();

		int centerX = this.width / 2;
		int centerY = this.height / 2;
		int buttonWidth = 150;
		int buttonHeight = 20;
		int spacing = 30;

		// Toggle Button
		toggleButton = this.addDrawableChild(ButtonWidget.builder(
			Text.literal(SpinbotFeature.isEnabled() ? "Disable Spinbot" : "Enable Spinbot"),
			button -> {
				SpinbotFeature.toggle();
				button.setMessage(Text.literal(SpinbotFeature.isEnabled() ? "Disable Spinbot" : "Enable Spinbot"));
			}
		).dimensions(centerX - buttonWidth / 2, centerY - spacing, buttonWidth, buttonHeight).build());

		// Speed Slider
		speedSlider = this.addDrawableChild(new SpeedSliderWidget(
			centerX - buttonWidth / 2,
			centerY + spacing,
			buttonWidth,
			buttonHeight,
			Text.literal("Speed: "),
			SpinbotFeature.getSpinSpeed() / 20.0f
		));

		// Close Button
		this.addDrawableChild(ButtonWidget.builder(
			Text.literal("Close"),
			button -> this.close()
		).dimensions(centerX - buttonWidth / 2, centerY + spacing * 2, buttonWidth, buttonHeight).build());

		// Back Button (if there's a parent screen)
		if (parent != null) {
			this.addDrawableChild(ButtonWidget.builder(
				Text.literal("Back"),
				button -> this.client.setScreen(parent)
			).dimensions(centerX - buttonWidth / 2, centerY + spacing * 3, buttonWidth, buttonHeight).build());
		}
	}

	@Override
	public void close() {
		this.client.setScreen(parent);
	}

	@Override
	public boolean shouldCloseOnEsc() {
		return true;
	}

	// Custom Slider Widget for Speed Control
	private static class SpeedSliderWidget extends SliderWidget {
		public SpeedSliderWidget(int x, int y, int width, int height, Text text, double value) {
			super(x, y, width, height, text, MathHelper.clamp(value, 0.0, 1.0));
		}

		@Override
		protected void updateMessage() {
			double speed = this.value * 20.0;
			this.setMessage(Text.literal("Speed: " + String.format("%.1f", speed)));
		}

		@Override
		protected void applyValue() {
			SpinbotFeature.setSpinSpeed((float) (this.value * 20.0f));
		}
	}
}
