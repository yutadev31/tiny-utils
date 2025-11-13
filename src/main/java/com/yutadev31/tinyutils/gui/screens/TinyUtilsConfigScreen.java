package com.yutadev31.tinyutils.gui.screens;

import com.yutadev31.tinyutils.config.TinyUtilsConfig;
import me.shedaniel.clothconfig2.api.ConfigBuilder;
import me.shedaniel.clothconfig2.api.ConfigCategory;
import me.shedaniel.clothconfig2.api.ConfigEntryBuilder;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;

public class TinyUtilsConfigScreen {
    public static Screen create(Screen parent) {
        ConfigBuilder builder = ConfigBuilder.create()
                .setParentScreen(parent)
                .setTitle(Component.translatable("title.tinyutils.config"));

        ConfigCategory general = builder.getOrCreateCategory(Component.translatable("category.tinyutils.general"));
        ConfigEntryBuilder entryBuilder = builder.entryBuilder();

        general.addEntry(entryBuilder
                .startStrField(Component.translatable("option.tinyutils.title-suffix"), TinyUtilsConfig.INSTANCE.titleSuffix)
                .setDefaultValue("")
                .setSaveConsumer(newValue -> TinyUtilsConfig.INSTANCE.titleSuffix = newValue)
                .build());

        general.addEntry(entryBuilder
                .startStrField(Component.translatable("option.tinyutils.position-format"), TinyUtilsConfig.INSTANCE.positionFormat)
                .setDefaultValue("x%X, y%Y, z%Z")
                .setSaveConsumer(newValue -> TinyUtilsConfig.INSTANCE.positionFormat = newValue)
                .build());

        builder.setSavingRunnable(TinyUtilsConfig::save);

        return builder.build();
    }
}

