package com.swordofblaze.dungeons_etc.client;

import com.swordofblaze.dungeons_etc.client.renderers.entity.MaggotRenderer;
import com.swordofblaze.dungeons_etc.client.renderers.entity.SpitterRenderer;
import com.swordofblaze.dungeons_etc.client.renderers.entity.WebberRenderer;
import com.swordofblaze.dungeons_etc.common.core.DungeonsEtc;
import com.swordofblaze.dungeons_etc.common.items.ModSpawnEggItem;
import com.swordofblaze.dungeons_etc.common.registers.ModBlocks;
import com.swordofblaze.dungeons_etc.common.registers.ModEntities;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ItemRenderer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.client.renderer.color.ItemColors;
import net.minecraft.client.renderer.entity.SpriteRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.IRendersAsItem;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.ColorHandlerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

import java.util.function.Supplier;

@Mod.EventBusSubscriber(value = Dist.CLIENT, modid = DungeonsEtc.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ClientRegister {

    @SubscribeEvent
    public static void registerClient(FMLClientSetupEvent event) {
        registerEntityRenderers(event.getMinecraftSupplier());
        registerBlockRenderTypes();
    }

    private static void registerEntityRenderers(Supplier<Minecraft> minecraft) {
        RenderingRegistry.registerEntityRenderingHandler(ModEntities.WEBBER.get(), WebberRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(ModEntities.SPITTER.get(), SpitterRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(ModEntities.MAGGOT.get(), MaggotRenderer::new);

        registerSpriteRenderer(ModEntities.WEB_PROJECTILE.get(), minecraft);
        registerSpriteRenderer(ModEntities.ACID_PROJECTILE.get(), minecraft, 1.2f);
    }

    private static void registerBlockRenderTypes() {
        RenderTypeLookup.setRenderLayer(ModBlocks.WEBBER_WEB.get(), RenderType.getCutout());
    }

    @SubscribeEvent
    public static void registerItemColors(ColorHandlerEvent.Item event) {
        ItemColors itemColors = event.getItemColors();

        for(ModSpawnEggItem spawnEgg : ModSpawnEggItem.getEggs()) {
            itemColors.register((itemStack, color) -> spawnEgg.getColor(color), spawnEgg);
        }
    }

    /**
     *  Use when registering simple projectile entities
     *  that should render in "2D", like snowballs or fireballs.
     */
    private static <T extends Entity & IRendersAsItem> void registerSpriteRenderer(EntityType<T> entityType, Supplier<Minecraft> minecraftSupplier) {
        ItemRenderer renderer = minecraftSupplier.get().getItemRenderer();
        RenderingRegistry.registerEntityRenderingHandler(entityType, (rendererManager) -> new SpriteRenderer<>(rendererManager, renderer));
    }

    /**
     *  SpriteRenderer with specified scale.
     */
    private static <T extends Entity & IRendersAsItem> void registerSpriteRenderer(EntityType<T> entityType, Supplier<Minecraft> minecraftSupplier, float scale) {
        ItemRenderer renderer = minecraftSupplier.get().getItemRenderer();
        RenderingRegistry.registerEntityRenderingHandler(entityType, (rendererManager) -> new SpriteRenderer<>(rendererManager, renderer, scale, false));
    }
}
