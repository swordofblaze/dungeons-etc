package com.swordofblaze.dungeons_etc.common.items;

import com.swordofblaze.dungeons_etc.common.core.DungeonsEtc;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;

import java.util.function.Supplier;

public class ModItemGroup {

    public static final ItemGroup MOD_ITEM_GROUP = new ModGroup(DungeonsEtc.MODID, () -> new ItemStack(Items.IRON_SWORD));

    public static class ModGroup extends ItemGroup {

        private final Supplier<ItemStack> icon;

        public ModGroup(final String name, final Supplier<ItemStack> icon) {
            super(name);
            this.icon = icon;
        }

        @Override
        public ItemStack createIcon() {
            return this.icon.get();
        }
    }
}
