package com.swordofblaze.dungeons_etc.common.entities;

import com.swordofblaze.dungeons_etc.common.registers.ModEffects;
import com.swordofblaze.dungeons_etc.common.registers.ModEntities;
import com.swordofblaze.dungeons_etc.common.registers.ModItems;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.ProjectileItemEntity;
import net.minecraft.item.Item;
import net.minecraft.network.IPacket;
import net.minecraft.potion.EffectInstance;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.EntityRayTraceResult;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.event.ForgeEventFactory;
import net.minecraftforge.fml.network.NetworkHooks;

public class AcidProjectileEntity extends ProjectileItemEntity {

    public AcidProjectileEntity(EntityType<AcidProjectileEntity> type, World worldIn) {
        super(type, worldIn);
    }

    public AcidProjectileEntity(World worldIn, LivingEntity throwerIn) {
        super(ModEntities.ACID_PROJECTILE.get(), throwerIn, worldIn);
    }

    @Override
    public float getGravityVelocity() {
        return 0.06F;
    }

    @Override
    public void onImpact(RayTraceResult result) {
        if (!ForgeEventFactory.onProjectileImpact(this, result)) {

            if (result.getType() == RayTraceResult.Type.ENTITY) {
                Entity entity = ((EntityRayTraceResult)result).getEntity();

                if (entity instanceof LivingEntity) {                                         // Thrower
                    entity.attackEntityFrom(DamageSource.causeThrownDamage(this, this.func_234616_v_()), 10.0f);
                    ((LivingEntity) entity).addPotionEffect(new EffectInstance(ModEffects.BLIGHT.get(), 20 * 15, 2));
                }
            }
        }
        this.remove();
    }

    @Override
    protected Item getDefaultItem() {
        return ModItems.SPITTER_ACID.get();
    }

    @Override
    public IPacket<?> createSpawnPacket() {
        return NetworkHooks.getEntitySpawningPacket(this);
    }
}
