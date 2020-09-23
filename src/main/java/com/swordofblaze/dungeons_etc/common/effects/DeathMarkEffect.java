package com.swordofblaze.dungeons_etc.common.effects;

import net.minecraft.client.renderer.entity.LivingRenderer;
import net.minecraft.entity.projectile.SpectralArrowEntity;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectType;
import net.minecraft.potion.Effects;

public class DeathMarkEffect extends Effect {

    public DeathMarkEffect(EffectType type, int liquidColor) {
        super(type, liquidColor);
    }
}
