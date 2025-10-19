package coolaid.drsr;

import coolaid.drsr.compat.RaidConfig;
import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.GsonConfigSerializer;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DynamicRaidSpawnRadius implements ModInitializer {
    public static final String MOD_ID = "Dynamic Raid Spawn Radius";
    public static RaidConfig CONFIG;
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        // Register config
        AutoConfig.register(RaidConfig.class, GsonConfigSerializer::new);
        CONFIG = AutoConfig.getConfigHolder(RaidConfig.class).getConfig();
        LOGGER.info("Dynamic Spawn Radius initialized!");
    }
}