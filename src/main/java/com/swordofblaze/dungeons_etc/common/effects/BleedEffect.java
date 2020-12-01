package com.swordofblaze.dungeons_etc.common.effects;

import net.minecraft.potion.EffectType;

public class BleedEffect extends ModEffect {

    public BleedEffect(EffectType effectType, int liquidColor) {
        super(effectType, liquidColor);
    }

    @Override
    public boolean isReady(int duration, int amplifier) {
        return false;
    }
}
