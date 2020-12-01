package com.swordofblaze.dungeons_etc.client.renderers.entity;

import com.swordofblaze.dungeons_etc.common.core.DungeonsEtc;
import com.swordofblaze.dungeons_etc.common.entities.SpitterEntity;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.IEntityRenderer;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.layers.AbstractEyesLayer;
import net.minecraft.client.renderer.entity.model.SpiderModel;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class SpitterRenderer <T extends SpitterEntity> extends MobRenderer<T, SpiderModel<T>> {

    private static final ResourceLocation TEXTURE = DungeonsEtc.resourceLoc("textures/entity/living/spitter_spider.png");

    public SpitterRenderer(EntityRendererManager renderManager) {
        super(renderManager, new SpiderModel<>(), 0.8F);
        this.addLayer(new EyesLayer<>(this));
    }

    @Override
    public float getDeathMaxRotation(T entity) {
        return 180.0F;
    }

    @Override
    public ResourceLocation getEntityTexture(SpitterEntity entity) {
        return TEXTURE;
    }

    protected static class EyesLayer <T extends Entity, M extends SpiderModel<T>> extends AbstractEyesLayer<T, M> {

        private static final RenderType EYES = RenderType.getEyes(DungeonsEtc.resourceLoc("textures/entity/living/spitter_spider_eyes.png"));

        public EyesLayer(IEntityRenderer<T, M> entityRenderer) {
            super(entityRenderer);
        }

        @Override
        public RenderType getRenderType() {
            return EYES;
        }
    }
}
