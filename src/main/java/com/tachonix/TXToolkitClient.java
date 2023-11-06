package com.tachonix;

import com.tachonix.gui.SettingsGUI;
import com.tachonix.inputs.KeyBinds;
import me.shedaniel.clothconfig2.api.ConfigBuilder;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.text.Text;

public class TXToolkitClient implements ClientModInitializer {

    @Override
    public void onInitializeClient(){

        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            while (KeyBinds.settingsKeyBind.wasPressed()) {
                MinecraftClient.getInstance().execute(SettingsGUI::BuildConfig);
            }
        });
    }
}
