package com.tachonix;

import com.tachonix.commands.DayCommand;
import com.tachonix.gui.CustomScreen;
import com.tachonix.hud.DayHUD;
import com.tachonix.inputs.KeyBinds;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TXToolkit implements ModInitializer {
	public static final String MOD_ID = "txtoolkit";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {

		KeyBinds.RegisterKeyBinds();
		registerCommands();
		HudRenderCallback.EVENT.register(new DayHUD());

		LOGGER.info("Hello Fabric world!");
	}

	private static void registerCommands(){
		CommandRegistrationCallback.EVENT.register(DayCommand::registerDayCMD);
		CommandRegistrationCallback.EVENT.register(DayCommand::registerTestCMD);
	}


}