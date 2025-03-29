package cn.neko.starsmod.common.blocks;

import cn.neko.starsmod.common.StarsMod;
import cn.neko.starsmod.common.blocks.customBlocks.PowerFurnaceBlock;
import cn.neko.starsmod.common.blocks.customBlocks.Rocket_t1_Block;
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
    public static final Block MARS_STONE = new Block(FabricBlockSettings.copy(Blocks.STONE));
    public static final Block MARS_SAND = new Block(FabricBlockSettings.copy(Blocks.SAND));
    public static final Block LUNAR_ALLOY_ORE = new Block(FabricBlockSettings.copy(Blocks.STONE));

    //特殊方块
    public static final Block ROCKET_T1 = new Rocket_t1_Block(FabricBlockSettings.copy(Blocks.STONE));
    public static final Block POWER_FURNACE = new PowerFurnaceBlock();

    public static void register() {
        //注册方块
        Registry.register(Registries.BLOCK, new Identifier(StarsMod.MOD_ID, "moon_stone"), MOON_STONE);
        Registry.register(Registries.BLOCK, new Identifier(StarsMod.MOD_ID, "moon_sand"), MOON_SAND);
        Registry.register(Registries.BLOCK, new Identifier(StarsMod.MOD_ID, "mars_stone"), MARS_STONE);
        Registry.register(Registries.BLOCK, new Identifier(StarsMod.MOD_ID, "mars_sand"), MARS_SAND);
        Registry.register(Registries.BLOCK, new Identifier(StarsMod.MOD_ID, "lunar_alloy_ore"), LUNAR_ALLOY_ORE);

        //注册特殊方块
        Registry.register(Registries.BLOCK, new Identifier(StarsMod.MOD_ID, "rocket_t1"), ROCKET_T1);
        Registry.register(Registries.BLOCK, new Identifier(StarsMod.MOD_ID, "power_furnace"), POWER_FURNACE);

        //注册方块物品
        Registry.register(Registries.ITEM, new Identifier(StarsMod.MOD_ID, "moon_stone"), new BlockItem(MOON_STONE, new Item.Settings()));
        Registry.register(Registries.ITEM, new Identifier(StarsMod.MOD_ID, "moon_sand"), new BlockItem(MOON_SAND, new Item.Settings()));
        Registry.register(Registries.ITEM, new Identifier(StarsMod.MOD_ID, "mars_stone"), new BlockItem(MARS_STONE, new Item.Settings()));
        Registry.register(Registries.ITEM, new Identifier(StarsMod.MOD_ID, "mars_sand"), new BlockItem(MARS_SAND, new Item.Settings()));
        Registry.register(Registries.ITEM, new Identifier(StarsMod.MOD_ID, "lunar_alloy_ore"), new BlockItem(LUNAR_ALLOY_ORE, new Item.Settings()));
        Registry.register(Registries.ITEM, new Identifier(StarsMod.MOD_ID, "rocket_t1"), new BlockItem(ROCKET_T1, new Item.Settings()));
        Registry.register(Registries.ITEM, new Identifier(StarsMod.MOD_ID, "power_furnace"), new BlockItem(POWER_FURNACE, new Item.Settings()));
    }
}
