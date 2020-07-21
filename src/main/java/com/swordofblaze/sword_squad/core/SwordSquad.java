package com.swordofblaze.sword_squad.core;

import com.swordofblaze.sword_squad.registers.SSBlocks;
import com.swordofblaze.sword_squad.registers.SSEntities;
import com.swordofblaze.sword_squad.registers.SSItems;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.server.FMLServerAboutToStartEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(SwordSquad.MODID)
public class SwordSquad
{
    // MODID
    public static final String MODID = "sword_squad";
    // Logger
    private static final Logger LOGGER = LogManager.getLogger();
    // Mod instance
    public static SwordSquad INSTANCE;


    public SwordSquad() {
        INSTANCE = this;

        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::commonSetup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::serverStarting);

        SSItems.ITEMS.register(eventBus);
        SSBlocks.BLOCKS.register(eventBus);
        SSEntities.ENTITIES.register(eventBus);

        MinecraftForge.EVENT_BUS.register(this);
    }

    private void serverStarting(FMLServerAboutToStartEvent event) {

    }

    private void commonSetup(FMLCommonSetupEvent event) {

    }
}
