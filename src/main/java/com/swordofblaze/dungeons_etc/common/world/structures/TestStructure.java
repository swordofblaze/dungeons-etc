package com.swordofblaze.dungeons_etc.common.world.structures;

import com.mojang.serialization.Codec;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.util.registry.DynamicRegistries;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.feature.structure.PillagerOutpostStructure;
import net.minecraft.world.gen.feature.structure.Structure;
import net.minecraft.world.gen.feature.structure.StructureStart;
import net.minecraft.world.gen.feature.template.TemplateManager;

public class TestStructure extends Structure<NoFeatureConfig> {

    public TestStructure(Codec<NoFeatureConfig> configCodec) {
        super(configCodec);
    }
 
    @Override
    public IStartFactory<NoFeatureConfig> getStartFactory() {
        return Start::new;
    }

    public static class Start extends StructureStart<NoFeatureConfig> {
        public Start(Structure<NoFeatureConfig> structure, int p_i225801_2_, int p_i225801_3_, MutableBoundingBox boundingBox, int p_i225801_5_, long p_i225801_6_) {
            super(structure, p_i225801_2_, p_i225801_3_, boundingBox, p_i225801_5_, p_i225801_6_);
        }

        @Override
        public void func_230364_a_(DynamicRegistries dynamicRegistries, ChunkGenerator chunkGenerator, TemplateManager templateManager, int x, int z, Biome biome, NoFeatureConfig config) {
            TestStructurePiece structurePiece = new TestStructurePiece(this.rand, x * 16, z * 16);
            this.components.add(structurePiece);
            this.recalculateStructureSize();
        }
    }
}
