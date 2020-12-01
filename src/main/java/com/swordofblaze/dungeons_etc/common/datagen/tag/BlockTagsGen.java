package com.swordofblaze.dungeons_etc.common.datagen.tag;

import com.swordofblaze.dungeons_etc.common.core.DungeonsEtc;
import com.swordofblaze.dungeons_etc.common.registers.ModBlocks;
import net.minecraft.data.BlockTagsProvider;
import net.minecraft.data.DataGenerator;
import net.minecraft.tags.BlockTags;
import org.jetbrains.annotations.NotNull;

public class BlockTagsGen extends BlockTagsProvider {

    public BlockTagsGen(DataGenerator generator) {
        super(generator);
    }

    @NotNull
    @Override
    public String getName() {
        return DungeonsEtc.NAME + ": " + "Block Type Tags";
    }

    @Override
    protected void registerTags() {

        // Slabs
        this.getOrCreateBuilder(BlockTags.SLABS).add(
                ModBlocks.CRACKED_ANDESITE_SLAB.get(),
                ModBlocks.CRACKED_DIORITE_SLAB.get(),
                ModBlocks.CRACKED_GRANITE_SLAB.get(),
                ModBlocks.CRACKED_BRICK_SLAB.get(),
                ModBlocks.ANDESITE_BRICK_SLAB.get(),
                ModBlocks.DIORITE_BRICK_SLAB.get(),
                ModBlocks.GRANITE_BRICK_SLAB.get()
        );
        // Walls
        this.getOrCreateBuilder(BlockTags.WALLS).add(
                ModBlocks.CRACKED_ANDESITE_WALL.get(),
                ModBlocks.CRACKED_DIORITE_WALL.get(),
                ModBlocks.CRACKED_GRANITE_WALL.get(),
                ModBlocks.CRACKED_BRICK_WALL.get(),
                ModBlocks.ANDESITE_BRICK_WALL.get(),
                ModBlocks.DIORITE_BRICK_WALL.get(),
                ModBlocks.GRANITE_BRICK_WALL.get()
        );
        // Stairs
        this.getOrCreateBuilder(BlockTags.STAIRS).add(
                ModBlocks.CRACKED_ANDESITE_STAIRS.get(),
                ModBlocks.CRACKED_DIORITE_STAIRS.get(),
                ModBlocks.CRACKED_GRANITE_STAIRS.get(),
                ModBlocks.CRACKED_BRICK_STAIRS.get(),
                ModBlocks.ANDESITE_BRICK_STAIRS.get(),
                ModBlocks.DIORITE_BRICK_STAIRS.get(),
                ModBlocks.GRANITE_BRICK_STAIRS.get()
        );
        // Buttons
        this.getOrCreateBuilder(BlockTags.BUTTONS).add(
                ModBlocks.ANDESITE_BRICK_BUTTON.get(),
                ModBlocks.DIORITE_BRICK_BUTTON.get(),
                ModBlocks.GRANITE_BRICK_BUTTON.get()
        );
    }
}
