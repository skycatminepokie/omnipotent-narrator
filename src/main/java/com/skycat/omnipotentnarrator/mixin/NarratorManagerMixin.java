package com.skycat.omnipotentnarrator.mixin;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.option.NarratorMode;
import net.minecraft.client.util.NarratorManager;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(NarratorManager.class)
public abstract class NarratorManagerMixin {

    @Shadow @Final private MinecraftClient client;

    @Inject(method = "onModeChange", at = @At("HEAD"), cancellable = true)
    private void turnOn(NarratorMode mode, CallbackInfo ci) {
        if (mode != NarratorMode.ALL) {
            client.options.getNarrator().setValue(NarratorMode.ALL);
            ci.cancel();
        }
    }
}
