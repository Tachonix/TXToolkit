package com.tachonix.commands;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.context.CommandContext;
import net.minecraft.command.CommandRegistryAccess;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.text.Text;

public class DayCommand {

    public static void register(CommandDispatcher<ServerCommandSource> dispatcher, CommandRegistryAccess commandRegistryAccess, CommandManager.RegistrationEnvironment registrationEnvironment) {
        dispatcher.register(CommandManager.literal("day").executes(DayCommand::run));
    }
    private static int run(CommandContext<ServerCommandSource> context) {
        ServerCommandSource source = context.getSource();

        long time = source.getWorld().getTimeOfDay();
        int currentDay = (int)(time / 24000L);


        source.sendMessage(Text.literal("Days Survived: " + currentDay));
        return 1;
    }
}
