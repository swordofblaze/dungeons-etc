package com.swordofblaze.dungeons_etc.common.damagesource;

import com.swordofblaze.dungeons_etc.common.core.DungeonsEtc;
import com.swordofblaze.dungeons_etc.common.util.CapabilityHelper;
import mcp.MethodsReturnNonnullByDefault;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.util.DamageSource;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import org.jetbrains.annotations.NotNull;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault
public class ModDamageSources {

    public static final DamageSource HEART_ATTACK = new ModDamageSource("heart_attack").setDamageBypassesArmor().setDamageIsAbsolute();
    public static final DamageSource BLIGHT = new ModDamageSource("blight").setDamageBypassesArmor();

    public static void inflictStress(ServerPlayerEntity playerEntity, int amount) {
        CapabilityHelper.addPlayerStress(playerEntity, amount);
    }

    public static void inflictHeartAttack(PlayerEntity playerEntity) {
        playerEntity.attackEntityFrom(HEART_ATTACK, 1000.0F);
    }

    protected static class ModDamageSource extends DamageSource {

        public ModDamageSource(String damageType) {
            super(DungeonsEtc.MODID + "." + damageType);
        }

        @Override
        public ITextComponent getDeathMessage(LivingEntity livingEntity) {
            LivingEntity attacker = livingEntity.getAttackingEntity();
            String defaultString = "death.attack." + this.damageType;
            String withAttacker = defaultString + ".player";
            String selfAttack = defaultString + ".self";

            if (attacker == null) {
                return new TranslationTextComponent(defaultString, livingEntity.getDisplayName());
            }
            return attacker == livingEntity
                    ? new TranslationTextComponent(selfAttack, livingEntity.getDisplayName())
                    : new TranslationTextComponent(withAttacker, livingEntity.getDisplayName(), attacker.getDisplayName());
        }
    }
}
