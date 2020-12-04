package com.swordofblaze.dungeons_etc.common.core;

import com.swordofblaze.dungeons_etc.common.capability.Capabilities;
import com.swordofblaze.dungeons_etc.common.event.AttachCapabilityEvents;
import com.swordofblaze.dungeons_etc.common.event.EntityEvents;
import com.swordofblaze.dungeons_etc.common.event.PlayerEvents;
import com.swordofblaze.dungeons_etc.common.network.PacketHandler;
import com.swordofblaze.dungeons_etc.common.registers.ModBlocks;
import com.swordofblaze.dungeons_etc.common.registers.ModEffects;
import com.swordofblaze.dungeons_etc.common.registers.ModEntities;
import com.swordofblaze.dungeons_etc.common.registers.ModItems;
import net.minecraft.network.NetworkManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.network.NetworkRegistry;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(DungeonsEtc.MODID)
public class DungeonsEtc {

    public static final String MODID = "dungeons_etc";
    public static final String NAME = "Dungeons Etc";
    private final String version;

    public static final Logger LOGGER = LogManager.getLogger(MODID);
    public static final PacketHandler packetHandler = new PacketHandler();
    public static DungeonsEtc INSTANCE;

    public static ResourceLocation resourceLoc(String path) {
        return new ResourceLocation(MODID, path);
    }

    public DungeonsEtc() {
        version = ModLoadingContext.get().getActiveContainer().getModInfo().getVersion().getQualifier();
        INSTANCE = this;

        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
        eventBus.addListener(this::commonSetup);

        MinecraftForge.EVENT_BUS.register(new EntityEvents());
        MinecraftForge.EVENT_BUS.register(new PlayerEvents());
        MinecraftForge.EVENT_BUS.register(new AttachCapabilityEvents());

        ModItems.ITEMS.register(eventBus);
        ModBlocks.BLOCKS.register(eventBus);
        ModEntities.ENTITIES.register(eventBus);
        ModEffects.EFFECTS.register(eventBus);

        packetHandler.register();
    }

    private void commonSetup(FMLCommonSetupEvent event) {
        Capabilities.registerCapabilities();
        ModEntities.registerAttributes();
        ModEntities.registerEntityPlacement();
        ModEntities.registerEntitySpawns();
    }

    public String getModVersion() {
        return this.version;
    }
}
