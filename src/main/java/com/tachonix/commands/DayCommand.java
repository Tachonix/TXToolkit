package com.tachonix.commands;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.context.CommandContext;
import com.tachonix.gui.SettingsGUI;
import com.tachonix.inputs.KeyBinds;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.command.CommandRegistryAccess;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.text.Text;

public class DayCommand {

    public static void registerDayCMD(CommandDispatcher<ServerCommandSource> dispatcher, CommandRegistryAccess commandRegistryAccess, CommandManager.RegistrationEnvironment registrationEnvironment) {
        dispatcher.register(CommandManager.literal("day").executes(DayCommand::runDayCMD));
    }
    public static void registerTestCMD(CommandDispatcher<ServerCommandSource> dispatcher, CommandRegistryAccess commandRegistryAccess, CommandManager.RegistrationEnvironment registrationEnvironment) {
        dispatcher.register(CommandManager.literal("test").executes(DayCommand::runTestCMD));
    }
    private static int runDayCMD(CommandContext<ServerCommandSource> context) {
        ServerCommandSource source = context.getSource();

        long time = source.getWorld().getTimeOfDay();
        int currentDay = (int)(time / 24000L);


        source.sendMessage(Text.literal("Days Survived: " + currentDay));
        return 1;
    }
    private static int runTestCMD(CommandContext<ServerCommandSource> context) {
        ServerCommandSource source = context.getSource();
        // Input any methods or code to test here
        Screen settingsGUI = SettingsGUI.OpenGUI().build();
        while (KeyBinds.settingsKeyBind.wasPressed()) {
            MinecraftClient.getInstance().execute(() -> {
                    MinecraftClient.getInstance().setScreen(settingsGUI);
            });
        }
        source.sendMessage(Text.literal("Routine Complete"));
        return 1;
    }
}
