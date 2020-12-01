package com.swordofblaze.dungeons_etc.common.items;

import com.swordofblaze.dungeons_etc.common.entities.AcidProjectileEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ShearsItem;
import net.minecraft.stats.Stats;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.world.World;

public class SpitterAcidItem extends Item {

    public SpitterAcidItem() {
        super(new Item.Properties().group(ModItemGroup.MOD_ITEM_GROUP).maxStackSize(16));
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity player, Hand hand) {
        ItemStack itemStack = player.getHeldItem(hand);

        world.playSound(null, player.getPosX(), player.getPosY(), player.getPosZ(), SoundEvents.ENTITY_SNOWBALL_THROW, SoundCategory.NEUTRAL, 0.5F, 0.4F / (random.nextFloat() * 0.4F + 0.8F));

        if (!world.isRemote) {
            AcidProjectileEntity projectile = new AcidProjectileEntity(world, player);
            projectile.setItem(itemStack);
            projectile.func_234612_a_(player, player.rotationPitch, player.rotationYaw, 0.0F, 1.5F, 1.0F);
            world.addEntity(projectile);
        }
        player.addStat(Stats.ITEM_USED.get(this));

        if (!player.abilities.isCreativeMode) {
            itemStack.shrink(1);
        }
        return ActionResult.func_233538_a_(itemStack, world.isRemote());
    }
}
