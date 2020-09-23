package com.swordofblaze.dungeons_etc.client.renderers;

import com.swordofblaze.dungeons_etc.common.entities.WebberEntity;
import com.swordofblaze.dungeons_etc.common.core.DungeonsEtc;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.model.SpiderModel;
import net.minecraft.util.ResourceLocation;

public class WebberRenderer<T extends WebberEntity> extends MobRenderer<T, SpiderModel<T>> {

    private static final ResourceLocation TEXTURE = DungeonsEtc.resourceLoc("textures/entity/webber.png");

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
