package novamachina.exnihiloae.common.init;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import novamachina.exnihiloae.common.utility.Constants;
import novamachina.exnihilosequentia.common.block.BaseFallingBlock;
import novamachina.exnihilosequentia.common.builder.BlockBuilder;
import novamachina.exnihilosequentia.common.utility.ExNihiloLogger;
import org.apache.logging.log4j.LogManager;

public class ModBlocks {
    private static final ExNihiloLogger logger = new ExNihiloLogger(LogManager.getLogger());
    private static final DeferredRegister<Block> BLOCKS = DeferredRegister
        .create(ForgeRegistries.BLOCKS, Constants.ModIds.EX_NIHILO_AE);
    public static final RegistryObject<BaseFallingBlock> CRUSHED_SKYSTONE = BLOCKS
        .register(Constants.Blocks.CRUSHED_SKYSTONE, () -> new BaseFallingBlock(new BlockBuilder()
            .properties(Block.Properties.create(Material.SAND).hardnessAndResistance(0.7F)
                .sound(SoundType.GROUND)).harvestLevel(ToolType.SHOVEL, 0)));
    private ModBlocks() {
    }

    public static void init(IEventBus modEventBus) {
        logger.debug("Register blocks");
        BLOCKS.register(modEventBus);
    }
}
