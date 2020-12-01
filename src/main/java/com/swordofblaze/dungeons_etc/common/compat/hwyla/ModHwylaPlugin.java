package com.swordofblaze.dungeons_etc.common.compat.hwyla;

import com.swordofblaze.dungeons_etc.common.core.DungeonsEtc;
import mcp.mobius.waila.api.*;
import net.minecraft.block.DispenserBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ResourceLocation;

@WailaPlugin
public class ModHwylaPlugin implements IWailaPlugin {

    protected static final ResourceLocation OBFUSCATE_TRAPS_CONFIG = DungeonsEtc.resourceLoc("obfuscate_traps");
    protected static final ResourceLocation SHOW_PLAYER_STRESS = DungeonsEtc.resourceLoc("show_player_stress");

    @Override
    public void register(IRegistrar registrar) {
        registrar.addSyncedConfig(OBFUSCATE_TRAPS_CONFIG, true);
        registrar.addConfig(SHOW_PLAYER_STRESS, true);

        registrar.registerStackProvider(HUDHandler.INSTANCE, DispenserBlock.class);
        registrar.registerComponentProvider((IEntityComponentProvider) HUDHandler.INSTANCE, TooltipPosition.BODY, PlayerEntity.class);
    }
}
