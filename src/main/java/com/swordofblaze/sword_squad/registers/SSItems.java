package com.swordofblaze.sword_squad.registers;

import com.swordofblaze.sword_squad.common.SSItemGroup;
import com.swordofblaze.sword_squad.core.SwordSquad;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class SSItems {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, SwordSquad.MODID);

    private static RegistryObject<Item> registerBlockItem(RegistryObject<Block> blockSupplier) {
        return ITEMS.register(blockSupplier.getId().getPath(), () -> new BlockItem(blockSupplier.get(), new Item.Properties().group(SSItemGroup.MOD_ITEM_GROUP)));
    }
}
