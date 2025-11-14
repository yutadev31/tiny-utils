package com.yutadev31.tinyutils.gui.screens;

import com.yutadev31.tinyutils.TinyUtilsClient;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;

public class TinyUtilsMenuScreen extends Screen {
    public TinyUtilsMenuScreen() {
        super(Component.translatable("title.tinyutils.menu"));
    }

    public Button copyPositionButton;

    @Override
    protected void init() {
        copyPositionButton = Button.builder(Component.translatable("button.tinyutils.copy-position"), button -> {
                    TinyUtilsClient.copyPosition();
                })
                .bounds(width / 2 - 100, 20, 200, 20)
                .build();

        addRenderableWidget(copyPositionButton);
    }
}
