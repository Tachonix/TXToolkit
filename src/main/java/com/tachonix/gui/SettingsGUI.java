package com.tachonix.gui;

import it.unimi.dsi.fastutil.ints.IntList;
import me.shedaniel.clothconfig2.api.ConfigBuilder;
import me.shedaniel.clothconfig2.api.ConfigCategory;
import me.shedaniel.clothconfig2.api.ConfigEntryBuilder;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.text.Text;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class SettingsGUI {
    public static ConfigBuilder OpenGUI() {
        AtomicReference<String> currentValue = new AtomicReference<>("Initial Value"); // Declare currentValue and set its initial value
        // Set the parent screen to whatever was there before, typically the main game ui
        Screen parent = MinecraftClient.getInstance().currentScreen;
        // Create a configuration
        ConfigBuilder builder = ConfigBuilder.create()
                .setParentScreen(parent)
                .setTitle(Text.translatable("title.tachonix.SettingsGUI"));
        // Save configuration
        builder.setSavingRunnable(() -> {
            /* TODO */
        });
        // Create Category for options
        ConfigCategory general = builder.getOrCreateCategory(Text.translatable("category.tachonix.general"));
        // Create option builder
        ConfigEntryBuilder entryBuilder = builder.entryBuilder();
        // Add option
        general.addEntry(entryBuilder.startStrField(Text.translatable("option.tachonix.option1"), currentValue.get())
                .setDefaultValue("This is the default value")
                .setTooltip(Text.translatable("This is a tooltip"))
                .setSaveConsumer(newValue -> currentValue.set(newValue)) // Update the lambda
                .build());
        return builder;
    }

    public static void BuildConfig(){
        final String[] value = {"l"};
        Screen parent = MinecraftClient.getInstance().currentScreen;
        ConfigBuilder builder = ConfigBuilder.create()
                .setParentScreen(parent)
                .setTitle(Text.literal("Test Title"));
        builder.setSavingRunnable(() -> {
            // TODO
        });
        ConfigCategory general = builder.getOrCreateCategory(Text.literal("Test Category"));
        ConfigEntryBuilder entryBuilder = builder.entryBuilder();
        general.addEntry(entryBuilder.startStrField(Text.literal("Test"), "l")
                .setDefaultValue("Default Value")
                .setTooltip(Text.literal("Tooltip"))
                .setSaveConsumer(newValue -> value[0] = newValue)
                .build());


        Screen screen = builder.build();
        MinecraftClient.getInstance().setScreen(screen);
    }
}
