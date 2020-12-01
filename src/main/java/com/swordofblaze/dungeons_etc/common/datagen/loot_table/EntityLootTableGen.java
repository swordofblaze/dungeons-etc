package com.swordofblaze.dungeons_etc.common.datagen.loot_table;

import com.swordofblaze.dungeons_etc.common.registers.ModEntities;
import net.minecraft.data.loot.EntityLootTables;
import net.minecraft.entity.EntityType;
import net.minecraft.loot.LootTable;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nonnull;
import java.util.HashSet;
import java.util.Set;

public class EntityLootTableGen extends EntityLootTables {

    private final Set<EntityType<?>> knownEntities = new HashSet<>();

    @Override
    protected @NotNull Iterable<EntityType<?>> getKnownEntities() {
        return this.knownEntities;
    }

    @Override
    protected void registerLootTable(@NotNull EntityType<?> type, @NotNull LootTable.Builder table) {
        super.registerLootTable(type, table);
        this.knownEntities.add(type);
    }

    @Override
    protected void addTables() {
        this.registerLootTable(ModEntities.WEBBER.get(), LootTable.builder());
    }
}
