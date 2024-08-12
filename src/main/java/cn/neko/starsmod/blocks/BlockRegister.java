package cn.neko.starsmod.blocks;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

/**
 * 注册方块类
 */
public class BlockRegister {
    //方块
    public static final Block MOON_STONE = new Block(FabricBlockSettings.copy(Blocks.STONE));
    public static final Block MOON_SAND = new Block(FabricBlockSettings.copy(Blocks.SAND));
    public static final Block LUNAR_ALLOY_ORE = new Block(FabricBlockSettings.copy(Blocks.STONE));

    public static void register() {
        //注册方块
        Registry.register(Registries.BLOCK, new Identifier("starsmod", "moon_stone"), MOON_STONE);
        Registry.register(Registries.BLOCK, new Identifier("starsmod", "moon_sand"), MOON_SAND);
        Registry.register(Registries.BLOCK, new Identifier("starsmod", "lunar_alloy_ore"), LUNAR_ALLOY_ORE);

        //注册方块物品
        Registry.register(Registries.ITEM, new Identifier("starsmod", "moon_stone"), new BlockItem(MOON_STONE, new Item.Settings()));
        Registry.register(Registries.ITEM, new Identifier("starsmod", "moon_sand"), new BlockItem(MOON_SAND, new Item.Settings()));
        Registry.register(Registries.ITEM, new Identifier("starsmod", "lunar_alloy_ore"), new BlockItem(LUNAR_ALLOY_ORE, new Item.Settings()));
    }
}
