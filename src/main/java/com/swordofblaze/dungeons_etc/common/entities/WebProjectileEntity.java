package com.swordofblaze.dungeons_etc.common.entities;

import com.swordofblaze.dungeons_etc.common.registers.ModBlocks;
import com.swordofblaze.dungeons_etc.common.registers.ModEntities;
import com.swordofblaze.dungeons_etc.common.registers.ModItems;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.ProjectileItemEntity;
import net.minecraft.item.Item;
import net.minecraft.network.IPacket;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.EntityRayTraceResult;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.event.ForgeEventFactory;
import net.minecraftforge.fml.network.NetworkHooks;

public class WebProjectileEntity extends ProjectileItemEntity {

    public WebProjectileEntity(EntityType<WebProjectileEntity> type, World world) {
        super(type, world);
    }

    public WebProjectileEntity(LivingEntity entity, World world) {
        super(ModEntities.WEB_PROJECTILE.get(), entity, world);
    }

    public WebProjectileEntity(double x, double y, double z, World world) {
        super(ModEntities.WEB_PROJECTILE.get(), x, y, z, world);
    }

    public float getGravityVelocity() {
        return 0.05F;
    }

    @Override
    public Item getDefaultItem() {
        return ModItems.WEBBER_WEB.get();
    }

    @Override
    public void onImpact(RayTraceResult result) {
        if (!ForgeEventFactory.onProjectileImpact(this, result)) {

            if (result.getType() == RayTraceResult.Type.ENTITY) {
                Entity entity = ((EntityRayTraceResult)result).getEntity();

                if (entity instanceof LivingEntity) {                                         // Thrower
                    entity.attackEntityFrom(DamageSource.causeThrownDamage(this, this.func_234616_v_()), 2.0f);
                    if (!world.isRemote && !world.getBlockState(this.getPosition()).isSolid())
                        world.setBlockState(entity.getPosition(), ModBlocks.WEBBER_WEB.get().getDefaultState());
                }
            }
            else if (result.getType() == RayTraceResult.Type.BLOCK) {

                if (!world.isRemote && !world.getBlockState(this.getPosition()).isSolid())
                    world.setBlockState(this.getPosition(), ModBlocks.WEBBER_WEB.get().getDefaultState());
            }
        }
        this.remove();
    }

    @Override
    public IPacket<?> createSpawnPacket() {
        return NetworkHooks.getEntitySpawningPacket(this);
    }
}
