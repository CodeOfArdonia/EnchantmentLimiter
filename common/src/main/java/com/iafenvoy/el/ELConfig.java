package com.iafenvoy.el;

import com.google.gson.JsonParser;
import com.mojang.serialization.Codec;
import com.mojang.serialization.JsonOps;
import com.mojang.serialization.codecs.UnboundedMapCodec;
import it.unimi.dsi.fastutil.objects.Object2IntArrayMap;
import it.unimi.dsi.fastutil.objects.Object2IntMap;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.registry.Registries;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.FileReader;
import java.nio.charset.StandardCharsets;
import java.util.LinkedHashMap;

public class ELConfig {
    private static final UnboundedMapCodec<Enchantment, Integer> CODEC = Codec.unboundedMap(Registries.ENCHANTMENT.getCodec(), Codec.INT);
    private static final String PATH = "./config/enchantment-limiter.json";

    private static final Object2IntMap<Enchantment> DATA = new Object2IntArrayMap<>();

    public static int getMaxLevel(Enchantment enchantment) {
        return DATA.getOrDefault(enchantment, enchantment.getMaxLevel());
    }

    public static void load() {
        try {

            DATA.clear();
            DATA.putAll(CODEC.parse(JsonOps.INSTANCE, JsonParser.parseReader(new FileReader(PATH))).result().orElse(new LinkedHashMap<>()));
        } catch (Exception e) {
            EnchantmentLimiter.LOGGER.error("Failed to load Enchantment Limiter config.", e);
            try {
                FileUtils.write(new File(PATH), "{\n}", StandardCharsets.UTF_8);
            } catch (Exception ex) {
                EnchantmentLimiter.LOGGER.error("Failed to create Enchantment Limiter config.", ex);
            }
        }
    }
}
