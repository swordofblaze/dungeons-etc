package com.swordofblaze.dungeons_etc.common.datagen.tag;

import com.swordofblaze.dungeons_etc.common.core.DungeonsEtc;
import com.swordofblaze.dungeons_etc.common.registers.ModEntities;
import com.swordofblaze.dungeons_etc.common.tags.ModEntityTypeTags;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.EntityTypeTagsProvider;
import net.minecraft.entity.EntityType;
import org.jetbrains.annotations.NotNull;

public class EntityTypeTagGen extends EntityTypeTagsProvider {

    public EntityTypeTagGen(DataGenerator dataGenerator) {
        super(dataGenerator);
    }

    @NotNull
    @Override
    public String getName() {
        return DungeonsEtc.NAME + ": " + "Entity Type Tags";
    }

    @Override
    protected void registerTags() {
        this.getOrCreateBuilder(ModEntityTypeTags.HUMANS)
                .add(
                        EntityType.VILLAGER,
                        EntityType.WANDERING_TRADER,
                        EntityType.VINDICATOR,
                        EntityType.ILLUSIONER,
                        EntityType.PILLAGER,
                        EntityType.EVOKER
                );
        this.getOrCreateBuilder(ModEntityTypeTags.ELDRITCH)
                .add(
                        EntityType.ENDERMAN,
                        EntityType.ENDERMITE,
                        EntityType.GUARDIAN,
                        EntityType.ELDER_GUARDIAN
                );
        this.getOrCreateBuilder(ModEntityTypeTags.MARKED_HUNTERS)
                .add(
                        ModEntities.SPITTER.get()
                );
    }
}
