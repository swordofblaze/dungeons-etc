package com.swordofblaze.dungeons_etc.common.registers;

import com.swordofblaze.dungeons_etc.common.blocks.WebberWebBlock;
import com.swordofblaze.dungeons_etc.common.core.DungeonsEtc;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModBlocks {

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, DungeonsEtc.MODID);

    public static final RegistryObject<Block> CRACKED_ANDESITE = BLOCKS.register("cracked_andesite", () -> new Block(Block.Properties.create(Material.ROCK, MaterialColor.STONE).sound(SoundType.STONE).hardnessAndResistance(1.5F, 4.0F)));
    public static final RegistryObject<Block> CRACKED_ANDESITE_SLAB = BLOCKS.register("cracked_andesite_slab", () -> new SlabBlock(Block.Properties.create(Material.ROCK, MaterialColor.STONE).sound(SoundType.STONE).hardnessAndResistance(1.5F, 4.0F)));
    public static final RegistryObject<Block> CRACKED_ANDESITE_STAIRS = BLOCKS.register("cracked_andesite_stairs", () -> new StairsBlock(CRACKED_ANDESITE.get()::getDefaultState, Block.Properties.create(Material.ROCK, MaterialColor.STONE).sound(SoundType.STONE).hardnessAndResistance(1.5F, 4.0F)));
    public static final RegistryObject<Block> CRACKED_ANDESITE_WALL = BLOCKS.register("cracked_andesite_wall", () -> new WallBlock(Block.Properties.create(Material.ROCK, MaterialColor.STONE).sound(SoundType.STONE).hardnessAndResistance(1.5F, 4.0F)));

    public static final RegistryObject<Block> CRACKED_DIORITE = BLOCKS.register("cracked_diorite", () -> new Block(Block.Properties.create(Material.ROCK, MaterialColor.QUARTZ).sound(SoundType.STONE).hardnessAndResistance(1.5F, 4.0F)));
    public static final RegistryObject<Block> CRACKED_DIORITE_SLAB = BLOCKS.register("cracked_diorite_slab", () -> new SlabBlock(Block.Properties.create(Material.ROCK, MaterialColor.QUARTZ).sound(SoundType.STONE).hardnessAndResistance(1.5F, 4.0F)));
    public static final RegistryObject<Block> CRACKED_DIORITE_STAIRS = BLOCKS.register("cracked_diorite_stairs", () -> new StairsBlock(CRACKED_DIORITE.get()::getDefaultState, Block.Properties.create(Material.ROCK, MaterialColor.QUARTZ).sound(SoundType.STONE).hardnessAndResistance(1.5F, 4.0F)));
    public static final RegistryObject<Block> CRACKED_DIORITE_WALL = BLOCKS.register("cracked_diorite_wall", () -> new WallBlock(Block.Properties.create(Material.ROCK, MaterialColor.QUARTZ).sound(SoundType.STONE).hardnessAndResistance(1.5F, 4.0F)));

    public static final RegistryObject<Block> CRACKED_GRANITE = BLOCKS.register("cracked_granite", () -> new Block(Block.Properties.create(Material.ROCK, MaterialColor.DIRT).sound(SoundType.STONE).hardnessAndResistance(1.5F, 4.0F)));
    public static final RegistryObject<Block> CRACKED_GRANITE_SLAB = BLOCKS.register("cracked_granite_slab", () -> new SlabBlock(Block.Properties.create(Material.ROCK, MaterialColor.DIRT).sound(SoundType.STONE).hardnessAndResistance(1.5F, 4.0F)));
    public static final RegistryObject<Block> CRACKED_GRANITE_STAIRS = BLOCKS.register("cracked_granite_stairs", () -> new StairsBlock(CRACKED_GRANITE.get()::getDefaultState, Block.Properties.create(Material.ROCK, MaterialColor.DIRT).sound(SoundType.STONE).hardnessAndResistance(1.5F, 4.0F)));
    public static final RegistryObject<Block> CRACKED_GRANITE_WALL = BLOCKS.register("cracked_granite_wall", () -> new WallBlock(Block.Properties.create(Material.ROCK, MaterialColor.DIRT).sound(SoundType.STONE).hardnessAndResistance(1.5F, 4.0F)));

    public static final RegistryObject<Block> CRACKED_BRICKS = BLOCKS.register("cracked_bricks", () -> new Block(Block.Properties.create(Material.ROCK, MaterialColor.RED).sound(SoundType.STONE).hardnessAndResistance(2.0F, 4.0F)));
    public static final RegistryObject<Block> CRACKED_BRICK_SLAB = BLOCKS.register("cracked_brick_slab", () -> new SlabBlock(Block.Properties.create(Material.ROCK, MaterialColor.RED).sound(SoundType.STONE).hardnessAndResistance(2.0F, 4.0F)));
    public static final RegistryObject<Block> CRACKED_BRICK_STAIRS = BLOCKS.register("cracked_brick_stairs", () -> new StairsBlock(CRACKED_DIORITE.get()::getDefaultState, Block.Properties.create(Material.ROCK, MaterialColor.RED).sound(SoundType.STONE).hardnessAndResistance(2.0F, 4.0F)));
    public static final RegistryObject<Block> CRACKED_BRICK_WALL = BLOCKS.register("cracked_brick_wall", () -> new WallBlock(Block.Properties.create(Material.ROCK, MaterialColor.RED).sound(SoundType.STONE).hardnessAndResistance(2.0F, 4.0F)));

    public static final RegistryObject<Block> ANDESITE_BRICKS = BLOCKS.register("andesite_bricks", () -> new Block(Block.Properties.create(Material.ROCK, MaterialColor.STONE).sound(SoundType.STONE).hardnessAndResistance(1.5F, 6.0F)));
    public static final RegistryObject<Block> ANDESITE_BRICK_SLAB = BLOCKS.register("andesite_brick_slab", () -> new SlabBlock(Block.Properties.create(Material.ROCK, MaterialColor.STONE).sound(SoundType.STONE).hardnessAndResistance(1.5F, 6.0F)));
    public static final RegistryObject<Block> ANDESITE_BRICK_STAIRS = BLOCKS.register("andesite_brick_stairs", () -> new StairsBlock(ANDESITE_BRICKS.get()::getDefaultState, Block.Properties.create(Material.ROCK, MaterialColor.STONE).sound(SoundType.STONE).hardnessAndResistance(1.5F, 6.0F)));
    public static final RegistryObject<Block> ANDESITE_BRICK_WALL = BLOCKS.register("andesite_brick_wall", () -> new WallBlock(Block.Properties.create(Material.ROCK, MaterialColor.STONE).sound(SoundType.STONE).hardnessAndResistance(1.5F, 6.0F)));
    public static final RegistryObject<Block> ANDESITE_BRICK_PRESSURE_PLATE = BLOCKS.register("andesite_brick_pressure_plate", () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.MOBS, Block.Properties.create(Material.ROCK, MaterialColor.STONE).sound(SoundType.STONE).hardnessAndResistance(1.5F, 6.0F).doesNotBlockMovement()));
    public static final RegistryObject<Block> ANDESITE_BRICK_BUTTON = BLOCKS.register("andesite_brick_button", () -> new StoneButtonBlock(Block.Properties.create(Material.MISCELLANEOUS, MaterialColor.STONE).sound(SoundType.STONE).hardnessAndResistance(1.5F, 6.0F).doesNotBlockMovement()));

    public static final RegistryObject<Block> DIORITE_BRICKS = BLOCKS.register("diorite_bricks", () -> new Block(Block.Properties.create(Material.ROCK, MaterialColor.QUARTZ).hardnessAndResistance(1.5F, 6.0F)));
    public static final RegistryObject<Block> DIORITE_BRICK_SLAB = BLOCKS.register("diorite_brick_slab", () -> new SlabBlock(Block.Properties.create(Material.ROCK, MaterialColor.QUARTZ).sound(SoundType.STONE).hardnessAndResistance(1.5F, 6.0F)));
    public static final RegistryObject<Block> DIORITE_BRICK_STAIRS = BLOCKS.register("diorite_brick_stairs", () -> new StairsBlock(ANDESITE_BRICKS.get()::getDefaultState, Block.Properties.create(Material.ROCK, MaterialColor.QUARTZ).sound(SoundType.STONE).hardnessAndResistance(1.5F, 6.0F)));
    public static final RegistryObject<Block> DIORITE_BRICK_WALL = BLOCKS.register("diorite_brick_wall", () -> new WallBlock(Block.Properties.create(Material.ROCK, MaterialColor.QUARTZ).sound(SoundType.STONE).hardnessAndResistance(1.5F, 6.0F)));
    public static final RegistryObject<Block> DIORITE_BRICK_PRESSURE_PLATE = BLOCKS.register("diorite_brick_pressure_plate", () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.MOBS, Block.Properties.create(Material.ROCK, MaterialColor.QUARTZ).sound(SoundType.STONE).hardnessAndResistance(1.5F, 6.0F).doesNotBlockMovement()));
    public static final RegistryObject<Block> DIORITE_BRICK_BUTTON = BLOCKS.register("diorite_brick_button", () -> new StoneButtonBlock(Block.Properties.create(Material.MISCELLANEOUS, MaterialColor.QUARTZ).sound(SoundType.STONE).hardnessAndResistance(1.5F, 6.0F).doesNotBlockMovement()));

    public static final RegistryObject<Block> GRANITE_BRICKS = BLOCKS.register("granite_bricks", () -> new Block(Block.Properties.create(Material.ROCK, MaterialColor.DIRT).hardnessAndResistance(1.5F, 6.0F)));
    public static final RegistryObject<Block> GRANITE_BRICK_SLAB = BLOCKS.register("granite_brick_slab", () -> new SlabBlock(Block.Properties.create(Material.ROCK, MaterialColor.DIRT).sound(SoundType.STONE).hardnessAndResistance(1.5F, 6.0F)));
    public static final RegistryObject<Block> GRANITE_BRICK_STAIRS = BLOCKS.register("granite_brick_stairs", () -> new StairsBlock(ANDESITE_BRICKS.get()::getDefaultState, Block.Properties.create(Material.ROCK, MaterialColor.DIRT).sound(SoundType.STONE).hardnessAndResistance(1.5F, 6.0F)));
    public static final RegistryObject<Block> GRANITE_BRICK_WALL = BLOCKS.register("granite_brick_wall", () -> new WallBlock(Block.Properties.create(Material.ROCK, MaterialColor.DIRT).sound(SoundType.STONE).hardnessAndResistance(1.5F, 6.0F)));
    public static final RegistryObject<Block> GRANITE_BRICK_PRESSURE_PLATE = BLOCKS.register("granite_brick_pressure_plate", () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.MOBS, Block.Properties.create(Material.ROCK, MaterialColor.DIRT).sound(SoundType.STONE).hardnessAndResistance(1.5F, 6.0F).doesNotBlockMovement()));
    public static final RegistryObject<Block> GRANITE_BRICK_BUTTON = BLOCKS.register("granite_brick_button", () -> new StoneButtonBlock(Block.Properties.create(Material.MISCELLANEOUS, MaterialColor.DIRT).sound(SoundType.STONE).hardnessAndResistance(1.5F, 6.0F).doesNotBlockMovement()));

    public static final RegistryObject<Block> STONE_BRICK_DISPENSER = BLOCKS.register("stone_brick_dispenser", () -> new DispenserBlock(AbstractBlock.Properties.create(Material.ROCK).setRequiresTool().hardnessAndResistance(3.5F)));
    public static final RegistryObject<Block> COBBLESTONE_DISPENSER = BLOCKS.register("cobblestone_dispenser", () -> new DispenserBlock(AbstractBlock.Properties.from(STONE_BRICK_DISPENSER.get())));
    public static final RegistryObject<Block> BLACKSTONE_DISPENSER = BLOCKS.register("blackstone_dispenser", () -> new DispenserBlock(AbstractBlock.Properties.from(STONE_BRICK_DISPENSER.get())));

    public static final RegistryObject<Block> WEBBER_WEB = BLOCKS.register("webber_web", () -> new WebberWebBlock(Block.Properties.create(Material.WEB).doesNotBlockMovement().hardnessAndResistance(4.0F).tickRandomly()));
}
