package com.iafenvoy.el;

import com.mojang.logging.LogUtils;
import org.slf4j.Logger;

public final class EnchantmentLimiter {
    public static final String MOD_ID = "enchantment_limiter";
    public static final Logger LOGGER = LogUtils.getLogger();

    public static void init() {
        ELConfig.load();
        ELGameRules.init();
    }
}
