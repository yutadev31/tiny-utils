package com.yutadev31.tinyutils;

import com.terraformersmc.modmenu.api.ConfigScreenFactory;
import com.terraformersmc.modmenu.api.ModMenuApi;
import com.yutadev31.tinyutils.gui.screens.TinyUtilsConfigScreen;

public class TinyUtilsModMenuIntegration implements ModMenuApi {
    @Override
    public ConfigScreenFactory<?> getModConfigScreenFactory() {
        return TinyUtilsConfigScreen::create;
    }
}
