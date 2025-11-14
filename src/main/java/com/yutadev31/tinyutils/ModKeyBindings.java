package com.yutadev31.tinyutils;

import com.yutadev31.tinyutils.gui.screens.TinyUtilsMenuScreen;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.KeyMapping;
import net.minecraft.client.Minecraft;
import org.lwjgl.glfw.GLFW;

import java.awt.*;

public class ModKeyBindings {
    private static KeyMapping openScreenBinding;
    private static final String CATEGORY = "category.tinyutils.keybindings";

    public static void registerKeyBindings() {
        openScreenBinding = KeyBindingHelper.registerKeyBinding(new KeyMapping("key.tinyutils.open-menu", GLFW.GLFW_KEY_V, CATEGORY));

        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            if (openScreenBinding.isDown()) {
                Minecraft.getInstance().setScreen(new TinyUtilsMenuScreen());
            }
        });
    }
}
