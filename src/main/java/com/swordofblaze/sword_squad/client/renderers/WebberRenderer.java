package com.swordofblaze.sword_squad.client.renderers;

import com.swordofblaze.sword_squad.common.ModResourceLocation;
import com.swordofblaze.sword_squad.common.entities.WebberEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.SpiderRenderer;
import net.minecraft.util.ResourceLocation;

public class WebberRenderer extends SpiderRenderer<WebberEntity> {

    private static final ModResourceLocation TEXTURE = new ModResourceLocation("textures/entity/webber.png");

    public WebberRenderer(EntityRendererManager renderManagerIn) {
        super(renderManagerIn);
    }

    @Override
    public ResourceLocation getEntityTexture(WebberEntity entity) {
        return TEXTURE;
    }
}
