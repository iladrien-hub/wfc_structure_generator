package ua.iladrien.wfcstructuregenerator;

import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ua.iladrien.wfcstructuregenerator.block.TMBlocks;
import ua.iladrien.wfcstructuregenerator.item.TMItems;
import ua.iladrien.wfcstructuregenerator.structuregen.tile.tiles.Tiles;

@Mod(WFCStructureGenerator.MODID)
@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class WFCStructureGenerator {

    public static final String MODID = "wfcstructuregenerator";

    public static final Logger LOGGER = LogManager.getLogger();

    public static final boolean DebugMode = true;

    public static void log (Level level, String message) {
        LOGGER.log(level,"[ WFC Structure Generator ]: " + message);
    }

    public static void log (String message) {
        LOGGER.log(Level.DEBUG,"[ WFC Structure Generator ]: " + message);
    }

    public WFCStructureGenerator() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        Tiles.registerVariants();
        TMItems.ITEMS.register(bus);
        TMBlocks.BLOCKS.register(bus);
    }
}
