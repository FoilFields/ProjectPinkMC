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

@Mixin(PlayerEntity.class)
public abstract class PlayerEntityMixin extends LivingEntity {

    protected PlayerEntityMixin(EntityType<? extends LivingEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    public SoundEvent getHurtSound(DamageSource source) {
        if (this.hasStatusEffect(StatusEffects.PIG))
        return SoundEvents.ENTITY_PIG_HURT;

        return super.getHurtSound(source);
    }

    @Override
    public SoundEvent getDeathSound() {
        if (this.hasStatusEffect(StatusEffects.PIG))
        return SoundEvents.ENTITY_PIG_DEATH;

        return super.getDeathSound();

    }
}
