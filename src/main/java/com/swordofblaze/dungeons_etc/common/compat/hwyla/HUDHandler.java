package com.swordofblaze.dungeons_etc.common.compat.hwyla;

import com.swordofblaze.dungeons_etc.common.registers.ModBlocks;
import com.swordofblaze.dungeons_etc.common.util.CapabilityHelper;
import mcp.mobius.waila.api.*;
import net.minecraft.block.Blocks;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;

import java.util.List;

public class HUDHandler implements IComponentProvider, IEntityComponentProvider {

    protected static final HUDHandler INSTANCE = new HUDHandler();

    @Override
    public ItemStack getStack(IDataAccessor accessor, IPluginConfig config) {
        if (config.get(ModHwylaPlugin.OBFUSCATE_TRAPS_CONFIG)) {
            if (accessor.getBlock() == ModBlocks.COBBLESTONE_DISPENSER.get())
                return new ItemStack(Blocks.COBBLESTONE);

            if (accessor.getBlock() == ModBlocks.BLACKSTONE_DISPENSER.get())
                return new ItemStack(Blocks.BLACKSTONE);

            if (accessor.getBlock() == ModBlocks.STONE_BRICK_DISPENSER.get())
                return new ItemStack(Blocks.STONE_BRICKS);
        }
        return ItemStack.EMPTY;
    }

    @Override
    public void appendBody(List<ITextComponent> tooltip, IDataAccessor accessor, IPluginConfig config) {

    }

    @Override
    public void appendBody(List<ITextComponent> tooltip, IEntityAccessor accessor, IPluginConfig config) {
        if (config.get(ModHwylaPlugin.SHOW_PLAYER_STRESS)) {

            if (accessor.getEntity() instanceof PlayerEntity) {
                int stress = CapabilityHelper.getPlayerStress((PlayerEntity) accessor.getEntity());
                tooltip.add(new TranslationTextComponent(TooltipReferences.TOOLTIP_STRESS, String.valueOf(stress)));
            }
        }
    }
}
