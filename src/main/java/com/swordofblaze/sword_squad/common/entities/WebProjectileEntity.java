package com.swordofblaze.sword_squad.common.entities;

import com.swordofblaze.sword_squad.registers.SSEntities;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.ProjectileItemEntity;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.network.IPacket;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;

public class WebProjectileEntity extends ProjectileItemEntity {

    public WebProjectileEntity(EntityType<WebProjectileEntity> type, World world) {
        super(type, world);
    }

    public WebProjectileEntity(LivingEntity entity, World world) {
        super(SSEntities.WEB_PROJECTILE.get(), entity, world);
    }

    public WebProjectileEntity(double x, double y, double z, World world) {
        super(SSEntities.WEB_PROJECTILE.get(), x, y, z, world);
    }

    @Override
    public Item getDefaultItem() {
        return Items.COBWEB;
    }

    @Override
    public void onImpact(RayTraceResult result) {
        if (result.getType() != RayTraceResult.Type.MISS) {
            if (!world.getBlockState(this.getPosition()).isSolid()) {
                world.setBlockState(this.getPosition(), Blocks.COBWEB.getDefaultState());
            }
        }
        this.remove();
    }

    @Override
    public IPacket<?> createSpawnPacket() {
        return NetworkHooks.getEntitySpawningPacket(this);
    }
}
