package foilfields.projectpinkmc.block;

import foilfields.projectpinkmc.ProjectPinkSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class Blocks {
    public static final Block NIGHTSHADE_BUSH = Blocks.register("nightshade_bush", new NightshadeBushBlock(AbstractBlock.Settings.of(Material.PLANT).ticksRandomly().noCollision().sounds(BlockSoundGroup.SWEET_BERRY_BUSH)));
    public static final Block DICER = register("dicer", new Block(FabricBlockSettings.of(Material.STONE).strength(4.0f).requiresTool()));

    private static Block register(String id, Block block) {
        return Registry.register(Registry.BLOCK, new Identifier(ProjectPinkSettings.MOD_ID, id), block);
    }

    public static void init() {

    }
}
