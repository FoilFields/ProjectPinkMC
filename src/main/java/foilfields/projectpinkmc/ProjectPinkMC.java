package foilfields.projectpinkmc;

import foilfields.projectpinkmc.block.Blocks;
import foilfields.projectpinkmc.foodcomponent.FoodComponents;
import foilfields.projectpinkmc.item.Items;
import foilfields.projectpinkmc.statuseffect.StatusEffects;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ProjectPinkMC implements ModInitializer {
    public static final Logger LOGGER = LoggerFactory.getLogger("projectpinkmc");
    public static ItemGroup CREATIVE_GROUP = FabricItemGroupBuilder.build(new Identifier(ProjectPinkSettings.MOD_ID, ProjectPinkSettings.MOD_ID), () -> new ItemStack(Items.SOUL_SHEARS));


    @Override
    public void onInitialize() {
        Items.init();
        StatusEffects.init();
        FoodComponents.init();
        Blocks.init();
        LOGGER.info("Project Pink Enabled!");
    }
}

