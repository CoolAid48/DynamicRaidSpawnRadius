package coolaid.drsr.compat;

import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.ConfigEntry;
import net.minecraft.util.math.MathHelper;

public class RaidSpawnRadiusConfig implements ConfigData {
    @ConfigEntry.Gui.Tooltip
    @ConfigEntry.BoundedDiscrete(min = 0, max = 256)
    private int firstPhaseRadius = 64;

    @ConfigEntry.Gui.Tooltip
    @ConfigEntry.BoundedDiscrete(min = 0, max = 256)
    private int secondPhaseRadius = 32;

    @ConfigEntry.Gui.Tooltip
    @ConfigEntry.BoundedDiscrete(min = 0, max = 256)
    private int thirdPhaseRadius = 0;

    @ConfigEntry.Gui.Tooltip
    private boolean enableCustomRadii = true;

    // Getters and setters
    public int getFirstPhaseRadius() {
        return enableCustomRadii ? firstPhaseRadius : 64;
    }

    public void setFirstPhaseRadius(int radius) {
        this.firstPhaseRadius = MathHelper.clamp(radius, 0, 256);
    }

    // Similar getters/setters for other radii
}