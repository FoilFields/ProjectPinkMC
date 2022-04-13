package foilfields.projectpinkmc.mixin;

import foilfields.projectpinkmc.statuseffect.StatusEffects;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(PlayerEntity.class)
public abstract class PlayerEntityMixin extends LivingEntity {

    @Shadow public abstract boolean isPlayer();

    protected PlayerEntityMixin(EntityType<? extends LivingEntity> entityType, World world) {
        super(entityType, world);
    }

    @Inject(method = "getHurtSound", at = @At("HEAD"), cancellable = true)
    public void getHurtSound(DamageSource source, CallbackInfoReturnable<SoundEvent> cir) {
        if (this.hasStatusEffect(StatusEffects.PIG))
        cir.setReturnValue(SoundEvents.ENTITY_PIG_HURT);
    }

    @Inject(method = "getDeathSound", at = @At("HEAD"), cancellable = true)
    public void getDeathSound(CallbackInfoReturnable<SoundEvent> cir) {
        if (this.hasStatusEffect(StatusEffects.PIG))
        cir.setReturnValue(SoundEvents.ENTITY_PIG_DEATH);
    }
}
