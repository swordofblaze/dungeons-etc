package com.swordofblaze.dungeons_etc.common.effects;

import com.swordofblaze.dungeons_etc.common.damagesource.ModDamageSources;
import net.minecraft.entity.LivingEntity;
import net.minecraft.potion.EffectType;

public class BlightEffect extends ModEffect {

    public BlightEffect(EffectType effectType, int liquidColor) {
        super(effectType, liquidColor);
    }

    @Override
    public void performEffect(LivingEntity livingEntity, int amplifier) {
        livingEntity.attackEntityFrom(ModDamageSources.BLIGHT, (float) ((amplifier + 1) / 2));
    }

    @Override
    public boolean isReady(int duration, int amplifier) {
        // 2.5 seconds
        int interval = 50;
        return duration % interval == 0;
    }
}
