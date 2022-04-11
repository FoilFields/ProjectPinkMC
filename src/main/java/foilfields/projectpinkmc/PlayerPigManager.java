package foilfields.projectpinkmc;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;

import java.util.Hashtable;

public class PlayerPigManager {
    private static Hashtable<LivingEntity, LivingEntity> pigDisguises = new Hashtable<>();

    public static LivingEntity getPig(LivingEntity player) {
        if (!pigDisguises.contains(player)) {
            LivingEntity pig = EntityType.PIG.create(player.world);
            pigDisguises.put(player, pig);
            return pig;
        }
        LivingEntity pig = pigDisguises.get(player);

        return pig;
    }
}
