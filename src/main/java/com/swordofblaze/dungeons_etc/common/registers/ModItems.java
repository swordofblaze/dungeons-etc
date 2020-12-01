package com.swordofblaze.dungeons_etc.common.registers;

import com.swordofblaze.dungeons_etc.common.items.ModItemGroup;
import com.swordofblaze.dungeons_etc.common.items.ModSpawnEggItem;
import com.swordofblaze.dungeons_etc.common.core.DungeonsEtc;
import com.swordofblaze.dungeons_etc.common.items.SpitterAcidItem;
import mcp.MethodsReturnNonnullByDefault;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemModelsProperties;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class ModItems {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, DungeonsEtc.MODID);


    public static final RegistryObject<Item> CRACKED_ANDESITE = registerBlockItem(ModBlocks.CRACKED_ANDESITE);
    public static final RegistryObject<Item> CRACKED_DIORITE = registerBlockItem(ModBlocks.CRACKED_DIORITE);
    public static final RegistryObject<Item> CRACKED_GRANITE = registerBlockItem(ModBlocks.CRACKED_GRANITE);
    public static final RegistryObject<Item> CRACKED_BRICKS = registerBlockItem(ModBlocks.CRACKED_BRICKS);
    public static final RegistryObject<Item> ANDESITE_BRICKS = registerBlockItem(ModBlocks.ANDESITE_BRICKS);
    public static final RegistryObject<Item> DIORITE_BRICKS = registerBlockItem(ModBlocks.DIORITE_BRICKS);
    public static final RegistryObject<Item> GRANITE_BRICKS = registerBlockItem(ModBlocks.GRANITE_BRICKS);

    public static final RegistryObject<Item> CRACKED_ANDESITE_SLAB = registerBlockItem(ModBlocks.CRACKED_ANDESITE_SLAB);
    public static final RegistryObject<Item> CRACKED_DIORITE_SLAB = registerBlockItem(ModBlocks.CRACKED_DIORITE_SLAB);
    public static final RegistryObject<Item> CRACKED_GRANITE_SLAB = registerBlockItem(ModBlocks.CRACKED_GRANITE_SLAB);
    public static final RegistryObject<Item> CRACKED_BRICK_SLAB = registerBlockItem(ModBlocks.CRACKED_BRICK_SLAB);
    public static final RegistryObject<Item> ANDESITE_BRICK_SLAB = registerBlockItem(ModBlocks.ANDESITE_BRICK_SLAB);
    public static final RegistryObject<Item> DIORITE_BRICK_SLAB = registerBlockItem(ModBlocks.DIORITE_BRICK_SLAB);
    public static final RegistryObject<Item> GRANITE_BRICK_SLAB = registerBlockItem(ModBlocks.GRANITE_BRICK_SLAB);

    public static final RegistryObject<Item> CRACKED_ANDESITE_STAIRS = registerBlockItem(ModBlocks.CRACKED_ANDESITE_STAIRS);
    public static final RegistryObject<Item> CRACKED_DIORITE_STAIRS = registerBlockItem(ModBlocks.CRACKED_DIORITE_STAIRS);
    public static final RegistryObject<Item> CRACKED_GRANITE_STAIRS = registerBlockItem(ModBlocks.CRACKED_GRANITE_STAIRS);
    public static final RegistryObject<Item> CRACKED_BRICK_STAIRS = registerBlockItem(ModBlocks.CRACKED_BRICK_STAIRS);
    public static final RegistryObject<Item> ANDESITE_BRICK_STAIRS = registerBlockItem(ModBlocks.ANDESITE_BRICK_STAIRS);
    public static final RegistryObject<Item> DIORITE_BRICK_STAIRS = registerBlockItem(ModBlocks.DIORITE_BRICK_STAIRS);
    public static final RegistryObject<Item> GRANITE_BRICK_STAIRS = registerBlockItem(ModBlocks.GRANITE_BRICK_STAIRS);

    public static final RegistryObject<Item> CRACKED_ANDESITE_WALL = registerBlockItem(ModBlocks.CRACKED_ANDESITE_WALL);
    public static final RegistryObject<Item> CRACKED_DIORITE_WALL = registerBlockItem(ModBlocks.CRACKED_DIORITE_WALL);
    public static final RegistryObject<Item> CRACKED_GRANITE_WALL = registerBlockItem(ModBlocks.CRACKED_GRANITE_WALL);
    public static final RegistryObject<Item> CRACKED_BRICK_WALL = registerBlockItem(ModBlocks.CRACKED_BRICK_WALL);
    public static final RegistryObject<Item> ANDESITE_BRICK_WALL = registerBlockItem(ModBlocks.ANDESITE_BRICK_WALL);
    public static final RegistryObject<Item> DIORITE_BRICK_WALL = registerBlockItem(ModBlocks.DIORITE_BRICK_WALL);
    public static final RegistryObject<Item> GRANITE_BRICK_WALL = registerBlockItem(ModBlocks.GRANITE_BRICK_WALL);

    public static final RegistryObject<Item> ANDESITE_BRICK_PRESSURE_PLATE = registerBlockItem(ModBlocks.ANDESITE_BRICK_PRESSURE_PLATE);
    public static final RegistryObject<Item> DIORITE_BRICK_PRESSURE_PLATE = registerBlockItem(ModBlocks.DIORITE_BRICK_PRESSURE_PLATE);
    public static final RegistryObject<Item> GRANITE_BRICK_PRESSURE_PLATE = registerBlockItem(ModBlocks.GRANITE_BRICK_PRESSURE_PLATE);

    public static final RegistryObject<Item> ANDESITE_BRICK_BUTTON = registerBlockItem(ModBlocks.ANDESITE_BRICK_BUTTON);
    public static final RegistryObject<Item> DIORITE_BRICK_BUTTON = registerBlockItem(ModBlocks.DIORITE_BRICK_BUTTON);
    public static final RegistryObject<Item> GRANITE_BRICK_BUTTON = registerBlockItem(ModBlocks.GRANITE_BRICK_BUTTON);

    public static final RegistryObject<Item> STONE_BRICK_DISPENSER = registerBlockItem(ModBlocks.STONE_BRICK_DISPENSER);
    public static final RegistryObject<Item> COBBLESTONE_DISPENSER = registerBlockItem(ModBlocks.COBBLESTONE_DISPENSER);
    public static final RegistryObject<Item> BLACKSTONE_DISPENSER = registerBlockItem(ModBlocks.BLACKSTONE_DISPENSER);

    public static final RegistryObject<Item> WEBBER_WEB = registerBlockItem(ModBlocks.WEBBER_WEB);

    public static final RegistryObject<Item> SPITTER_ACID = registerItem("spitter_acid", new SpitterAcidItem());

    public static final RegistryObject<Item> MAGGOT_SPAWN_EGG = registerItem("maggot_spawn_egg", new ModSpawnEggItem(ModEntities.MAGGOT, 0xAF9770, 0xA13920));
    public static final RegistryObject<Item> WEBBER_SPAWN_EGG = registerItem("webber_spawn_egg", new ModSpawnEggItem(ModEntities.WEBBER, 0xB80000, 0x282828));
    public static final RegistryObject<Item> SPITTER_SPAWN_EGG = registerItem("spitter_spawn_egg", new ModSpawnEggItem(ModEntities.SPITTER, 0x95AA47, 0x292722));


    private static RegistryObject<Item> registerBlockItem(RegistryObject<Block> blockSupplier) {
        return ITEMS.register(blockSupplier.getId().getPath(), () -> new BlockItem(blockSupplier.get(), new Item.Properties().group(ModItemGroup.MOD_ITEM_GROUP)));
    }

    /**
     * Registers a simple item using default item properties other
     * than being grouped in our creative tab.
     *
     * @param name The registry name of this item.
     */
    private static RegistryObject<Item> registerItem(String name) {
        return ITEMS.register(name, () -> new Item(new Item.Properties().group(ModItemGroup.MOD_ITEM_GROUP)));
    }

    /**
     * Registers a simple item with the given item properties.
     *
     * @param name The registry name of this item.
     * @param properties The item properties for this item.
     */
    private static RegistryObject<Item> registerItem(String name, Item.Properties properties) {
        return ITEMS.register(name, () -> new Item(properties.group(ModItemGroup.MOD_ITEM_GROUP)));
    }

    /**
     * Only used to prevent breaking patterns.
     */
    private static RegistryObject<Item> registerItem(String name, Item item) {
        return ITEMS.register(name, () -> item);
    }
}
