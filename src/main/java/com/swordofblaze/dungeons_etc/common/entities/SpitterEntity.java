package com.swordofblaze.dungeons_etc.common.entities;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.monster.SkeletonEntity;
import net.minecraft.entity.monster.SpiderEntity;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

public class SpitterEntity extends SpiderEntity {

    public SpitterEntity(EntityType<SpitterEntity> type, World worldIn) {
        super(type, worldIn);
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(4, new SpitterEntity.SpewAcidGoal(this));
    }

    public static AttributeModifierMap.MutableAttribute getAttributes() {
        return SpiderEntity.func_234305_eI_();
    }

    static class SpewAcidGoal extends Goal {
        private final SpitterEntity spitter;
        private final World world;
        private int timer;
        private final int maxTimer = (20 * 10); // 10 seconds
        private final double attackDistance = 128.0D;

        public SpewAcidGoal(SpitterEntity spitter) {
            this.spitter = spitter;
            this.world = spitter.getEntityWorld();
        }

        /**
         * Returns whether execution should begin. You can also read and cache any state necessary for execution in this
         * method as well.
         */
        public boolean shouldExecute() {
            return this.spitter.getAttackTarget() != null;
        }

        /**
         * Execute a one shot task or start executing a continuous task
         */
        public void startExecuting() {
            // Starts firing 2 seconds after targeting
            this.timer = (20 * 8);
        }

        /**
         * Reset the task's internal state. Called when this task is interrupted by another one
         */
        public void resetTask() {

        }

        /**
         * Keep ticking a continuous task that has already been started
         */
        public void tick() {
            final LivingEntity target = this.spitter.getAttackTarget();

            if (target != null && target.getDistanceSq(this.spitter) < attackDistance && this.spitter.canEntityBeSeen(target)) {

                if (this.timer >= maxTimer) {
                    AcidProjectileEntity acidProjectile = new AcidProjectileEntity(this.world, this.spitter);

                    double x = target.getPosX() - this.spitter.getPosX();
                    double y = target.getPosYHeight(0.33D) - acidProjectile.getPosY();
                    double z = target.getPosZ() - this.spitter.getPosZ();
                    double pitch = MathHelper.sqrt(x * x + z * z);

                    acidProjectile.shoot(x, y + (pitch * 0.2D), z, 1.5F, 0.5f);

                    this.world.addEntity(acidProjectile);
                    this.spitter.playSound(SoundEvents.ENTITY_SNOWBALL_THROW,0.5f, 1.0f);

                    this.timer = 0;
                } else {
                    ++this.timer;
                }
            }
        }
    }
}
