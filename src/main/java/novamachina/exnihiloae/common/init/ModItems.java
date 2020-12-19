package novamachina.exnihiloae.common.init;

import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import novamachina.exnihiloae.common.utility.Constants;
import novamachina.exnihilosequentia.common.init.ModInitialization;
import novamachina.exnihilosequentia.common.utility.ExNihiloLogger;
import org.apache.logging.log4j.LogManager;

public class ModItems {
    private static final ExNihiloLogger logger = new ExNihiloLogger(LogManager.getLogger());
    private static final DeferredRegister<Item> ITEMS = DeferredRegister.create(
        ForgeRegistries.ITEMS, Constants.ModIds.EX_NIHILO_AE);
    public static final RegistryObject<Item> CRUSHED_SKYSTONE = ITEMS
        .register(Constants.Blocks.CRUSHED_SKYSTONE,
            () -> new BlockItem(ModBlocks.CRUSHED_SKYSTONE.get(),
                new Item.Properties().group(ModInitialization.ITEM_GROUP)));
    private ModItems() {
    }

    public static void init(IEventBus modEventBus) {
        logger.debug("Register items");
        ITEMS.register(modEventBus);
    }

}
