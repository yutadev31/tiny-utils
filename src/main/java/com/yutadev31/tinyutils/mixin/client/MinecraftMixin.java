package com.yutadev31.tinyutils.mixin.client;

import com.yutadev31.tinyutils.config.TinyUtilsConfig;
import net.minecraft.client.Minecraft;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

@Mixin(Minecraft.class)
public class MinecraftMixin {
    @Inject(at = @At("TAIL"), method = "createTitle", locals = LocalCapture.CAPTURE_FAILEXCEPTION, cancellable = true)
    private void createTitle(CallbackInfoReturnable<String> info, StringBuilder stringBuilder) {
        if (!TinyUtilsConfig.INSTANCE.titleSuffix.isEmpty()) {
            stringBuilder.append(" - ");
            stringBuilder.append(TinyUtilsConfig.INSTANCE.titleSuffix);
        }

        info.setReturnValue(stringBuilder.toString());
    }
}