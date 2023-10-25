package com.tachonix.hud;

import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.gui.DrawContext;

public class DayHUD implements HudRenderCallback {
    @Override
    public void onHudRender(DrawContext drawContext, float tickDelta) {
        MinecraftClient client = MinecraftClient.getInstance();
        int x;
        int y;
        int color = 0xffffff; // White
        String text;
        TextRenderer renderer;
        if (client != null) {
            assert client.world != null;

            renderer = client.textRenderer;
            int currentDay = (int)(client.world.getTimeOfDay() / 24000L);
            text = "Days Survived: " + currentDay;
            int width = client.getWindow().getScaledWidth(); // Get the width and height of the client
            int height = client.getWindow().getScaledHeight();

            // Calculate the width of the text
            int textWidth = renderer.getWidth(text);

            // Calculate the x-coordinate to center the text
            x = (width - textWidth) / 2; // Center aligns the text
            y = height;
            drawContext.drawText(renderer, text, x, y-50, color, true);
        }
    }
}
