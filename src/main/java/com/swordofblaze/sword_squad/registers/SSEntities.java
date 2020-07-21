package com.swordofblaze.sword_squad.registers;

import com.swordofblaze.sword_squad.common.entities.WebProjectileEntity;
import com.swordofblaze.sword_squad.common.entities.WebberEntity;
import com.swordofblaze.sword_squad.core.SwordSquad;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class SSEntities {

    public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITIES, SwordSquad.MODID);

    private static <E extends Entity> RegistryObject<EntityType<E>> register(String name, EntityType.Builder<E> builder) {
        return ENTITIES.register(name, () -> builder.build(name));
    }

    public static final RegistryObject<EntityType<WebberEntity>> WEBBER = register("webber", EntityType.Builder.create(WebberEntity::new, EntityClassification.MONSTER).size(1.4f, 0.9f));

    public static final RegistryObject<EntityType<WebProjectileEntity>> WEB_PROJECTILE = register("web_projectile", EntityType.Builder.<WebProjectileEntity>create(WebProjectileEntity::new, EntityClassification.MISC).size(0.25f, 0.25f));
}
