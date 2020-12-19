package novamachina.exnihiloae;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import novamachina.exnihiloae.common.init.ModInitialization;
import novamachina.exnihiloae.common.utility.Constants;
import novamachina.exnihilosequentia.common.utility.ExNihiloLogger;
import org.apache.logging.log4j.LogManager;

@Mod(Constants.ModIds.EX_NIHILO_AE)
public class ExNihiloAE {
    private static final ExNihiloLogger logger = new ExNihiloLogger(LogManager.getLogger());

    public ExNihiloAE() {
        logger.debug("Starting Ex Nihilo: Sequentia - AE2 Addon");
        ModInitialization.init(FMLJavaModLoadingContext.get().getModEventBus());
    }
}
