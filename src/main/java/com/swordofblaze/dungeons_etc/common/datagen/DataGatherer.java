package com.swordofblaze.dungeons_etc.common.datagen;

import com.swordofblaze.dungeons_etc.common.core.DungeonsEtc;
import com.swordofblaze.dungeons_etc.common.datagen.tag.BlockTagsGen;
import com.swordofblaze.dungeons_etc.common.datagen.tag.EntityTypeTagGen;
import com.swordofblaze.dungeons_etc.common.datagen.tag.ItemTagsGen;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.GatherDataEvent;

@Mod.EventBusSubscriber(modid = DungeonsEtc.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataGatherer {

    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator dataGenerator = event.getGenerator();

        if (event.includeServer()) {
            dataGenerator.addProvider(new LootTablesGen(dataGenerator));
            dataGenerator.addProvider(new RecipesGen(dataGenerator));

            BlockTagsGen blockTagsGen = new BlockTagsGen(dataGenerator);

            dataGenerator.addProvider(blockTagsGen);
            dataGenerator.addProvider(new ItemTagsGen(dataGenerator, blockTagsGen));
            dataGenerator.addProvider(new EntityTypeTagGen(dataGenerator));
        }
        if (event.includeClient()) {
            dataGenerator.addProvider(new LangGen(dataGenerator));
        }
    }
}
