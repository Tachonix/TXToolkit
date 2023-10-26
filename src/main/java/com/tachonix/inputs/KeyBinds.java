package com.tachonix.inputs;

import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import org.lwjgl.glfw.GLFW;


public class KeyBinds {
    public static KeyBinding settingsKeyBind;
    public static KeyBinding zoomKeyBind1;
    public static KeyBinding zoomKeyBind2;
    public static KeyBinding zoomKeyBind3;
    public static void RegisterKeyBinds() {
        settingsKeyBind = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                "key.tachonix.settings",
                InputUtil.Type.KEYSYM,
                GLFW.GLFW_KEY_X,
                "category.tachonix.txtoolkit"
        ));

        zoomKeyBind1 = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                "key.tachonix.zoom1",
                InputUtil.Type.KEYSYM,
                GLFW.GLFW_KEY_C,
                "category.tachonix.txtoolkit"
        ));
        zoomKeyBind2 = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                "key.tachonix.zoom2",
                InputUtil.Type.KEYSYM,
                GLFW.GLFW_KEY_UNKNOWN,
                "category.tachonix.txtoolkit"
        ));
        zoomKeyBind3 = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                "key.tachonix.zoom3",
                InputUtil.Type.KEYSYM,
                GLFW.GLFW_KEY_UNKNOWN,
                "category.tachonix.txtoolkit"
        ));
    }
}
