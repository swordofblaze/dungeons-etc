package com.swordofblaze.dungeons_etc.common.effects;

import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectType;
import net.minecraft.tags.EntityTypeTags;

import javax.annotation.Nullable;

public class ModEffect extends Effect {

    public ModEffect(EffectType effectType, int liquidColor) {
        super(effectType, liquidColor);
    }

    @Override
    public void performEffect(LivingEntity entityLivingBaseIn, int amplifier) {

    }

    @Override
    public void affectEntity(@Nullable Entity source, @Nullable Entity indirectSource, LivingEntity entityLivingBaseIn, int amplifier, double health) {
      
    }

    @Override
    public boolean isReady(int duration, int amplifier) {
        return false;
    }
}
