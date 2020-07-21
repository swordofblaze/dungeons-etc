package com.swordofblaze.sword_squad.client;

import com.swordofblaze.sword_squad.client.renderers.WebberRenderer;
import com.swordofblaze.sword_squad.core.SwordSquad;
import com.swordofblaze.sword_squad.registers.SSEntities;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ItemRenderer;
import net.minecraft.client.renderer.entity.SpriteRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.IRendersAsItem;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

import java.util.function.Supplier;

@Mod.EventBusSubscriber(value = Dist.CLIENT, modid = SwordSquad.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ClientRegister {

    @SubscribeEvent
    public static void registerClient(FMLClientSetupEvent event) {
        registerEntityRenderers(event.getMinecraftSupplier());
        registerBlockRenderTypes();
    }

    private static void registerEntityRenderers(Supplier<Minecraft> minecraft) {
        RenderingRegistry.registerEntityRenderingHandler(SSEntities.WEBBER.get(), WebberRenderer::new);

        registerSpriteRenderer(SSEntities.WEB_PROJECTILE.get(), minecraft);
    }

    private static void registerBlockRenderTypes() {

    }

    /**
     *  Use when registering simple projectile entities
     *  that should use SpriteRenderer for 2D "snowball rendering"
     */
    private static <T extends Entity & IRendersAsItem> void registerSpriteRenderer(EntityType<T> entityType, Supplier<Minecraft> minecraftSupplier) {
        ItemRenderer renderer = minecraftSupplier.get().getItemRenderer();
        RenderingRegistry.registerEntityRenderingHandler(entityType, (rendererManager) -> new SpriteRenderer<>(rendererManager, renderer));
    }
}
