package com.yutadev31.tinyutils;

import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.KeyMapping;
import org.lwjgl.glfw.GLFW;

import java.awt.*;

public class ModKeyBindings {
    private static KeyMapping openScreenBinding;
    private static final String CATEGORY = "category.tinyutils";

    public static void registerKeyBindings() {
        openScreenBinding = KeyBindingHelper.registerKeyBinding(new KeyMapping("key.tinyutils.open-screen", GLFW.GLFW_KEY_V, CATEGORY));

        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            if (openScreenBinding.isDown()) {
                TinyUtilsClient.copyPosition();
            }
        });
    }
}