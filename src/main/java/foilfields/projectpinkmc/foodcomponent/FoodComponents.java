package foilfields.projectpinkmc.foodcomponent;

import foilfields.projectpinkmc.statuseffect.StatusEffects;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.item.FoodComponent;

public class FoodComponents {
    public static final FoodComponent PIG_POLYMORPH = new FoodComponent.Builder().hunger(3).statusEffect(new StatusEffectInstance(StatusEffects.PIG, 600, 0), 1.0f).saturationModifier(0.1f).build();
    public static final FoodComponent NIGHTSHADE_BERRIES = new FoodComponent.Builder().hunger(2).saturationModifier(0.1f).build();

    public static void init() {

    }
}
