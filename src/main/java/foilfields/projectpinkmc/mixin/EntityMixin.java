package foilfields.projectpinkmc.mixin;

import foilfields.projectpinkmc.statuseffect.StatusEffects;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.command.CommandOutput;
import net.minecraft.util.Nameable;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.entity.EntityLike;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Entity.class)
public abstract class EntityMixin implements Nameable, EntityLike, CommandOutput {
    @Shadow private Vec3d pos;

    @Inject(method = "getStandingEyeHeight", at = @At("HEAD"), cancellable = true)
    public final void getStandingEyeHeight(CallbackInfoReturnable<Float> cir) {
        if (isPig()) cir.setReturnValue(EntityType.PIG.getHeight() * 0.85f);
    }

    @Inject(method = "getEyeY", at = @At("HEAD"), cancellable = true)
    public void getEyeY(CallbackInfoReturnable<Double> cir) {
        if (isPig()) cir.setReturnValue((double) (EntityType.PIG.getHeight() * 0.85f) + this.pos.y);
    }

    private boolean isPig() {
        if ((Object)this instanceof PlayerEntity) {
            PlayerEntity player = (PlayerEntity)(Object)this;
            if (player.getActiveStatusEffects() != null && player.hasStatusEffect(StatusEffects.PIG)) return true;
        }
        return false;
    }
}
