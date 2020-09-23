package com.swordofblaze.dungeons_etc.common.datagen.tag;

import com.swordofblaze.dungeons_etc.common.core.DungeonsEtc;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.EntityTypeTagsProvider;

public class EntityTypeTagGen extends EntityTypeTagsProvider {

    public EntityTypeTagGen(DataGenerator dataGenerator) {
        super(dataGenerator);
    }

    @Override
    public String getName() {
        return DungeonsEtc.MODID + ":" + "Entity Type Tags";
    }

    @Override
    protected void registerTags() {
    }
}
