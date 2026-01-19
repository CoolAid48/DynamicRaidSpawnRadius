package coolaid.drsr.neoforge;

import coolaid.drsr.DynamicRaidSpawnRadius;
import coolaid.drsr.compat.RaidConfig;
import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.GsonConfigSerializer;
import net.neoforged.fml.ModLoadingContext;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.client.gui.ConfigurationScreen;
import net.neoforged.neoforge.client.gui.IConfigScreenFactory;

@Mod(DynamicRaidSpawnRadius.MOD_ID)
public final class DRSRNeoForge {

    public DRSRNeoForge() {
        // Run our common setup.
        DynamicRaidSpawnRadius.init();

        // Auto-Config for NeoForge's built-in mods menu
        ModLoadingContext.get().registerExtensionPoint(
                IConfigScreenFactory.class,
                () -> (modContainer, parentScreen) -> AutoConfig.getConfigScreen(RaidConfig.class, parentScreen).get()
        );
    }
}
