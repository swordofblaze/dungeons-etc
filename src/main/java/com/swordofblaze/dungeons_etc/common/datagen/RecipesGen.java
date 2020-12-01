package com.swordofblaze.dungeons_etc.common.datagen;

import com.swordofblaze.dungeons_etc.common.registers.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.data.*;
import net.minecraft.item.crafting.Ingredient;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class RecipesGen extends RecipeProvider {

    public RecipesGen(DataGenerator generator) {
        super(generator);
    }

    @Override
    public void registerRecipes(@NotNull Consumer<IFinishedRecipe> consumer) {

        /*
         * -----------------------------------------------------
         *                     STONECUTTING
         * -----------------------------------------------------
         */

        this.registerStonecuttingRecipe(ModBlocks.CRACKED_ANDESITE, Blocks.ANDESITE, 1, consumer);
        this.registerStonecuttingRecipe(ModBlocks.CRACKED_ANDESITE_SLAB, Blocks.ANDESITE, 2, consumer);
        this.registerStonecuttingRecipe(ModBlocks.CRACKED_ANDESITE_STAIRS, Blocks.ANDESITE, 1, consumer);
        this.registerStonecuttingRecipe(ModBlocks.CRACKED_ANDESITE_WALL, Blocks.ANDESITE, 1, consumer);

        this.registerStonecuttingRecipe(ModBlocks.CRACKED_DIORITE, Blocks.DIORITE, 1, consumer);
        this.registerStonecuttingRecipe(ModBlocks.CRACKED_DIORITE_SLAB, Blocks.DIORITE, 2, consumer);
        this.registerStonecuttingRecipe(ModBlocks.CRACKED_DIORITE_STAIRS, Blocks.DIORITE, 1, consumer);
        this.registerStonecuttingRecipe(ModBlocks.CRACKED_DIORITE_WALL, Blocks.DIORITE, 1, consumer);

        this.registerStonecuttingRecipe(ModBlocks.CRACKED_GRANITE, Blocks.GRANITE, 1, consumer);
        this.registerStonecuttingRecipe(ModBlocks.CRACKED_GRANITE_SLAB, Blocks.GRANITE, 2, consumer);
        this.registerStonecuttingRecipe(ModBlocks.CRACKED_GRANITE_STAIRS, Blocks.GRANITE, 1, consumer);
        this.registerStonecuttingRecipe(ModBlocks.CRACKED_GRANITE_WALL, Blocks.GRANITE, 1, consumer);

        this.registerStonecuttingRecipe(ModBlocks.CRACKED_BRICKS, Blocks.BRICKS, 1, consumer);
        this.registerStonecuttingRecipe(ModBlocks.CRACKED_BRICK_SLAB, Blocks.BRICKS, 2, consumer);
        this.registerStonecuttingRecipe(ModBlocks.CRACKED_BRICK_STAIRS, Blocks.BRICKS, 1, consumer);
        this.registerStonecuttingRecipe(ModBlocks.CRACKED_BRICK_WALL, Blocks.BRICKS, 1, consumer);

        this.registerStonecuttingRecipe(ModBlocks.ANDESITE_BRICKS, Blocks.ANDESITE, 1, consumer);
        this.registerStonecuttingRecipe(ModBlocks.ANDESITE_BRICK_SLAB, Blocks.ANDESITE, 2, consumer);
        this.registerStonecuttingRecipe(ModBlocks.ANDESITE_BRICK_STAIRS, Blocks.ANDESITE, 1, consumer);
        this.registerStonecuttingRecipe(ModBlocks.ANDESITE_BRICK_WALL, Blocks.ANDESITE, 1, consumer);

        this.registerStonecuttingRecipe(ModBlocks.DIORITE_BRICKS, Blocks.DIORITE, 1, consumer);
        this.registerStonecuttingRecipe(ModBlocks.DIORITE_BRICK_SLAB, Blocks.DIORITE, 2, consumer);
        this.registerStonecuttingRecipe(ModBlocks.DIORITE_BRICK_STAIRS, Blocks.DIORITE, 1, consumer);
        this.registerStonecuttingRecipe(ModBlocks.DIORITE_BRICK_WALL, Blocks.DIORITE, 1, consumer);

        this.registerStonecuttingRecipe(ModBlocks.GRANITE_BRICKS, Blocks.GRANITE, 1, consumer);
        this.registerStonecuttingRecipe(ModBlocks.GRANITE_BRICK_SLAB, Blocks.GRANITE, 2, consumer);
        this.registerStonecuttingRecipe(ModBlocks.GRANITE_BRICK_STAIRS, Blocks.GRANITE, 1, consumer);
        this.registerStonecuttingRecipe(ModBlocks.GRANITE_BRICK_WALL, Blocks.GRANITE, 1, consumer);

        /*
         * -----------------------------------------------------
         *                       SHAPED
         * -----------------------------------------------------
         */

        // Pressure plates
        ShapedRecipeBuilder.shapedRecipe(ModBlocks.ANDESITE_BRICK_PRESSURE_PLATE.get(),
                1)
                .key('#', ModBlocks.ANDESITE_BRICKS.get())
                .patternLine("##")
                .addCriterion("has_andesite_bricks", hasItem(ModBlocks.ANDESITE_BRICKS.get()))
                .build(consumer);

        ShapedRecipeBuilder.shapedRecipe(ModBlocks.DIORITE_BRICK_PRESSURE_PLATE.get(),
                1)
                .key('#', ModBlocks.DIORITE_BRICKS.get())
                .patternLine("##")
                .addCriterion("has_diorite_bricks", hasItem(ModBlocks.DIORITE_BRICKS.get()))
                .build(consumer);

        ShapedRecipeBuilder.shapedRecipe(ModBlocks.GRANITE_BRICK_PRESSURE_PLATE.get(),
                1)
                .key('#', ModBlocks.GRANITE_BRICKS.get())
                .patternLine("##")
                .addCriterion("has_granite_bricks", hasItem(ModBlocks.GRANITE_BRICKS.get()))
                .build(consumer);

        /*
         * -----------------------------------------------------
         *                     SHAPELESS
         * -----------------------------------------------------
         */

        // Buttons
        ShapelessRecipeBuilder.shapelessRecipe(ModBlocks.ANDESITE_BRICK_BUTTON.get(),
                1)
                .addIngredient(Blocks.ANDESITE)
                .addCriterion("has_andesite_bricks", hasItem(ModBlocks.ANDESITE_BRICKS.get()))
                .build(consumer);

        ShapelessRecipeBuilder.shapelessRecipe(ModBlocks.DIORITE_BRICK_BUTTON.get(),
                1)
                .addIngredient(Blocks.DIORITE)
                .addCriterion("has_diorite_bricks", hasItem(ModBlocks.DIORITE_BRICKS.get()))
                .build(consumer);

        ShapelessRecipeBuilder.shapelessRecipe(ModBlocks.GRANITE_BRICK_BUTTON.get(),
                1)
                .addIngredient(Blocks.GRANITE)
                .addCriterion("has_granite_bricks", hasItem(ModBlocks.GRANITE_BRICKS.get()))
                .build(consumer);

    }

    private void registerStonecuttingRecipe(Supplier<Block> resultBlock, Block ingridientBlock, int count, Consumer<IFinishedRecipe> consumer) {
        String ingridientName = Objects.requireNonNull(ingridientBlock.getRegistryName()).getPath();
        String resultName = Objects.requireNonNull(resultBlock.get().getRegistryName()).getPath();

        SingleItemRecipeBuilder.stonecuttingRecipe(
                Ingredient.fromItems(ingridientBlock),
                resultBlock.get(),
                count)
                .addCriterion("has_" + ingridientName, hasItem(ingridientBlock))
                .build(consumer, resultName + "_from_stonecutting");
    }
}
