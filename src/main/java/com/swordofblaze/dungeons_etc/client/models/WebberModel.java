package com.swordofblaze.dungeons_etc.client.models;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

/**
 * SpiderWebber - Either Mojang or a mod author (Taken From Memory)
 * Created using Tabula 8.0.0
 */
@OnlyIn(Dist.CLIENT)
public class WebberModel<T extends Entity> extends EntityModel<T> {

    public ModelRenderer body;
    public ModelRenderer abdomen;
    public ModelRenderer head;
    public ModelRenderer leg1;
    public ModelRenderer leg2;
    public ModelRenderer leg3;
    public ModelRenderer leg4;
    public ModelRenderer leg5;
    public ModelRenderer leg6;
    public ModelRenderer leg7;
    public ModelRenderer leg8;

    public WebberModel() {
        this.textureWidth = 64;
        this.textureHeight = 32;
      
        this.head = new ModelRenderer(this, 32, 4);
        this.head.setRotationPoint(0.0F, 0.0F, -3.0F);
        this.head.addBox(-4.0F, -4.0F, -8.0F, 8.0F, 8.0F, 8.0F, 0.0F, 0.0F, 0.0F);
     
        this.body = new ModelRenderer(this, 0, 0);
        this.body.setRotationPoint(0.0F, 15.0F, 0.0F);
        this.body.addBox(-3.0F, -3.0F, -3.0F, 6.0F, 6.0F, 6.0F, 0.0F, 0.0F, 0.0F);
     
        this.leg1 = new ModelRenderer(this, 18, 0);
        this.leg1.setRotationPoint(-4.0F, 0.0F, 2.0F);
        this.leg1.addBox(-15.0F, -1.0F, -1.0F, 16.0F, 2.0F, 2.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(leg1, 0.0F, 0.7853981633974483F, -0.7853981633974483F);
    
        this.leg3 = new ModelRenderer(this, 18, 0);
        this.leg3.setRotationPoint(-4.0F, 0.0F, 0.0F);
        this.leg3.addBox(-15.0F, -1.0F, -1.0F, 16.0F, 2.0F, 2.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(leg3, 0.0F, -0.39269908169872414F, -0.5811946275983063F);
     
        this.leg5 = new ModelRenderer(this, 18, 0);
        this.leg5.setRotationPoint(4.0F, 0.0F, 2.0F);
        this.leg5.addBox(-1.0F, -1.0F, -1.0F, 16.0F, 2.0F, 2.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(leg5, 0.0F, -0.7853981633974483F, 0.7853981633974483F);
     
        this.abdomen = new ModelRenderer(this, 0, 12);
        this.abdomen.setRotationPoint(0.0F, 0.0F, 2.0F);
        this.abdomen.addBox(-5.0F, -4.0F, 0.0F, 10.0F, 8.0F, 12.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(abdomen, 0.3127630032889644F, 0.0F, 0.0F);
     
        this.leg6 = new ModelRenderer(this, 18, 0);
        this.leg6.setRotationPoint(4.0F, 0.0F, 1.0F);
        this.leg6.addBox(-1.0F, -1.0F, -1.0F, 16.0F, 2.0F, 2.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(leg6, 0.0F, -0.39269908169872414F, 0.5811946275983063F);
     
        this.leg4 = new ModelRenderer(this, 18, 0);
        this.leg4.setRotationPoint(-4.0F, 0.0F, -1.0F);
        this.leg4.addBox(-15.0F, -1.0F, -1.0F, 16.0F, 2.0F, 2.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(leg4, 0.0F, -0.7853981633974483F, -0.7853981633974483F);
      
        this.leg8 = new ModelRenderer(this, 18, 0);
        this.leg8.setRotationPoint(4.0F, 0.0F, -1.0F);
        this.leg8.addBox(-1.0F, -1.0F, -1.0F, 16.0F, 2.0F, 2.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(leg8, 0.0F, 0.7853981633974483F, 0.7853981633974483F);
       
        this.leg2 = new ModelRenderer(this, 18, 0);
        this.leg2.setRotationPoint(-4.0F, 0.0F, 1.0F);
        this.leg2.addBox(-15.0F, -1.0F, -1.0F, 16.0F, 2.0F, 2.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(leg2, 0.0F, 0.39269908169872414F, -0.5811946275983063F);
       
        this.leg7 = new ModelRenderer(this, 18, 0);
        this.leg7.setRotationPoint(4.0F, 0.0F, 0.0F);
        this.leg7.addBox(-1.0F, -1.0F, -1.0F, 16.0F, 2.0F, 2.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(leg7, 0.0F, 0.39269908169872414F, 0.5811946275983063F);

        this.body.addChild(this.head);
        this.body.addChild(this.leg1);
        this.body.addChild(this.leg3);
        this.body.addChild(this.leg5);
        this.body.addChild(this.abdomen);
        this.body.addChild(this.leg6);
        this.body.addChild(this.leg4);
        this.body.addChild(this.leg8);
        this.body.addChild(this.leg2);
        this.body.addChild(this.leg7);
    }

    @Override
    public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float headYaw, float headPitch) {
        // Borrowed from SpiderModel
        this.head.rotateAngleY = headYaw * ((float)Math.PI / 180F);
        this.head.rotateAngleX = headPitch * ((float)Math.PI / 180F);

        this.leg1.rotateAngleZ = (-(float)Math.PI / 4F);
        this.leg2.rotateAngleZ = (-(float)Math.PI / 4F);
        this.leg3.rotateAngleZ = -0.58119464F;
        this.leg4.rotateAngleZ = -0.58119464F;
        this.leg5.rotateAngleZ = 0.58119464F;
        this.leg6.rotateAngleZ = 0.58119464F;
        this.leg7.rotateAngleZ = ((float)Math.PI / 4F);
        this.leg8.rotateAngleZ = ((float)Math.PI / 4F);

        this.leg1.rotateAngleY = ((float)Math.PI / 4F);
        this.leg2.rotateAngleY = (-(float)Math.PI / 4F);
        this.leg3.rotateAngleY = ((float)Math.PI / 8F);
        this.leg4.rotateAngleY = (-(float)Math.PI / 8F);
        this.leg5.rotateAngleY = (-(float)Math.PI / 8F);
        this.leg6.rotateAngleY = ((float)Math.PI / 8F);
        this.leg7.rotateAngleY = (-(float)Math.PI / 4F);
        this.leg8.rotateAngleY = ((float)Math.PI / 4F);

        float f3 = -(MathHelper.cos(limbSwing * 0.6662F * 2.0F + 0.0F) * 0.4F) * limbSwingAmount;
        float f4 = -(MathHelper.cos(limbSwing * 0.6662F * 2.0F + (float)Math.PI) * 0.4F) * limbSwingAmount;
        float f5 = -(MathHelper.cos(limbSwing * 0.6662F * 2.0F + ((float)Math.PI / 2F)) * 0.4F) * limbSwingAmount;
        float f6 = -(MathHelper.cos(limbSwing * 0.6662F * 2.0F + ((float)Math.PI * 1.5F)) * 0.4F) * limbSwingAmount;
        float f7 = Math.abs(MathHelper.sin(limbSwing * 0.6662F + 0.0F) * 0.4F) * limbSwingAmount;
        float f8 = Math.abs(MathHelper.sin(limbSwing * 0.6662F + (float)Math.PI) * 0.4F) * limbSwingAmount;
        float f9 = Math.abs(MathHelper.sin(limbSwing * 0.6662F + ((float)Math.PI / 2F)) * 0.4F) * limbSwingAmount;
        float f10 = Math.abs(MathHelper.sin(limbSwing * 0.6662F + ((float)Math.PI * 1.5F)) * 0.4F) * limbSwingAmount;

        this.leg1.rotateAngleY += f3;
        this.leg2.rotateAngleY += -f3;
        this.leg3.rotateAngleY += f4;
        this.leg4.rotateAngleY += -f4;
        this.leg5.rotateAngleY += f5;
        this.leg6.rotateAngleY += -f5;
        this.leg7.rotateAngleY += f6;
        this.leg8.rotateAngleY += -f6;
        this.leg1.rotateAngleZ += f7;
        this.leg2.rotateAngleZ += -f7;
        this.leg3.rotateAngleZ += f8;
        this.leg4.rotateAngleZ += -f8;
        this.leg5.rotateAngleZ += f9;
        this.leg6.rotateAngleZ += -f9;
        this.leg7.rotateAngleZ += f10;
        this.leg8.rotateAngleZ += -f10;
    }

    /**
     * This is a helper function from Tabula to set the rotation of model parts
     */
    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }

    @Override
    public void render(MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) {
        this.body.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
    }
}
