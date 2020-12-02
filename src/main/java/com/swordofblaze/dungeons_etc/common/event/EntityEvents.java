package com.swordofblaze.dungeons_etc.common.event;

import com.swordofblaze.dungeons_etc.common.core.DungeonsEtc;
import com.swordofblaze.dungeons_etc.common.registers.ModEffects;
import com.swordofblaze.dungeons_etc.common.tags.ModEntityTypeTags;
import com.swordofblaze.dungeons_etc.common.util.CapabilityHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.potion.EffectInstance;
import net.minecraftforge.event.entity.living.LivingDamageEvent;
import net.minecraftforge.event.entity.living.LivingEntityUseItemEvent;
import net.minecraftforge.event.entity.player.CriticalHitEvent;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = DungeonsEtc.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class EntityEvents {

    @SubscribeEvent
    public static void onMarkedEntityDamaged(LivingDamageEvent event) {
        LivingEntity victim = event.getEntityLiving();
        Entity attacker = event.getSource().getTrueSource();

        if (victim.isPotionActive(ModEffects.DEATH_MARK.get())) {
            if (attacker != null) {
                float hunterBonus = ModEntityTypeTags.MARKED_HUNTERS.contains(attacker.getType()) ? 5.0f : 0;
                event.setAmount((float) (event.getAmount() * 1.25) + hunterBonus);
            }
        }
        if (attacker != null && attacker.getType() == EntityType.WOLF) {
            victim.addPotionEffect(new EffectInstance(ModEffects.DEATH_MARK.get(), 15 * 20));
        }
    }

    @SubscribeEvent
    public static void onCriticalHit(CriticalHitEvent event) {
        if (!event.getPlayer().getEntityWorld().isRemote && event.isVanillaCritical()) {

            if (event.getTarget() instanceof PlayerEntity) {
                    ServerPlayerEntity target = (ServerPlayerEntity) event.getTarget();
                    CapabilityHelper.addPlayerStress(target, 15);
            }
            ServerPlayerEntity playerEntity = (ServerPlayerEntity) event.getPlayer();
            CapabilityHelper.subtractPlayerStress(playerEntity, 5);
        }
    }
}
