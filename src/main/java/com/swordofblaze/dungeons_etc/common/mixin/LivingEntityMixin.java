package com.swordofblaze.dungeons_etc.common.mixin;

import com.swordofblaze.dungeons_etc.common.registers.ModEffects;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.potion.Effect;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin extends Entity {

    public LivingEntityMixin(EntityType<?> entityTypeIn, World worldIn) {
        super(entityTypeIn, worldIn);
    }

    @Shadow
    public boolean isJumping;

    @Shadow
    public float moveForward;

    @Shadow
    public abstract boolean isPotionActive(Effect potionIn);


    @Inject(method = "isMovementBlocked", at = @At("HEAD"), cancellable = true)
    protected void onIsMovementBlocked(CallbackInfoReturnable<Boolean> callbackInfo) {

        if (this.isPotionActive(ModEffects.STUN.get())) {
            this.isJumping = false;
            this.moveForward = 0.0f;
        }
    }
}
