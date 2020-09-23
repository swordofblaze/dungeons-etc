package com.swordofblaze.dungeons_etc.common.datagen;

import com.google.common.collect.ImmutableList;
import com.mojang.datafixers.util.Pair;
import com.swordofblaze.dungeons_etc.common.core.DungeonsEtc;
import com.swordofblaze.dungeons_etc.common.datagen.loot_table.BlockLootTableGen;
import com.swordofblaze.dungeons_etc.common.datagen.loot_table.ChestLootTableGen;
import com.swordofblaze.dungeons_etc.common.datagen.loot_table.EntityLootTableGen;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.LootTableProvider;
import net.minecraft.loot.LootParameterSet;
import net.minecraft.loot.LootParameterSets;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.ValidationTracker;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nonnull;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class LootTablesGen extends LootTableProvider {


    public LootTablesGen(DataGenerator generator) {
        super(generator);
    }

    @Override
    protected List<Pair<Supplier<Consumer<BiConsumer<ResourceLocation, LootTable.Builder>>>, LootParameterSet>> getTables() {
        ImmutableList.Builder<Pair<Supplier<Consumer<BiConsumer<ResourceLocation, LootTable.Builder>>>, LootParameterSet>> builder = new ImmutableList.Builder<>();

        builder.add(Pair.of(BlockLootTableGen::new, LootParameterSets.BLOCK));
        builder.add(Pair.of(ChestLootTableGen::new, LootParameterSets.CHEST));
        builder.add(Pair.of(EntityLootTableGen::new, LootParameterSets.ENTITY));

        return builder.build();
    }

    @Override
    public String getName() {
        return super.getName() + ":" + DungeonsEtc.MODID;
    }

    @Override
    protected void validate(@Nonnull Map<ResourceLocation, LootTable> map, @Nonnull ValidationTracker validationtracker) {

    }
}
