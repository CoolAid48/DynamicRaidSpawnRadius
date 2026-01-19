package coolaid.drsr.neoforge;

import coolaid.drsr.DynamicRaidSpawnRadius;
import net.neoforged.fml.common.Mod;

@Mod(DynamicRaidSpawnRadius.MOD_ID)
public final class DynamicRaidSpawnRadiusNeoForge {
    public DynamicRaidSpawnRadiusNeoForge() {
        // Run our common setup.
        DynamicRaidSpawnRadius.init();
    }
}
