package org.dev.nobossbarmod.mixin;

import net.minecraft.client.DeltaTracker;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiGraphics;
import org.dev.nobossbarmod.NoBossBarMod;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Gui.class)
public class MixinGui {
   @Inject(method = "renderBossOverlay", at = @At("HEAD"), cancellable = true)
    private void renderBossBar(GuiGraphics guiGraphics, DeltaTracker deltaTracker, CallbackInfo ci) {
       if (NoBossBarMod.isRender) {
           ci.cancel();
       }
   }
}
