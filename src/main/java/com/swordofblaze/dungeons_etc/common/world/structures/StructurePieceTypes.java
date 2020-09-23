package com.swordofblaze.dungeons_etc.common.world.structures;

import net.minecraft.world.gen.feature.structure.IStructurePieceType;

public class StructurePieceTypes {

    public static final IStructurePieceType TEST = IStructurePieceType.register(TestStructurePiece::new, "ss_test");
}
