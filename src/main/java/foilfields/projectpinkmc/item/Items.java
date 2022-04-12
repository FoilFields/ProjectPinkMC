package foilfields.projectpinkmc.item;

import foilfields.projectpinkmc.ProjectPinkMC;
import foilfields.projectpinkmc.ProjectPinkSettings;
import net.minecraft.item.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class Items {
    public static final Item VIAL = register("vial", new Item(new Item.Settings().group(ProjectPinkMC.CREATIVE_GROUP)));
    public static final Item PIG_POLYMORPH = register("pig_polymorph", new PigPolymorph(new Item.Settings().recipeRemainder(VIAL).food(FoodComponents.APPLE).group(ProjectPinkMC.CREATIVE_GROUP).maxCount(16)));
    public static final Item SOUL_SHEARS = register("soul_shears", new SoulShears(new Item.Settings().maxDamage(25).group(ProjectPinkMC.CREATIVE_GROUP)));
    public static final Item PIG_SOUL = register("pig_soul", new Item(new Item.Settings().group(ProjectPinkMC.CREATIVE_GROUP)));

    private static Item register(String id, Item item) {
        return register(new Identifier(ProjectPinkSettings.MOD_ID, id), item);
    }

    private static Item register(Identifier id, Item item) {
        if (item instanceof BlockItem) {
            ((BlockItem)item).appendBlocks(Item.BLOCK_ITEMS, item);
        }
        ProjectPinkMC.LOGGER.info("Registered " + id);
        return Registry.register(Registry.ITEM, id, item);
    }

    public static void init() {

    }
}
