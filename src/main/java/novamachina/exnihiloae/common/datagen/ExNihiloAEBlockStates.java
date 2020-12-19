package novamachina.exnihiloae.common.datagen;

import net.minecraft.block.Block;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import novamachina.exnihiloae.common.init.ExNihiloAEBlocks;
import novamachina.exnihiloae.common.utility.ExNihiloAEConstants;

public class ExNihiloAEBlockStates extends BlockStateProvider {
    public ExNihiloAEBlockStates(DataGenerator gen, ExistingFileHelper exFileHelper) {
        super(gen, ExNihiloAEConstants.ModIds.EX_NIHILO_AE, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        basicBlock(ExNihiloAEBlocks.CRUSHED_SKYSTONE.get());
    }

    private void basicBlock(Block block) {
        simpleItemBlock(block, cubeAll(block));
    }

    private void simpleItemBlock(Block block, ModelFile modelFile) {
        simpleBlock(block, modelFile);
        simpleBlockItem(block, modelFile);
    }
}
