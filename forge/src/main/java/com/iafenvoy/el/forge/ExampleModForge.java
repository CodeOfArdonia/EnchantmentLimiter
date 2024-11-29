package com.iafenvoy.el.forge;

import dev.architectury.platform.forge.EventBuses;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

import com.iafenvoy.el.EnchantmentLimiter;

@Mod(EnchantmentLimiter.MOD_ID)
public final class ExampleModForge {
    public ExampleModForge() {
        // Submit our event bus to let Architectury API register our content on the right time.
        EventBuses.registerModEventBus(EnchantmentLimiter.MOD_ID, FMLJavaModLoadingContext.get().getModEventBus());

        // Run our common setup.
        EnchantmentLimiter.init();
    }
}
