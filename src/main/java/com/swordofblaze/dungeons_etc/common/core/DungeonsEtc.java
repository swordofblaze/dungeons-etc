package com.swordofblaze.dungeons_etc.common.core;

import com.swordofblaze.dungeons_etc.common.registers.ModBlocks;
import com.swordofblaze.dungeons_etc.common.registers.ModEffects;
import com.swordofblaze.dungeons_etc.common.registers.ModEntities;
import com.swordofblaze.dungeons_etc.common.registers.ModItems;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(DungeonsEtc.MODID)
public class DungeonsEtc {

    public static final String MODID = "dungeons_etc";
    public static final Logger LOGGER = LogManager.getLogger(MODID);
    public static DungeonsEtc INSTANCE;

    public static ResourceLocation resourceLoc(String path) {
        return new ResourceLocation(MODID, path);
    }

    public DungeonsEtc() {
        INSTANCE = this;

        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
        eventBus.addListener(this::commonSetup);

        ModItems.ITEMS.register(eventBus);
        ModBlocks.BLOCKS.register(eventBus);
        ModEntities.ENTITIES.register(eventBus);
        ModEffects.EFFECTS.register(eventBus);
    }

    private void commonSetup(FMLCommonSetupEvent event) {
        ModEntities.registerAttributes();
    }
}
