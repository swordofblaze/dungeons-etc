package com.swordofblaze.dungeons_etc.common.datagen;

import com.swordofblaze.dungeons_etc.common.compat.hwyla.TooltipReferences;
import com.swordofblaze.dungeons_etc.common.core.DungeonsEtc;
import com.swordofblaze.dungeons_etc.common.damagesource.ModDamageSources;
import com.swordofblaze.dungeons_etc.common.registers.ModBlocks;
import com.swordofblaze.dungeons_etc.common.registers.ModEffects;
import com.swordofblaze.dungeons_etc.common.registers.ModEntities;
import com.swordofblaze.dungeons_etc.common.registers.ModItems;
import net.minecraft.data.DataGenerator;
import net.minecraft.util.DamageSource;
import net.minecraftforge.common.data.LanguageProvider;

public class LangGen extends LanguageProvider {

    private static final String VICTIM = "%1$s";
    private static final String ATTACKER = "%2$s";


    public LangGen(DataGenerator gen) {
        // Just generating for american english
        super(gen, DungeonsEtc.MODID, "en_us");
    }

    @Override
    protected void addTranslations() {
        this.add("itemGroup.dungeons_etc", "Dungeons Etc");

        this.addBlock(ModBlocks.CRACKED_ANDESITE, "Cracked Andesite");
        this.addBlock(ModBlocks.CRACKED_ANDESITE_SLAB,"Cracked Andesite Slab");
        this.addBlock(ModBlocks.CRACKED_ANDESITE_STAIRS, "Cracked Andesite Stairs");
        this.addBlock(ModBlocks.CRACKED_ANDESITE_WALL,"Cracked Andesite Wall");
        this.addBlock(ModBlocks.CRACKED_DIORITE, "Cracked Diorite");
        this.addBlock(ModBlocks.CRACKED_DIORITE_SLAB,"Cracked Diorite Slab");
        this.addBlock(ModBlocks.CRACKED_DIORITE_STAIRS, "Cracked Diorite Stairs");
        this.addBlock(ModBlocks.CRACKED_DIORITE_WALL,"Cracked Diorite Wall");
        this.addBlock(ModBlocks.CRACKED_GRANITE, "Cracked Granite");
        this.addBlock(ModBlocks.CRACKED_GRANITE_SLAB,"Cracked Granite Slab");
        this.addBlock(ModBlocks.CRACKED_GRANITE_STAIRS, "Cracked Granite Stairs");
        this.addBlock(ModBlocks.CRACKED_GRANITE_WALL,"Cracked Granite Wall");
        this.addBlock(ModBlocks.CRACKED_BRICKS, "Cracked Bricks");
        this.addBlock(ModBlocks.CRACKED_BRICK_SLAB,"Cracked Brick Slab");
        this.addBlock(ModBlocks.CRACKED_BRICK_STAIRS, "Cracked Brick Stairs");
        this.addBlock(ModBlocks.CRACKED_BRICK_WALL,"Cracked Brick Wall");
        this.addBlock(ModBlocks.ANDESITE_BRICKS, "Andesite Bricks");
        this.addBlock(ModBlocks.ANDESITE_BRICK_SLAB, "Andesite Brick Slab");
        this.addBlock(ModBlocks.ANDESITE_BRICK_STAIRS, "Andesite Brick Stairs");
        this.addBlock(ModBlocks.ANDESITE_BRICK_WALL, "Andesite Brick Wall");
        this.addBlock(ModBlocks.ANDESITE_BRICK_PRESSURE_PLATE, "Andesite Brick Pressure Plate");
        this.addBlock(ModBlocks.ANDESITE_BRICK_BUTTON, "Andesite Brick Button");
        this.addBlock(ModBlocks.DIORITE_BRICKS, "Diorite Bricks");
        this.addBlock(ModBlocks.DIORITE_BRICK_SLAB, "Diorite Brick Slab");
        this.addBlock(ModBlocks.DIORITE_BRICK_STAIRS, "Diorite Brick Stairs");
        this.addBlock(ModBlocks.DIORITE_BRICK_WALL, "Diorite Brick Wall");
        this.addBlock(ModBlocks.DIORITE_BRICK_PRESSURE_PLATE, "Diorite Brick Pressure Plate");
        this.addBlock(ModBlocks.DIORITE_BRICK_BUTTON, "Diorite Brick Button");
        this.addBlock(ModBlocks.GRANITE_BRICKS, "Granite Bricks");
        this.addBlock(ModBlocks.GRANITE_BRICK_SLAB, "Granite Brick Slab");
        this.addBlock(ModBlocks.GRANITE_BRICK_STAIRS, "Granite Brick Stairs");
        this.addBlock(ModBlocks.GRANITE_BRICK_WALL, "Granite Brick Wall");
        this.addBlock(ModBlocks.GRANITE_BRICK_PRESSURE_PLATE, "Granite Brick Pressure Plate");
        this.addBlock(ModBlocks.GRANITE_BRICK_BUTTON, "Granite Brick Button");
        this.addBlock(ModBlocks.STONE_BRICK_DISPENSER, "Stone Brick Dispenser");
        this.addBlock(ModBlocks.COBBLESTONE_DISPENSER, "Cobblestone Dispenser");
        this.addBlock(ModBlocks.BLACKSTONE_DISPENSER, "Blackstone Dispenser");
        this.addBlock(ModBlocks.WEBBER_WEB, "Webber Web");

        this.addItem(ModItems.SPITTER_ACID, "Spitter Acid");
        this.addItem(ModItems.MAGGOT_SPAWN_EGG, "Maggot Spawn Egg");
        this.addItem(ModItems.WEBBER_SPAWN_EGG, "Webber Spawn Egg");
        this.addItem(ModItems.SPITTER_SPAWN_EGG, "Spitter Spawn Egg");

        this.addEntityType(ModEntities.WEB_PROJECTILE, "Webber Web");
        this.addEntityType(ModEntities.WEBBER, "Webber");
        this.addEntityType(ModEntities.SPITTER, "Spitter");
        this.addEntityType(ModEntities.MAGGOT, "Maggot");

        this.addEffect(ModEffects.DEATH_MARK, "Mark");
        this.addEffect(ModEffects.STUN, "Stun");
        this.addEffect(ModEffects.BLEED, "Bleed");
        this.addEffect(ModEffects.BLIGHT, "Blight");
        this.addEffect(ModEffects.HORROR, "Horror");

        this.addDamageSource(ModDamageSources.HEART_ATTACK, VICTIM + " suffered a heart attack");
        this.addDamageSourceAttacker(ModDamageSources.HEART_ATTACK, VICTIM + " suffered a heart attack whilst fighting " + ATTACKER);
        this.addDamageSourceAttackSelf(ModDamageSources.HEART_ATTACK, VICTIM + " gave themselves a heart attack");
        this.addDamageSource(ModDamageSources.BLIGHT, VICTIM + " melted");
        this.addDamageSourceAttacker(ModDamageSources.BLIGHT, VICTIM + " melted whilst fighting " + ATTACKER);
        this.addDamageSourceAttackSelf(ModDamageSources.BLIGHT, VICTIM + " melted themselves");

        this.add("config.waila.plugin_dungeons_etc", DungeonsEtc.NAME);
        this.add("config.waila.plugin_dungeons_etc.obfuscate_traps", "Obfuscate Traps");
        this.add("config.waila.plugin_dungeons_etc.show_player_stress", "Show Player Stress");

        this.add(TooltipReferences.TOOLTIP_STRESS, "Stress");
    }

    private void addDamageSource(DamageSource damageSource, String message) {
        this.add("death.attack." + damageSource.getDamageType(), message);
    }

    private void addDamageSourceAttacker(DamageSource damageSource, String message) {
        this.add("death.attack." + damageSource.getDamageType() + ".player", message);
    }

    private void addDamageSourceAttackSelf(DamageSource damageSource, String message) {
        this.add("death.attack." + damageSource.getDamageType() + ".self", message);
    }
}
