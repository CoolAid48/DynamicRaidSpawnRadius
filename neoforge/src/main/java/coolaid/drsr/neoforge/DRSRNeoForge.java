package coolaid.drsr.neoforge;

import coolaid.drsr.DynamicRaidSpawnRadius;
import net.neoforged.fml.common.Mod;

@Mod(DynamicRaidSpawnRadius.MOD_ID)
public final class DRSRNeoForge {
    public DRSRNeoForge() {
        // Run our common setup.
        DynamicRaidSpawnRadius.init();
    }
}
