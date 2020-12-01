package com.swordofblaze.dungeons_etc.common.datagen;

import com.google.common.collect.ImmutableList;
import com.mojang.datafixers.util.Pair;
import com.swordofblaze.dungeons_etc.common.core.DungeonsEtc;
import com.swordofblaze.dungeons_etc.common.datagen.loot_table.BlockLootTableGen;
import com.swordofblaze.dungeons_etc.common.datagen.loot_table.ChestLootTableGen;
import com.swordofblaze.dungeons_etc.common.datagen.loot_table.EntityLootTableGen;
import mcp.MethodsReturnNonnullByDefault;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.LootTableProvider;
import net.minecraft.loot.LootParameterSet;
import net.minecraft.loot.LootParameterSets;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.ValidationTracker;
import net.minecraft.util.ResourceLocation;
import org.jetbrains.annotations.NotNull;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
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
        return super.getName() + ": " + DungeonsEtc.NAME;
    }

    @Override
    protected void validate(@NotNull Map<ResourceLocation, LootTable> map, @NotNull ValidationTracker validationtracker) {

    }
}
