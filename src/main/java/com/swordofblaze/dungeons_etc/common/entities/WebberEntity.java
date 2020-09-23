package com.swordofblaze.dungeons_etc.common.entities;

import com.swordofblaze.dungeons_etc.common.core.DungeonsEtc;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.monster.SpiderEntity;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.Difficulty;
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

    public static AttributeModifierMap.MutableAttribute getAttributes() {
        return SpiderEntity.func_234305_eI_();
    }

    @Override
    public boolean attackEntityAsMob(Entity entity) {
        if (super.attackEntityAsMob(entity)) {
            if (entity instanceof LivingEntity) {
                Difficulty difficulty = this.world.getDifficulty();
                int effectDuration = difficulty == Difficulty.HARD ? 9 : (difficulty == Difficulty.NORMAL ? 7 : 5);
                ((LivingEntity)entity).addPotionEffect(new EffectInstance(Effects.POISON, effectDuration * 20, 0));
            }
            return true;
        }
        return false;
    }

    static class ShootWebGoal extends Goal {
        private final WebberEntity webber;
        private final World world;
        private int timer;
        private final int maxTimer = (20 * 10); // 10 seconds
        private final double attackDistance = 128.0D;

        public ShootWebGoal(WebberEntity webber) {
            this.webber = webber;
            this.world = webber.getEntityWorld();
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
            final LivingEntity target = this.webber.getAttackTarget();

            if (target != null && target.getDistanceSq(this.webber) < attackDistance && this.webber.canEntityBeSeen(target)) {

                if (this.timer >= maxTimer) {
                    WebProjectileEntity webProjectile = new WebProjectileEntity(this.webber, this.world);

                    double x = target.getPosX() - this.webber.getPosX();
                    double y = target.getPosYHeight(0.33D) - webProjectile.getPosY();
                    double z = target.getPosZ() - this.webber.getPosZ();
                    double pitch = MathHelper.sqrt(x * x + z * z);

                    webProjectile.shoot(x, y + (pitch * 0.2D), z, 1.5F, 0.5f);
                    this.world.addEntity(webProjectile);

                    this.webber.playSound(SoundEvents.ENTITY_SNOWBALL_THROW,0.5f, 1.0f);

                    this.timer = 0;
                } else {
                    ++this.timer;
                }
            }
        }
    }
}
