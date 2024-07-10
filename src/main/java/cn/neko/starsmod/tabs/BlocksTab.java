package cn.neko.starsmod.tabs;

import cn.neko.starsmod.blocks.BlockRegister;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class BlocksTab {
    private static final ItemGroup BLOCK_GROUP = FabricItemGroup.builder()
            .icon(() -> new ItemStack(BlockRegister.MOON_STONE))
            .displayName(Text.translatable("itemGroup.starsmod.block_tab"))
            .entries((context, entries) -> {
                entries.add(BlockRegister.MOON_STONE);
                entries.add(BlockRegister.MOON_SAND);
                entries.add(BlockRegister.LUNAR_ALLOY_ORE);
            })
            .build();

    public static void register(){
        Registry.register(Registries.ITEM_GROUP, new Identifier("starsmod", "block_group"), BLOCK_GROUP);
    }
}
