package com.swordofblaze.dungeons_etc.common.tags;

import com.swordofblaze.dungeons_etc.common.core.DungeonsEtc;
import net.minecraft.entity.EntityType;
import net.minecraft.tags.EntityTypeTags;
import net.minecraft.tags.ITag;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagRegistry;

public class ModEntityTypeTags {

    public static final ITag.INamedTag<EntityType<?>> HUMANS = forgeTag("humans");
    public static final ITag.INamedTag<EntityType<?>> ELDRITCH = forgeTag("eldritch");
    public static final ITag.INamedTag<EntityType<?>> BEAST = forgeTag("beast");
    public static final ITag.INamedTag<EntityType<?>> MARKED_HUNTERS = forgeTag("marked_hunters");

    private static ITag.INamedTag<EntityType<?>> forgeTag(String name) {
        return EntityTypeTags.func_232896_a_("forge:" + name);
    }

    private static ITag.INamedTag<EntityType<?>> modTag(String name) {
        return EntityTypeTags.func_232896_a_(DungeonsEtc.resourceLoc(name).toString());
    }
}
