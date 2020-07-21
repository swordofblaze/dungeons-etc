package com.swordofblaze.sword_squad.common;

import com.swordofblaze.sword_squad.core.SwordSquad;
import net.minecraft.util.ResourceLocation;

public class ModResourceLocation extends ResourceLocation {

    public ModResourceLocation(String path) {
        super(SwordSquad.MODID, path);
    }
}
