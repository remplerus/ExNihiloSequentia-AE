package novamachina.exnihiloae.common.init;

import net.minecraftforge.eventbus.api.IEventBus;
import novamachina.exnihilosequentia.common.utility.ExNihiloLogger;
import org.apache.logging.log4j.LogManager;

public class ModInitialization {
    private static final ExNihiloLogger logger = new ExNihiloLogger(LogManager.getLogger());

    private ModInitialization() {
    }

    public static void init(IEventBus modEventBus) {
        logger.debug("Initializing modded items");
        ModBlocks.init(modEventBus);
        ModItems.init(modEventBus);
    }
}
