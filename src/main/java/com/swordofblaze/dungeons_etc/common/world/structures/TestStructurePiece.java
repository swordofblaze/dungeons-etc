package com.swordofblaze.dungeons_etc.common.world.structures;

import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.world.ISeedReader;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.feature.structure.ScatteredStructurePiece;
import net.minecraft.world.gen.feature.structure.StructureManager;
import net.minecraft.world.gen.feature.template.TemplateManager;

import java.util.Random;

public class TestStructurePiece extends ScatteredStructurePiece {

    protected TestStructurePiece(Random random, int x, int z) {
        super(StructurePieceTypes.TEST, random, x, 64, z, 10, 7, 10);
    }

    public TestStructurePiece(TemplateManager templateManager, CompoundNBT compoundNBT) {
        super(StructurePieceTypes.TEST, compoundNBT);
    }

    @Override
    public boolean func_230383_a_(ISeedReader iSeedReader, StructureManager structureManager, ChunkGenerator chunkGenerator, Random random, MutableBoundingBox mutableBoundingBox, ChunkPos chunkPos, BlockPos blockPos) {
        return false;
    }
}
