package coolaid.drsr.mixin;

import coolaid.drsr.DynamicRaidSpawnRadius;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.raid.Raid;
import net.minecraft.world.level.levelgen.Heightmap;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Optional;

@Mixin(Raid.class)
public abstract class RaidMixin {

    @Inject(
            method = "getValidSpawnPos",
            at = @At("HEAD"),
            cancellable = true
    )
    private void overrideRaidSpawnLocation(ServerLevel world, CallbackInfoReturnable<Optional<BlockPos>> cir) {
        int radius = DynamicRaidSpawnRadius.CONFIG.raidSpawnRadius;

        // Get raid center
        BlockPos center = ((Raid)(Object)this).getCenter(); // use accessor if private

        // Random offset around center
        float angle = world.random.nextFloat() * ((float)Math.PI * 2F);
        int offsetX = (int)(Mth.cos(angle) * radius);
        int offsetZ = (int)(Mth.sin(angle) * radius);

        BlockPos.MutableBlockPos spawnPos = center.mutable().move(offsetX, 0, offsetZ);

        // Snap to terrain height
        int topY = world.getHeightmapPos(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, new BlockPos(spawnPos.getX(), 0, spawnPos.getZ())).getY();
        spawnPos.setY(topY);

        cir.setReturnValue(Optional.of(spawnPos.immutable()));
        cir.cancel();
    }
}