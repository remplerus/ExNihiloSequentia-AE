package novamachina.exnihiloae.common.datagen;

import net.minecraft.block.Block;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.IDataProvider;
import net.minecraft.loot.ConstantRange;
import net.minecraft.loot.ItemLootEntry;
import net.minecraft.loot.LootParameterSets;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.conditions.SurvivesExplosion;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.ResourceLocation;
import novamachina.exnihiloae.common.init.ExNihiloAEBlocks;
import novamachina.exnihiloae.common.utility.ExNihiloAEConstants;
import novamachina.exnihilosequentia.common.datagen.LootTableGenerator;
import novamachina.exnihilosequentia.common.init.ModBlocks;

public class ExNihiloAELootTables extends LootTableGenerator {
    public ExNihiloAELootTables(DataGenerator generator) {
        super(generator);
    }

    @Override
    protected void createLootTables() {
        registerSelfDrop(ExNihiloAEBlocks.CRUSHED_SKYSTONE.get());
    }

    private void registerSelfDrop(Block block) {
        register(block, singleItem(block));
    }

    private void register(Block block, LootPool.Builder... pools) {
        LootTable.Builder builder = LootTable.builder();
        for(LootPool.Builder pool : pools) {
            builder.addLootPool(pool);
        }
        register(block, builder);
    }

    private void register(Block block, LootTable.Builder table) {
        register(block.getRegistryName(), table);
    }

    private void register(ResourceLocation registryName, LootTable.Builder table) {
        if(lootTables.put(toTableLoc(registryName), table.setParameterSet(LootParameterSets.BLOCK).build()) != null) {
            throw new IllegalStateException("Duplicate loot table: " + table);
        }
    }

    private ResourceLocation toTableLoc(ResourceLocation registryName) {
        return new ResourceLocation(registryName.getNamespace(), "blocks/" + registryName.getPath());
    }

    private LootPool.Builder singleItem(IItemProvider in) {
        return createLootPoolBuilder().rolls(ConstantRange.of(1)).addEntry(ItemLootEntry.builder(in));
    }

    private LootPool.Builder createLootPoolBuilder() {
        return LootPool.builder().acceptCondition(SurvivesExplosion.builder());
    }

    @Override
    public String getName() {
        return "Loot Tables: " + ExNihiloAEConstants.ModIds.EX_NIHILO_AE;
    }
}
