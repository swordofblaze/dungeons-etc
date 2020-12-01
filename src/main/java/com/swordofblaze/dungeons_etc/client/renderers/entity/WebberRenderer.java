package com.swordofblaze.dungeons_etc.client.renderers.entity;

import com.swordofblaze.dungeons_etc.common.core.DungeonsEtc;
import com.swordofblaze.dungeons_etc.common.entities.WebberEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.model.SpiderModel;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class WebberRenderer<T extends WebberEntity> extends MobRenderer<T, SpiderModel<T>> {

    private static final ResourceLocation TEXTURE = DungeonsEtc.resourceLoc("textures/entity/living/webber.png");

    public WebberRenderer(EntityRendererManager renderManager) {
        super(renderManager, new SpiderModel<>(), 0.8F);
    }

    @Override
    public float getDeathMaxRotation(T entity) {
        return 180.0F;
    }

    @Override
    public ResourceLocation getEntityTexture(WebberEntity entity) {
        return TEXTURE;
    }
}
