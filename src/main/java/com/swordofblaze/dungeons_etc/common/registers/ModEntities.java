package com.swordofblaze.dungeons_etc.common.registers;

import com.swordofblaze.dungeons_etc.common.entities.WebProjectileEntity;
import com.swordofblaze.dungeons_etc.common.entities.WebberEntity;
import com.swordofblaze.dungeons_etc.common.core.DungeonsEtc;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.attributes.GlobalEntityTypeAttributes;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModEntities {

    public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITIES, DungeonsEtc.MODID);

    private static <T extends Entity> RegistryObject<EntityType<T>> register(String name, EntityType.Builder<T> builder) {
        return ENTITIES.register(name, () -> builder.build(name));
    }

    public static final RegistryObject<EntityType<WebberEntity>> WEBBER = register("webber", EntityType.Builder.create(WebberEntity::new, EntityClassification.MONSTER).size(1.4f, 0.9f));
    public static final RegistryObject<EntityType<WebProjectileEntity>> WEB_PROJECTILE = register("web_projectile", EntityType.Builder.<WebProjectileEntity>create(WebProjectileEntity::new, EntityClassification.MISC).size(0.25f, 0.25f));


    public static void registerAttributes() {
        GlobalEntityTypeAttributes.put(WEBBER.get(), WebberEntity.getAttributes().create());
    }
}
