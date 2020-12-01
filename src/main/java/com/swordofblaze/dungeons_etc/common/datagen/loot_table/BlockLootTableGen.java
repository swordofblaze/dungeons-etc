package com.swordofblaze.dungeons_etc.common.datagen.loot_table;

import com.swordofblaze.dungeons_etc.common.registers.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.data.loot.BlockLootTables;
import net.minecraft.loot.LootTable;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nonnull;
import java.util.HashSet;
import java.util.Set;

public class BlockLootTableGen extends BlockLootTables {

    private final Set<Block> knownBlocks = new HashSet<>();

    @Override
    protected void registerLootTable(@NotNull Block block, @NotNull LootTable.Builder table) {
        super.registerLootTable(block, table);
        this.knownBlocks.add(block);
    }

    @Override
    protected @NotNull Iterable<Block> getKnownBlocks() {
        return this.knownBlocks;
    }

    @Override
    protected void addTables() {
        this.registerDropSelfLootTable(ModBlocks.CRACKED_ANDESITE.get());
        this.registerDropSelfLootTable(ModBlocks.CRACKED_ANDESITE_SLAB.get());
        this.registerDropSelfLootTable(ModBlocks.CRACKED_ANDESITE_STAIRS.get());
        this.registerDropSelfLootTable(ModBlocks.CRACKED_ANDESITE_WALL.get());

        this.registerDropSelfLootTable(ModBlocks.CRACKED_DIORITE.get());
        this.registerDropSelfLootTable(ModBlocks.CRACKED_DIORITE_SLAB.get());
        this.registerDropSelfLootTable(ModBlocks.CRACKED_DIORITE_STAIRS.get());
        this.registerDropSelfLootTable(ModBlocks.CRACKED_DIORITE_WALL.get());

        this.registerDropSelfLootTable(ModBlocks.CRACKED_GRANITE.get());
        this.registerDropSelfLootTable(ModBlocks.CRACKED_GRANITE_SLAB.get());
        this.registerDropSelfLootTable(ModBlocks.CRACKED_GRANITE_STAIRS.get());
        this.registerDropSelfLootTable(ModBlocks.CRACKED_GRANITE_WALL.get());

        this.registerDropSelfLootTable(ModBlocks.CRACKED_BRICKS.get());
        this.registerDropSelfLootTable(ModBlocks.CRACKED_BRICK_SLAB.get());
        this.registerDropSelfLootTable(ModBlocks.CRACKED_BRICK_STAIRS.get());
        this.registerDropSelfLootTable(ModBlocks.CRACKED_BRICK_WALL.get());

        this.registerDropSelfLootTable(ModBlocks.ANDESITE_BRICKS.get());
        this.registerDropSelfLootTable(ModBlocks.ANDESITE_BRICK_SLAB.get());
        this.registerDropSelfLootTable(ModBlocks.ANDESITE_BRICK_STAIRS.get());
        this.registerDropSelfLootTable(ModBlocks.ANDESITE_BRICK_WALL.get());
        this.registerDropSelfLootTable(ModBlocks.ANDESITE_BRICK_PRESSURE_PLATE.get());
        this.registerDropSelfLootTable(ModBlocks.ANDESITE_BRICK_BUTTON.get());

        this.registerDropSelfLootTable(ModBlocks.DIORITE_BRICKS.get());
        this.registerDropSelfLootTable(ModBlocks.DIORITE_BRICK_SLAB.get());
        this.registerDropSelfLootTable(ModBlocks.DIORITE_BRICK_STAIRS.get());
        this.registerDropSelfLootTable(ModBlocks.DIORITE_BRICK_WALL.get());
        this.registerDropSelfLootTable(ModBlocks.DIORITE_BRICK_PRESSURE_PLATE.get());
        this.registerDropSelfLootTable(ModBlocks.DIORITE_BRICK_BUTTON.get());

        this.registerDropSelfLootTable(ModBlocks.GRANITE_BRICKS.get());
        this.registerDropSelfLootTable(ModBlocks.GRANITE_BRICK_SLAB.get());
        this.registerDropSelfLootTable(ModBlocks.GRANITE_BRICK_STAIRS.get());
        this.registerDropSelfLootTable(ModBlocks.GRANITE_BRICK_WALL.get());
        this.registerDropSelfLootTable(ModBlocks.GRANITE_BRICK_PRESSURE_PLATE.get());
        this.registerDropSelfLootTable(ModBlocks.GRANITE_BRICK_BUTTON.get());

        this.registerDropSelfLootTable(ModBlocks.STONE_BRICK_DISPENSER.get());
        this.registerDropSelfLootTable(ModBlocks.COBBLESTONE_DISPENSER.get());
        this.registerDropSelfLootTable(ModBlocks.BLACKSTONE_DISPENSER.get());

        this.registerLootTable(ModBlocks.WEBBER_WEB.get(), LootTable.builder());
    }
}
