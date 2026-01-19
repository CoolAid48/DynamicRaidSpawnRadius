package coolaid.drsr;

import coolaid.drsr.compat.RaidConfig;
import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.GsonConfigSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class DynamicRaidSpawnRadius {
    public static final String MOD_ID = "drsr";
    public static RaidConfig CONFIG;
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    public static void init() {
        // Register config
        AutoConfig.register(RaidConfig.class, GsonConfigSerializer::new);
        CONFIG = AutoConfig.getConfigHolder(RaidConfig.class).getConfig();
        LOGGER.info("Dynamic Raid Radius initialized!");
    }
}