package foilfields.projectpinkmc.statuseffect;

import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;

public class PigEffect extends StatusEffect {
    protected PigEffect() {
        super(StatusEffectCategory.NEUTRAL, 0x000000);
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }
}
