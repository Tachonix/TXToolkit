package com.tachonix.hud;

import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.gui.DrawContext;

public class DayHUD implements HudRenderCallback {
    @Override
    public void onHudRender(DrawContext drawContext, float tickDelta) {
        MinecraftClient client = MinecraftClient.getInstance();
        int x = 0;
        int y = 0;
        int color = 0xffffff; // White
        String text = "";
        if (client != null) {
            int currentDay = (int)(client.world.getTimeOfDay() / 24000L);
            text = "Days Survived: " + currentDay;
            int width = client.getWindow().getScaledWidth();
            int height = client.getWindow().getScaledHeight();

            TextRenderer renderer = client.textRenderer;

            // Calculate the width of the text
            int textWidth = renderer.getWidth(text);

            // Calculate the x-coordinate to center the text
            x = (width - textWidth) / 2;
            y = height;
        }

        TextRenderer renderer = client.textRenderer;
        drawContext.drawText(renderer, text, x, y-50, color, true);
    }
}
