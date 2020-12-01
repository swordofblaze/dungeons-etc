package com.swordofblaze.dungeons_etc.common.registers;

import com.swordofblaze.dungeons_etc.common.entities.*;
import com.swordofblaze.dungeons_etc.common.core.DungeonsEtc;
import com.swordofblaze.dungeons_etc.common.tags.ModEntityTypeTags;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntitySpawnPlacementRegistry;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.attributes.GlobalEntityTypeAttributes;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.monster.SpiderEntity;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.biome.PlainsBiome;
import net.minecraft.world.gen.Heightmap;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import org.jetbrains.annotations.NotNull;

public class ModEntities {

    public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITIES, DungeonsEtc.MODID);

    private static <T extends Entity> RegistryObject<EntityType<T>> register(String name, EntityType.Builder<T> builder) {
        return ENTITIES.register(name, () -> builder.build(name));
    }

    public static final RegistryObject<EntityType<MaggotEntity>> MAGGOT = register("maggot", EntityType.Builder.create(MaggotEntity::new, EntityClassification.MONSTER).size(0.3f, 0.3f));
    public static final RegistryObject<EntityType<WebberEntity>> WEBBER = register("webber", EntityType.Builder.create(WebberEntity::new, EntityClassification.MONSTER).size(1.4f, 0.9f));
    public static final RegistryObject<EntityType<SpitterEntity>> SPITTER = register("spitter", EntityType.Builder.create(SpitterEntity::new, EntityClassification.MONSTER).size(1.4f, 0.9f));
    public static final RegistryObject<EntityType<WebProjectileEntity>> WEB_PROJECTILE = register("web_projectile", EntityType.Builder.<WebProjectileEntity>create(WebProjectileEntity::new, EntityClassification.MISC).size(0.25f, 0.25f));
    public static final RegistryObject<EntityType<AcidProjectileEntity>> ACID_PROJECTILE = register("acid_projectile", EntityType.Builder.<AcidProjectileEntity>create(AcidProjectileEntity::new, EntityClassification.MISC).size(0.30f, 0.30f));

    public static void registerAttributes() {
        GlobalEntityTypeAttributes.put(MAGGOT.get(), MaggotEntity.getAttributes().create());
        GlobalEntityTypeAttributes.put(WEBBER.get(), WebberEntity.getAttributes().create());
        GlobalEntityTypeAttributes.put(SPITTER.get(), SpitterEntity.getAttributes().create());
    }


    public static void registerEntityPlacement() {
        EntitySpawnPlacementRegistry.register(ModEntities.MAGGOT.get(), EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, MonsterEntity::canMonsterSpawnInLight);
        EntitySpawnPlacementRegistry.register(ModEntities.WEBBER.get(), EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, MonsterEntity::canMonsterSpawnInLight);
        EntitySpawnPlacementRegistry.register(ModEntities.SPITTER.get(), EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, MonsterEntity::canMonsterSpawnInLight);
    }

    public static void registerEntitySpawns() {
        registerBiomeSpawnDictionary(MAGGOT.get(), EntityClassification.MONSTER, 5, 1, 4, BiomeDictionary.Type.FOREST);
        registerBiomeSpawnDictionary(MAGGOT.get(), EntityClassification.MONSTER, 5, 1, 4, BiomeDictionary.Type.JUNGLE);
        registerBiomeSpawnDictionary(MAGGOT.get(), EntityClassification.MONSTER, 5, 1, 4, BiomeDictionary.Type.MOUNTAIN);
        registerBiomeSpawnDictionary(MAGGOT.get(), EntityClassification.MONSTER, 5, 1, 4, BiomeDictionary.Type.SAVANNA);
        registerBiomeSpawnDictionary(MAGGOT.get(), EntityClassification.MONSTER, 5, 1, 4, BiomeDictionary.Type.SWAMP);
        registerBiomeSpawnDictionary(MAGGOT.get(), EntityClassification.MONSTER, 5, 1, 4, BiomeDictionary.Type.SANDY);

        registerBiomeSpawnDictionary(SPITTER.get(), EntityClassification.MONSTER, 80, 1, 3, BiomeDictionary.Type.FOREST);
        registerBiomeSpawnDictionary(SPITTER.get(), EntityClassification.MONSTER, 80, 1, 3, BiomeDictionary.Type.JUNGLE);
        registerBiomeSpawnDictionary(SPITTER.get(), EntityClassification.MONSTER, 80, 1, 3, BiomeDictionary.Type.MOUNTAIN);
        registerBiomeSpawnDictionary(SPITTER.get(), EntityClassification.MONSTER, 80, 1, 3, BiomeDictionary.Type.SAVANNA);
        registerBiomeSpawnDictionary(SPITTER.get(), EntityClassification.MONSTER, 80, 1, 3, BiomeDictionary.Type.SWAMP);
        registerBiomeSpawnDictionary(MAGGOT.get(), EntityClassification.MONSTER, 5, 1, 4, BiomeDictionary.Type.SANDY);

        registerBiomeSpawnDictionary(WEBBER.get(), EntityClassification.MONSTER, 95, 1, 2, BiomeDictionary.Type.FOREST);
    }

    private static void registerBiomeSpawn(EntityType<?> entityType, EntityClassification entityClassification, int weight, int minGroup, int maxGroup, @NotNull Biome... biomes) {
        for (Biome biome : biomes) {
            biome.getSpawns(entityClassification).add(new Biome.SpawnListEntry(entityType, weight, minGroup, maxGroup));
        }
    }

    private static void registerBiomeSpawnDictionary(EntityType<?> entityType, EntityClassification entityClassification, int weight, int minGroup, int maxGroup, BiomeDictionary.Type biomeType) {
        for (Biome biome : BiomeDictionary.getBiomes(biomeType)) {
            biome.getSpawns(entityClassification).add(new Biome.SpawnListEntry(entityType, weight, minGroup, maxGroup));
        }
    }
}
