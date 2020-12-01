package com.swordofblaze.dungeons_etc.client.renderers.entity;

import com.swordofblaze.dungeons_etc.client.models.MaggotModel;
import com.swordofblaze.dungeons_etc.common.core.DungeonsEtc;
import com.swordofblaze.dungeons_etc.common.entities.MaggotEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class MaggotRenderer extends MobRenderer<MaggotEntity, MaggotModel<MaggotEntity>> {

    private static final ResourceLocation TEXTURE = DungeonsEtc.resourceLoc("textures/entity/living/maggot.png");

    public MaggotRenderer(EntityRendererManager renderManager) {
        super(renderManager, new MaggotModel<>(), 0.2f);
    }

    @Override
    public ResourceLocation getEntityTexture(MaggotEntity entity) {
        return TEXTURE;
    }
}
