package foilfields.projectpinkmc.statuseffect;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.AttributeContainer;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import virtuoel.pehkui.api.ScaleData;
import virtuoel.pehkui.api.ScaleTypes;

public class PigEffect extends StatusEffect {
    ScaleData scaleDataWidth, scaleDataHeight, scaleDataEyeHeight;

    protected PigEffect() {
        super(StatusEffectCategory.NEUTRAL, 0x000000);
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }

    @Override
    public void onRemoved(LivingEntity entity, AttributeContainer attributes, int amplifier) {
        scaleDataWidth.setScale(1);
        scaleDataHeight.setScale(1);
        scaleDataEyeHeight.setScale(1);
    }

    @Override
    public void onApplied(LivingEntity entity, AttributeContainer attributes, int amplifier) {
        scaleDataWidth = ScaleData.Builder.create().entity(entity).type(ScaleTypes.HITBOX_WIDTH).build();
        scaleDataHeight = ScaleData.Builder.create().entity(entity).type(ScaleTypes.HITBOX_HEIGHT).build();
        scaleDataEyeHeight = ScaleData.Builder.create().entity(entity).type(ScaleTypes.EYE_HEIGHT).build();

        float heightScale = EntityType.PIG.getHeight() / EntityType.PLAYER.getHeight();

        scaleDataWidth.setScale(EntityType.PIG.getWidth() / EntityType.PLAYER.getWidth());
        scaleDataHeight.setScale(heightScale);
        scaleDataEyeHeight.setScale(heightScale);
    }
}
