package com.swordofblaze.dungeons_etc.common.registers;

import com.swordofblaze.dungeons_etc.common.core.DungeonsEtc;
import com.swordofblaze.dungeons_etc.common.world.structures.TestStructure;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.feature.StructureFeature;
import net.minecraft.world.gen.feature.structure.Structure;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Supplier;

public class ModStructures {

    public static final DeferredRegister<Structure<?>> STRUCTURES = DeferredRegister.create(ForgeRegistries.STRUCTURE_FEATURES, DungeonsEtc.MODID);

    public static final RegistryObject<TestStructure> TEST_STRUCTURE = register("test", () -> new TestStructure(NoFeatureConfig.field_236558_a_));

    private static <T extends Structure<?>> RegistryObject<T> register(String name, Supplier<T> structure) {
        return STRUCTURES.register(name, structure);
    }

    public static void addStructureSpawns() {

    }

    private static void addStructureSpawn(StructureFeature<?, ?> structure, Biome biome) {
        biome.func_235063_a_(structure);
    }
}
