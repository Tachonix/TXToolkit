package com.tachonix;

import com.tachonix.inputs.KeyBinds;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.minecraft.client.MinecraftClient;

public class TXToolkitClient implements ClientModInitializer {

    @Override
    public void onInitializeClient(){

        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            while (KeyBinds.settingsKeyBind.wasPressed()) {
                MinecraftClient.getInstance().execute(() -> {
                    /* Replace CustomScreen()
                    MinecraftClient.getInstance().setScreen(new CustomScreen());
                     */
                });
            }
        });
    }
}
