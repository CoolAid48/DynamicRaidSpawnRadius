package coolaid.drsr.compat;

import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry;

@Config(name = "drsr")
public class RaidConfig implements ConfigData {

    @ConfigEntry.Gui.Tooltip(count = 1)
    @ConfigEntry.BoundedDiscrete(min = 0, max = 96)
    public int raidSpawnRadius = 96; // Vanilla default is 96
}