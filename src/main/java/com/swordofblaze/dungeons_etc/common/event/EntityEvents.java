package com.swordofblaze.dungeons_etc.common.event;

import com.swordofblaze.dungeons_etc.common.core.DungeonsEtc;
import com.swordofblaze.dungeons_etc.common.registers.ModEffects;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.potion.EffectInstance;
import net.minecraftforge.event.entity.living.LivingDamageEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = DungeonsEtc.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class EntityEvents {

    @SubscribeEvent
    public static void onMarkedEntityDamaged(LivingDamageEvent event) {
        LivingEntity victim = event.getEntityLiving();
        Entity immediateSource = event.getSource().getImmediateSource();
        Entity attacker = event.getSource().getTrueSource();

        if (victim.isPotionActive(ModEffects.DEATH_MARK.get())) {

            if (immediateSource != null || attacker != null) {
                event.setAmount((float) (event.getAmount() * 1.25));
            }
        }

        if (attacker != null && attacker.getType() == EntityType.WOLF) {
            victim.addPotionEffect(new EffectInstance(ModEffects.DEATH_MARK.get(), 15 * 20));
        }
    }
}
