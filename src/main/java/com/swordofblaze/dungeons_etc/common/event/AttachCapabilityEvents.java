package com.swordofblaze.dungeons_etc.common.event;

import com.swordofblaze.dungeons_etc.common.capability.stress.StressCapabilityProvider;
import com.swordofblaze.dungeons_etc.common.core.DungeonsEtc;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

public class AttachCapabilityEvents {

    @SubscribeEvent
    public void onCapabilityAttach(AttachCapabilitiesEvent<Entity> event) {
        if (event.getObject() instanceof PlayerEntity) {
            event.addCapability(DungeonsEtc.resourceLoc("stress"), new StressCapabilityProvider());
        }
    }
}
