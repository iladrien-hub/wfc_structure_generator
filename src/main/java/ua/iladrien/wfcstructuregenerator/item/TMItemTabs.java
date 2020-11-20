package ua.iladrien.wfcstructuregenerator.item;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class TMItemTabs {
    public static final ItemGroup TEST_MOD_STONE_TAB = new TMItemTab("test_mod_stone_tab", () -> new ItemStack(TMItems.STONE_STICK.get()));
}
