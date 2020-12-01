package com.swordofblaze.dungeons_etc.client.models;

import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.model.SilverfishModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

/**
 * MaggotModel - SimplicityPotato
 * Created using Tabula 8.0.0
 */
@OnlyIn(Dist.CLIENT)
public class MaggotModel<T extends Entity> extends EntityModel<T> {

    public ModelRenderer head;
    public ModelRenderer frontlump;
    public ModelRenderer maintorso;
    public ModelRenderer backlump;
    public ModelRenderer noodletail;

    public ModelRenderer leftfrontleg;
    public ModelRenderer rightfrontleg;
    public ModelRenderer leftmidleg;
    public ModelRenderer rightmidleg;
    public ModelRenderer leftbackleg;
    public ModelRenderer rightblackleg;

    public MaggotModel() {
        this.textureWidth = 64;
        this.textureHeight = 32;

        this.maintorso = new ModelRenderer(this, 0, 0);
        this.maintorso.setRotationPoint(0.0F, 21.5F, 0.0F);
        this.maintorso.addBox(-2.0F, -2.0F, -1.5F, 4.0F, 4.0F, 3.0F, 0.0F, 0.0F, 0.0F);

        this.frontlump = new ModelRenderer(this, 0, 8);
        this.frontlump.setRotationPoint(0.0F, 0.5F, -1.5F);
        this.frontlump.addBox(-1.5F, -1.5F, -2.0F, 3.0F, 3.0F, 2.0F, 0.0F, 0.0F, 0.0F);

        this.head = new ModelRenderer(this, 0, 14);
        this.head.setRotationPoint(0.0F, 0.5F, -2.0F);
        this.head.addBox(-1.5F, -1.0F, -2.0F, 3.0F, 2.0F, 2.0F, 0.0F, 0.0F, 0.0F);

        this.rightmidleg = new ModelRenderer(this, 15, 0);
        this.rightmidleg.setRotationPoint(-1.5F, 1.5F, 0.0F);
        this.rightmidleg.addBox(0.0F, 0.0F, -0.5F, 0.0F, 1.0F, 1.0F, 0.0F, 0.0F, 0.0F);

        this.rightblackleg = new ModelRenderer(this, 11, 13);
        this.rightblackleg.setRotationPoint(-1.0F, 1.0F, 1.0F);
        this.rightblackleg.addBox(0.0F, 0.0F, -0.5F, 0.0F, 1.0F, 1.0F, 0.0F, 0.0F, 0.0F);

        this.rightfrontleg = new ModelRenderer(this, 3, 18);
        this.rightfrontleg.setRotationPoint(-1.0F, 1.0F, -1.0F);
        this.rightfrontleg.addBox(0.0F, 0.0F, -0.5F, 0.0F, 1.0F, 1.0F, 0.0F, 0.0F, 0.0F);

        this.leftbackleg = new ModelRenderer(this, 14, 13);
        this.leftbackleg.setRotationPoint(1.0F, 1.0F, 1.0F);
        this.leftbackleg.addBox(0.0F, 0.0F, -0.5F, 0.0F, 1.0F, 1.0F, 0.0F, 0.0F, 0.0F);

        this.leftfrontleg = new ModelRenderer(this, 0, 18);
        this.leftfrontleg.setRotationPoint(1.0F, 1.0F, -1.0F);
        this.leftfrontleg.addBox(0.0F, 0.0F, -0.5F, 0.0F, 1.0F, 1.0F, 0.0F, 0.0F, 0.0F);

        this.noodletail = new ModelRenderer(this, 22, 10);
        this.noodletail.setRotationPoint(0.0F, 1.0F, 2.0F);
        this.noodletail.addBox(-1.0F, -0.5F, 0.0F, 2.0F, 1.0F, 1.0F, 0.0F, 0.0F, 0.0F);

        this.leftmidleg = new ModelRenderer(this, 12, 0);
        this.leftmidleg.setRotationPoint(1.5F, 1.5F, 0.0F);
        this.leftmidleg.addBox(0.0F, 0.0F, -0.5F, 0.0F, 1.0F, 1.0F, 0.0F, 0.0F, 0.0F);

        this.backlump = new ModelRenderer(this, 11, 8);
        this.backlump.setRotationPoint(0.0F, 0.5F, 1.5F);
        this.backlump.addBox(-1.5F, -1.5F, 0.0F, 3.0F, 3.0F, 2.0F, 0.0F, 0.0F, 0.0F);

        this.maintorso.addChild(this.frontlump);
        this.frontlump.addChild(this.head);
        this.maintorso.addChild(this.rightmidleg);
        this.backlump.addChild(this.rightblackleg);
        this.frontlump.addChild(this.rightfrontleg);
        this.backlump.addChild(this.leftbackleg);
        this.frontlump.addChild(this.leftfrontleg);
        this.backlump.addChild(this.noodletail);
        this.maintorso.addChild(this.leftmidleg);
        this.maintorso.addChild(this.backlump);
    }

    @Override
    public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        ImmutableList.of(this.maintorso).forEach((modelRenderer) -> { 
            modelRenderer.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
        });
    }

    @Override
    public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        ImmutableList<ModelRenderer> models = ImmutableList.of(this.head, this.frontlump, this.maintorso, this.backlump, this.noodletail);

        for (int i = 0; i < models.size(); i++) {
            ModelRenderer modelRenderer = models.get(i);
            modelRenderer.rotateAngleY = MathHelper.cos(ageInTicks * 0.9F + (float)i * 0.15F * (float)Math.PI) * (float)Math.PI * 0.05F * (float)(1 + Math.abs(i - 2)) * 0.71429F;
            modelRenderer.rotationPointX = MathHelper.sin(ageInTicks * 0.9F + (float)i * 0.15F * (float)Math.PI) * (float)Math.PI * 0.1F * (float)Math.abs(i - 2) * 0.71429F;
        }
    }


    /**
     * This is a helper function from Tabula to set the rotation of model parts
     */
    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}
