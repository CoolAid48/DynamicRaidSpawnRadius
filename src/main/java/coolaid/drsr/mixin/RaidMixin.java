package coolaid.drsr.mixins;

import coolaid.drsr.DynamicRaidSpawnRadius;
import net.minecraft.village.raid.Raid;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;


@Mixin(Raid.class)
class RaidMixin {
    @Inject(method = "getRaidSpawnRadius", at = @At("HEAD"), cancellable = true)
    private void injected(CallbackInfoReturnable<Integer> cir) {
        cir.setReturnValue(DynamicRaidSpawnRadius.CONFIG.raidSpawnRadius);
    }
}