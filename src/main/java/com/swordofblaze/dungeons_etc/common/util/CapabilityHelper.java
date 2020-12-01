package com.swordofblaze.dungeons_etc.common.util;

import com.swordofblaze.dungeons_etc.common.capability.Capabilities;
import com.swordofblaze.dungeons_etc.common.core.DungeonsEtc;
import com.swordofblaze.dungeons_etc.common.network.PacketUpdatePlayerStress;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import org.jetbrains.annotations.NotNull;

@SuppressWarnings("all")
public class CapabilityHelper {

    public static int getPlayerStress(@NotNull PlayerEntity playerEntity) {
        return playerEntity.getCapability(Capabilities.STRESS_CAPABILITY, null).orElse(Capabilities.STRESS_CAPABILITY.getDefaultInstance()).getStress();
    }

    public static void setPlayerStress(@NotNull ServerPlayerEntity playerEntity, int amount) {
        playerEntity.getCapability(Capabilities.STRESS_CAPABILITY, null).orElse(Capabilities.STRESS_CAPABILITY.getDefaultInstance()).setStress(amount);
        DungeonsEtc.packetHandler.sendToClient(new PacketUpdatePlayerStress(getPlayerStress(playerEntity)), playerEntity);
    }

    public static void addPlayerStress(@NotNull ServerPlayerEntity playerEntity, int amount) {
        playerEntity.getCapability(Capabilities.STRESS_CAPABILITY, null).orElse(Capabilities.STRESS_CAPABILITY.getDefaultInstance()).addStress(amount);
        DungeonsEtc.packetHandler.sendToClient(new PacketUpdatePlayerStress(getPlayerStress(playerEntity)), playerEntity);
    }

    public static void subtractPlayerStress(@NotNull ServerPlayerEntity playerEntity, int amount) {
        playerEntity.getCapability(Capabilities.STRESS_CAPABILITY, null).orElse(Capabilities.STRESS_CAPABILITY.getDefaultInstance()).subtractStress(amount);
        DungeonsEtc.packetHandler.sendToClient(new PacketUpdatePlayerStress(getPlayerStress(playerEntity)), playerEntity);
    }
}
