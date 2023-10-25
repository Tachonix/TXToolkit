package com.tachonix.inputs;

import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import org.lwjgl.glfw.GLFW;

public class KeyBinds {
    public static KeyBinding keyBinding1;
    public static KeyBinding keyBinding2;
    public static KeyBinding keyBinding3;
    public static void RegisterKeyBinds(){
        keyBinding1 = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                "key.tachonix.zoom1",
                InputUtil.Type.KEYSYM,
                GLFW.GLFW_KEY_C,
                "category.tachonix.zoom"
        ));
        keyBinding2 = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                "key.tachonix.zoom2",
                InputUtil.Type.KEYSYM,
                GLFW.GLFW_KEY_UNKNOWN,
                "category.tachonix.zoom"
        ));
        keyBinding3 = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                "key.tachonix.zoom3",
                InputUtil.Type.KEYSYM,
                GLFW.GLFW_KEY_UNKNOWN,
                "category.tachonix.zoom"
        ));
    }
}
