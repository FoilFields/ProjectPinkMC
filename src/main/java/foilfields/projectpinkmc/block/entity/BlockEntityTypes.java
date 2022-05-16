package foilfields.projectpinkmc.block.entity;

import foilfields.projectpinkmc.ProjectPinkSettings;
import foilfields.projectpinkmc.block.Blocks;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class BlockEntityTypes {
    public static final BlockEntityType<DicerBlockEntity> DICER_BLOCK_ENTITY = Register("dicer", FabricBlockEntityTypeBuilder.create(DicerBlockEntity::new, Blocks.DICER).build(null));

    private static BlockEntityType Register(String id, BlockEntityType<? extends BlockEntity> blockEntity) {
        return Registry.register(Registry.BLOCK_ENTITY_TYPE, new Identifier(ProjectPinkSettings.MOD_ID, id), blockEntity);
    }

    public static void init() {

    }
}
