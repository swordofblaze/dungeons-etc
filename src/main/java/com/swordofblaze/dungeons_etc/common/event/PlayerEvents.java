package com.swordofblaze.dungeons_etc.common.event;

import com.swordofblaze.dungeons_etc.common.capability.Capabilities;
import com.swordofblaze.dungeons_etc.common.capability.stress.DefaultStressCapability;
import com.swordofblaze.dungeons_etc.common.core.DungeonsEtc;
import com.swordofblaze.dungeons_etc.common.damagesource.ModDamageSources;
import com.swordofblaze.dungeons_etc.common.network.PacketUpdatePlayerStress;
import com.swordofblaze.dungeons_etc.common.util.CapabilityHelper;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.world.SleepFinishedTimeEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.List;

@Mod.EventBusSubscriber(modid = DungeonsEtc.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class PlayerEvents {

    @SubscribeEvent
    @SuppressWarnings("all")
    public static void onPlayerEnterWorld(PlayerEvent.PlayerLoggedInEvent event) {
        PlayerEntity playerEntity = event.getPlayer();

        if (playerEntity.getCapability(Capabilities.STRESS_CAPABILITY, null).isPresent())
            DungeonsEtc.packetHandler.sendToClient(new PacketUpdatePlayerStress(CapabilityHelper.getPlayerStress(playerEntity)), (ServerPlayerEntity) playerEntity);
    }

    @SubscribeEvent
    @SuppressWarnings("all")
    public static void onPlayerSleep(SleepFinishedTimeEvent event) {
        List<? extends PlayerEntity> players = event.getWorld().getPlayers();

        for (PlayerEntity playerEntity : players) {
            if (playerEntity.getCapability(Capabilities.STRESS_CAPABILITY).isPresent()) {
                CapabilityHelper.subtractPlayerStress((ServerPlayerEntity) playerEntity, 50);
            }
        }
    }

    @SubscribeEvent
    public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
        PlayerEntity playerEntity = event.player;

        if (CapabilityHelper.getPlayerStress(playerEntity) >= DefaultStressCapability.maxStress())
            ModDamageSources.inflictHeartAttack(playerEntity);
    }
}
