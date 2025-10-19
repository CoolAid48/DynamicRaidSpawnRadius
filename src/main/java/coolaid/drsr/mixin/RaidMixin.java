package coolaid.drsr.mixin;

import coolaid.drsr.DynamicRaidSpawnRadius;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockPos.Mutable;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.Heightmap;
import net.minecraft.village.raid.Raid;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Optional;

@Mixin(Raid.class)
public abstract class RaidMixin {

    @Inject(
            method = "getRaidersSpawnLocation",
            at = @At("HEAD"),
            cancellable = true
    )
    private void overrideRaidSpawnLocation(ServerWorld world, CallbackInfoReturnable<Optional<BlockPos>> cir) {
        int radius = DynamicRaidSpawnRadius.CONFIG.raidSpawnRadius;

        // Get raid center
        BlockPos center = ((Raid)(Object)this).getCenter(); // use accessor if private

        // Random offset around center
        float angle = world.random.nextFloat() * ((float)Math.PI * 2F);
        int offsetX = (int)(MathHelper.cos(angle) * radius);
        int offsetZ = (int)(MathHelper.sin(angle) * radius);

        Mutable spawnPos = center.mutableCopy().move(offsetX, 0, offsetZ);

        // Snap to terrain height
        int topY = world.getTopY(Heightmap.Type.WORLD_SURFACE_WG, spawnPos.getX(), spawnPos.getZ());
        spawnPos.setY(topY);

        cir.setReturnValue(Optional.of(spawnPos.toImmutable()));
        cir.cancel();
    }
}