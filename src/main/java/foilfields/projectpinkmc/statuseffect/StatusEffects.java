package foilfields.projectpinkmc.statuseffect;

import foilfields.projectpinkmc.ProjectPinkSettings;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class StatusEffects {
    public static final StatusEffect PIG = register("pig", new PigEffect());

    private static StatusEffect register(String id, StatusEffect effect) {
        return Registry.register(Registry.STATUS_EFFECT, new Identifier(ProjectPinkSettings.MOD_ID, id), effect);
    }

    public static void init() {

    }
}
