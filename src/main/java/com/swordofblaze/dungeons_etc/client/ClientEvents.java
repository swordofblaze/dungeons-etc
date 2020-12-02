package com.swordofblaze.dungeons_etc.client;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.platform.GlStateManager;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.swordofblaze.dungeons_etc.client.renderers.StressBarRenderer;
import com.swordofblaze.dungeons_etc.common.core.DungeonsEtc;
import com.swordofblaze.dungeons_etc.common.registers.ModEffects;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.player.ClientPlayerEntity;
import net.minecraft.client.gui.AbstractGui;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.LivingRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.vector.Vector3f;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderLivingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(value = Dist.CLIENT, modid = DungeonsEtc.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ClientEvents {

    private static final ResourceLocation MARK = DungeonsEtc.resourceLoc("textures/mob_effect/death_mark.png");
    private static final StressBarRenderer stressBarRenderer = new StressBarRenderer();

    // Rendering the Mark icon over marked entities
    @SubscribeEvent
    public static <T extends LivingEntity, M extends EntityModel<T>> void renderMarkIcon(RenderLivingEvent.Post<T, M> event) {

        if (event.getEntity().isPotionActive(ModEffects.DEATH_MARK.get())) {

            LivingEntity entity = event.getEntity();
            MatrixStack matrixStack = event.getMatrixStack();
            EntityRendererManager rendererManager = Minecraft.getInstance().getRenderManager();

            if (rendererManager.info.getRenderViewEntity().getDistanceSq(entity) <= 40.0D) {
                //DungeonsEtc.LOGGER.info("Should do mark icon render");
                float x = (float) entity.getPosX();
                float y = (float) entity.getPosY();
                float z = (float) entity.getPosZ();

                matrixStack.push();

                matrixStack.translate(entity.getPosX(), entity.getPosY() + entity.getHeight(), entity.getPosZ());
                matrixStack.scale(0.8f, 0.8f, 0.8f);
                matrixStack.rotate(rendererManager.getCameraOrientation());
                matrixStack.rotate(Vector3f.YP.rotationDegrees(180.0F));

                Minecraft.getInstance().getTextureManager().bindTexture(MARK);
                GlStateManager.enableBlend();
                GlStateManager.enableCull();

                IVertexBuilder vertexBuilder = event.getBuffers().getBuffer(RenderType.getCutout());

                vertexBuilder.addVertex(x, y, z, 1.0f, 1.0f, 1.0f, 1.0f, 1, 1, 0, 10, 3, 3, 3);
                vertexBuilder.addVertex(x, y, z, 1.0f, 1.0f, 1.0f, 1.0f, 1, 1, 0, 10, 3, 3, 3);
                vertexBuilder.addVertex(x, y, z, 1.0f, 1.0f, 1.0f, 1.0f, 1, 1, 0, 10, 3, 3, 3);
                vertexBuilder.addVertex(x, y, z, 1.0f, 1.0f, 1.0f, 1.0f, 1, 1, 0, 10, 3, 3, 3);

                Tessellator.getInstance().draw();

                matrixStack.pop();
            }
        }
    }

    @SubscribeEvent
    public static void renderStressMeter(RenderGameOverlayEvent.Post event) {
        ClientPlayerEntity player = Minecraft.getInstance().player;

        if (!player.isCreative() && !player.isSpectator() && event.getType() == RenderGameOverlayEvent.ElementType.EXPERIENCE) {
            stressBarRenderer.renderStressBar(player, event.getMatrixStack());
        }
    }
}
