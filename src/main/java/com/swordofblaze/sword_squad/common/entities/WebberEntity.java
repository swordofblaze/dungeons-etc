package com.swordofblaze.sword_squad.common.entities;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.monster.SpiderEntity;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class WebberEntity extends SpiderEntity {

    public WebberEntity(EntityType<WebberEntity> type, World world) {
        super(type, world);
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(4, new ShootWebGoal(this));
    }

    static class ShootWebGoal extends Goal {
        private final WebberEntity webber;
        private int timer;
        // 10 seconds
        private final int maxTimer = (20 * 10);

        public ShootWebGoal(WebberEntity webber) {
            this.webber = webber;
        }

        /**
         * Returns whether execution should begin. You can also read and cache any state necessary for execution in this
         * method as well.
         */
        public boolean shouldExecute() {
            return this.webber.getAttackTarget() != null;
        }

        /**
         * Execute a one shot task or start executing a continuous task
         */
        public void startExecuting() {
            // Starts firing 2 seconds after targeting
            this.timer = (20 * 2);
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
            final double attackDistance = 16.0D;
            final LivingEntity target = this.webber.getAttackTarget();

            if (target != null && target.getDistanceSq(this.webber) < attackDistance && this.webber.canEntityBeSeen(target)) {
                World world = this.webber.getEntityWorld();

                if (this.timer >= maxTimer) {
                    world.playSound(this.webber.getPosX(), this.webber.getPosY() + 0.4d, this.webber.getPosZ(), SoundEvents.ENTITY_SNOWBALL_THROW, SoundCategory.HOSTILE, 0.5f, 1.0f, false);

                    WebProjectileEntity webProjectile = new WebProjectileEntity(this.webber, world);
                    Vec3d vec3d = this.webber.getLook(1.0F);
                    webProjectile.setPosition(this.webber.getPosX() + vec3d.x * 1.6D, this.webber.getPosY() + 0.4D, this.webber.getPosZ() + vec3d.z * 1.6D);
                    webProjectile.shoot(target, target.rotationPitch, target.rotationYaw, 0.0F, 1.5F, 1.0F);
                    world.addEntity(webProjectile);

                    this.timer = 0;
                } else {
                    ++this.timer;
                }
            }
        }
    }
}
