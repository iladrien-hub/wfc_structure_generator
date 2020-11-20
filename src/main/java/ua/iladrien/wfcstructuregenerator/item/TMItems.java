package ua.iladrien.wfcstructuregenerator.item;

import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import ua.iladrien.wfcstructuregenerator.WFCStructureGenerator;
import ua.iladrien.wfcstructuregenerator.block.TMBlocks;

public class TMItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister
            .create(ForgeRegistries.ITEMS, WFCStructureGenerator.MODID);

    public static final RegistryObject<Item> STONE_STICK = ITEMS
            .register("stone_stick", () -> new StickSelectorItem(new Item.Properties().group(TMItemTabs.TEST_MOD_STONE_TAB)));

    public static final RegistryObject<Item> STONE_STICK_BLOCK = ITEMS
            .register("stone_stick_block", () -> new BlockItem(
                    TMBlocks.STONE_STICK_BLOCK.get(),
                    new Item.Properties().group(TMItemTabs.TEST_MOD_STONE_TAB)));
}
