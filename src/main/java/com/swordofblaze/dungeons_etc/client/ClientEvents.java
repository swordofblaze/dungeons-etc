package com.swordofblaze.dungeons_etc.client;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.platform.GlStateManager;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.swordofblaze.dungeons_etc.common.core.DungeonsEtc;
import com.swordofblaze.dungeons_etc.common.registers.ModEffects;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.LivingRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.entity.LivingEntity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RenderLivingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(value = Dist.CLIENT, modid = DungeonsEtc.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ClientEvents {

    @SubscribeEvent
    public static <T extends LivingEntity, M extends EntityModel<T>> void onLivingRender(RenderLivingEvent.Pre<T, M> event) {

        if (event.getEntity().isPotionActive(ModEffects.DEATH_MARK.get())) {
            LivingRenderer<T, M> renderer = event.getRenderer();
            EntityModel<T> entityModel = renderer.getEntityModel();
            T entity = (T) event.getEntity();

            IVertexBuilder vertexBuilder = event.getBuffers().getBuffer(RenderType.getOutline(renderer.getEntityTexture(entity)));

            entityModel.render(event.getMatrixStack(), vertexBuilder, event.getLight(), 0, 1.0f, 1.0f, 1.0f, 0.15F);
        }
    }
}
