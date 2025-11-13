package com.yutadev31.tinyutils;

import com.yutadev31.tinyutils.config.TinyUtilsConfig;
import net.fabricmc.api.ClientModInitializer;
import net.minecraft.client.Minecraft;

public class TinyUtilsClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ModKeyBindings.registerKeyBindings();

        TinyUtilsConfig.load();
    }

    public static void copyPosition() {
        var player = Minecraft.getInstance().player;
        if (player == null) {
            return;
        }

        var pos = player.blockPosition();

        String text = TinyUtilsConfig.INSTANCE.positionFormat
                .replace("%X", pos.getX() + "")
                .replace("%Y", pos.getY() + "")
                .replace("%Z", pos.getZ() + "");

        Minecraft.getInstance().keyboardHandler.setClipboard(text);
    }
}