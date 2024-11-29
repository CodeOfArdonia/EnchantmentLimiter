package com.iafenvoy.el;

import net.minecraft.world.GameRules;

public class ELGameRules {
    public static final GameRules.Key<GameRules.BooleanRule> ENABLE = GameRules.register("el:enable", GameRules.Category.UPDATES, GameRules.BooleanRule.create(false));
    public static final GameRules.Key<GameRules.IntRule> CHECK_INTERVAL = GameRules.register("el:interval", GameRules.Category.UPDATES, GameRules.IntRule.create(20));

    public static void init() {
    }
}
