package com.swordofblaze.dungeons_etc.client.renderers;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.swordofblaze.dungeons_etc.common.capability.Capabilities;
import com.swordofblaze.dungeons_etc.common.capability.stress.DefaultStressCapability;
import com.swordofblaze.dungeons_etc.common.core.DungeonsEtc;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.player.ClientPlayerEntity;
import net.minecraft.client.gui.AbstractGui;
import net.minecraft.util.ResourceLocation;

public class StressBarRenderer extends AbstractGui {

    private final int x = 70;
    private final int y = 210;
    private final int barLength = 90;

    private static final ResourceLocation TEXTURE = DungeonsEtc.resourceLoc("textures/gui/widget/stress_meter.png");
    private final Minecraft minecraft = Minecraft.getInstance();

    public void renderStressBar(ClientPlayerEntity playerEntity, MatrixStack stack) {
        minecraft.getTextureManager().bindTexture(TEXTURE);

        renderBarBody(stack, x, y);
        renderBarContent(stack, x, y, getStress(playerEntity));
    }

    /**
     * Renders the "outline" of the meter.
     */
    private void renderBarBody(MatrixStack matrixStack, int x, int y) {
       this.blit(matrixStack, x, y, 0, 0, barLength, 5);
    }

    /**
     * Renders the dynamic content of the meter.
     */
    private void renderBarContent(MatrixStack matrixStack, int x, int y, int stressAmount) {
        this.blit(matrixStack, x, y, 0, 5, (int) Math.floor(((double) barLength / DefaultStressCapability.maxStress()) * stressAmount), 8);
    }

    @SuppressWarnings("all")
    private int getStress(ClientPlayerEntity playerEntity) {
        return playerEntity.getCapability(Capabilities.STRESS_CAPABILITY).orElse(Capabilities.STRESS_CAPABILITY.getDefaultInstance()).getStress();
    }
}
