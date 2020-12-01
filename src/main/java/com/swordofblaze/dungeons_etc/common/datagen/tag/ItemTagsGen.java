package com.swordofblaze.dungeons_etc.common.datagen.tag;

import com.swordofblaze.dungeons_etc.common.core.DungeonsEtc;
import net.minecraft.data.BlockTagsProvider;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.ItemTagsProvider;
import org.jetbrains.annotations.NotNull;

public class ItemTagsGen extends ItemTagsProvider {

    public ItemTagsGen(DataGenerator generator, BlockTagsProvider blockTagsProvider) {
        super(generator, blockTagsProvider);
    }

    @NotNull
    @Override
    public String getName() {
        return DungeonsEtc.NAME + ": " + "Item Type Tags";
    }

    @Override
    public void registerTags() {

    }
}
