package foilfields.projectpinkmc;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;

import java.util.Hashtable;

public class PlayerPigManager {
    private static Hashtable<LivingEntity, LivingEntity> pigDisguises = new Hashtable<>();

    public static LivingEntity getPig(LivingEntity entity) {
        if (!pigDisguises.contains(entity)) {
            LivingEntity pig = EntityType.PIG.create(entity.world);
            pigDisguises.put(entity, pig);
            return pig;
        }

        return pigDisguises.get(entity);
    }
}
