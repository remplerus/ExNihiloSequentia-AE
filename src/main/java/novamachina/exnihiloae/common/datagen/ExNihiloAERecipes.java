package novamachina.exnihiloae.common.datagen;

import appeng.core.Api;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.IFinishedRecipe;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.crafting.Ingredient;
import novamachina.exnihiloae.common.init.ExNihiloAEBlocks;
import novamachina.exnihiloae.common.utility.ExNihiloAEConstants;
import novamachina.exnihilosequentia.api.crafting.fluiditem.FluidItemRecipeBuilder;
import novamachina.exnihilosequentia.api.crafting.hammer.HammerRecipeBuilder;
import novamachina.exnihilosequentia.api.crafting.sieve.MeshWithChance;
import novamachina.exnihilosequentia.api.crafting.sieve.SieveRecipeBuilder;
import novamachina.exnihilosequentia.api.datagen.AbstractRecipeGenerator;
import novamachina.exnihilosequentia.common.init.ExNihiloBlocks;
import novamachina.exnihilosequentia.common.item.mesh.EnumMesh;

import java.util.function.Consumer;

public class ExNihiloAERecipes extends AbstractRecipeGenerator {
    public ExNihiloAERecipes(DataGenerator generator) {
        super(generator, ExNihiloAEConstants.ModIds.EX_NIHILO_AE);
    }

    @Override
    protected void registerRecipes(Consumer<IFinishedRecipe> consumer) {
        registerSieveRecipes(consumer);
        registerFluidItemRecipes(consumer);
        registerHammerRecipes(consumer);
    }

    private void registerHammerRecipes(Consumer<IFinishedRecipe> consumer) {
        HammerRecipeBuilder.builder().input(Api.instance().definitions().blocks().skyStoneBlock().block())
            .result(ExNihiloAEBlocks.CRUSHED_SKYSTONE.get())
            .build(consumer, hammerLoc(ExNihiloAEConstants.Blocks.CRUSHED_SKYSTONE));
    }

    private void registerFluidItemRecipes(Consumer<IFinishedRecipe> consumer) {
        FluidItemRecipeBuilder.builder().fluidInBarrel(Fluids.LAVA)
            .input(Api.instance().definitions().materials().skyDust())
            .result(Api.instance().definitions().blocks().skyStoneBlock())
            .build(consumer, fluidItemLoc("sky_stone"));
    }

    private void registerSieveRecipes(Consumer<IFinishedRecipe> consumer) {
        SieveRecipeBuilder.builder().input(Ingredient.fromItems(ExNihiloBlocks.DUST.get()))
            .drop(Api.instance().definitions().materials().skyDust())
            .addRoll(new MeshWithChance(EnumMesh.FLINT, 0.1F))
            .addRoll(new MeshWithChance(EnumMesh.IRON, 0.2F))
            .addRoll(new MeshWithChance(EnumMesh.DIAMOND, 0.3F))
            .build(consumer, sieveLoc("sky_dust"));

        SieveRecipeBuilder.builder().input(Ingredient.fromItems(ExNihiloBlocks.DUST.get()))
            .drop(Api.instance().definitions().materials().certusQuartzDust())
            .addRoll(new MeshWithChance(EnumMesh.IRON, 0.15F))
            .build(consumer, sieveLoc("certus_dust"));

        SieveRecipeBuilder.builder().input(Ingredient.fromItems(ExNihiloAEBlocks.CRUSHED_SKYSTONE.get()))
            .drop(Api.instance().definitions().materials().certusQuartzCrystal())
            .addRoll(new MeshWithChance(EnumMesh.IRON, 0.7F))
            .addRoll(new MeshWithChance(EnumMesh.DIAMOND, 0.8F))
            .build(consumer, sieveLoc("certus_quartz"));

        SieveRecipeBuilder.builder().input(Ingredient.fromItems(ExNihiloAEBlocks.CRUSHED_SKYSTONE.get()))
            .drop(Api.instance().definitions().materials().certusQuartzCrystalCharged())
            .addRoll(new MeshWithChance(EnumMesh.DIAMOND, 0.1F))
            .build(consumer, sieveLoc("charged_certus_quartz"));

        SieveRecipeBuilder.builder().input(Ingredient.fromItems(ExNihiloAEBlocks.CRUSHED_SKYSTONE.get()))
            .drop(Api.instance().definitions().items().certusCrystalSeed())
            .addRoll(new MeshWithChance(EnumMesh.STRING, 0.35F))
            .build(consumer, sieveLoc("certus_seed"));

        SieveRecipeBuilder.builder().input(Ingredient.fromItems(ExNihiloAEBlocks.CRUSHED_SKYSTONE.get()))
            .drop(Api.instance().definitions().items().netherQuartzSeed())
            .addRoll(new MeshWithChance(EnumMesh.FLINT, 0.45F))
            .build(consumer, sieveLoc("nether_quartz_seed"));

        SieveRecipeBuilder.builder().input(Ingredient.fromItems(ExNihiloBlocks.DUST.get()))
            .drop(Api.instance().definitions().materials().fluixDust())
            .addRoll(new MeshWithChance(EnumMesh.DIAMOND, 0.03F))
            .addRoll(new MeshWithChance(EnumMesh.EMERALD, 0.06F))
            .build(consumer, sieveLoc("fluix_dust"));

        SieveRecipeBuilder.builder().input(Ingredient.fromItems(ExNihiloBlocks.DUST.get()))
            .drop(Api.instance().definitions().materials().netherQuartzDust())
            .addRoll(new MeshWithChance(EnumMesh.DIAMOND, 0.05F))
            .addRoll(new MeshWithChance(EnumMesh.EMERALD, 0.1F))
            .build(consumer, sieveLoc("nether_quartz_dust"));
    }
}
