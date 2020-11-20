package ua.iladrien.wfcstructuregenerator.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import ua.iladrien.wfcstructuregenerator.WFCStructureGenerator;

public class TMBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister
            .create(ForgeRegistries.BLOCKS, WFCStructureGenerator.MODID);

    public static final RegistryObject<Block> STONE_STICK_BLOCK = BLOCKS
            .register("stone_stick_block", () -> new Block(Block.Properties
                    .create(Material.ROCK)
                    .hardnessAndResistance(3.0F, 3.0F)
                    .harvestTool(ToolType.PICKAXE)
            ));
}
