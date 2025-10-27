package cn.neko.starsmod.common.items;

import cn.neko.starsmod.common.StarsMod;
import cn.neko.starsmod.common.armor.SpaceSuitMaterial;
import cn.neko.starsmod.common.items.customItems.TestItem;
import cn.neko.starsmod.common.items.customItems.oxygenTanks.LowOxygenTankItem;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

/**
 * 注册物品
 */
public class ItemRegister {
    //ArmorItems
    public static final Item SPACE_HELMET = new ArmorItem(SpaceSuitMaterial.spaceSuit, ArmorItem.Type.HELMET, new FabricItemSettings());
    public static final Item SPACE_CHESTPLATE = new ArmorItem(SpaceSuitMaterial.spaceSuit, ArmorItem.Type.CHESTPLATE, new FabricItemSettings());
    public static final Item SPACE_LEGGINGS = new ArmorItem(SpaceSuitMaterial.spaceSuit, ArmorItem.Type.LEGGINGS, new FabricItemSettings());
    public static final Item SPACE_BOOTS = new ArmorItem(SpaceSuitMaterial.spaceSuit, ArmorItem.Type.BOOTS, new FabricItemSettings());
    //Items
    public static final Item FAN_BLADE = new Item(new FabricItemSettings());
    public static final Item SMALL_BATTERY = new Item(new FabricItemSettings());
    public static final Item FILTER = new Item(new FabricItemSettings());
    public static final Item IRON_PLATE = new Item(new FabricItemSettings());
    public static final Item IRON_RING = new Item(new FabricItemSettings());
    public static final Item BEARING = new Item(new FabricItemSettings());
    public static final Item STEEL_BALL = new Item(new FabricItemSettings());
    public static final Item LOW_OXYGEN_TANKS = new LowOxygenTankItem(new FabricItemSettings());
    public static final Item LUNAR_ALLOY = new Item(new FabricItemSettings());
    public static final Item LUNAR_ALLOY_INGOT = new Item(new FabricItemSettings());
    // Tests
    public static final Item TEST_ITEM = new TestItem(new FabricItemSettings());

    public static void register(){
        Registry.register(Registries.ITEM, new Identifier(StarsMod.MOD_ID, "space_helmet"), SPACE_HELMET);
        Registry.register(Registries.ITEM, new Identifier(StarsMod.MOD_ID, "space_chestplate"), SPACE_CHESTPLATE);
        Registry.register(Registries.ITEM, new Identifier(StarsMod.MOD_ID, "space_leggings"), SPACE_LEGGINGS);
        Registry.register(Registries.ITEM, new Identifier(StarsMod.MOD_ID, "space_boots"), SPACE_BOOTS);

        Registry.register(Registries.ITEM, new Identifier(StarsMod.MOD_ID, "fan_blade"), FAN_BLADE);
        Registry.register(Registries.ITEM, new Identifier(StarsMod.MOD_ID, "small_battery"), SMALL_BATTERY);
        Registry.register(Registries.ITEM, new Identifier(StarsMod.MOD_ID, "filter"), FILTER);
        Registry.register(Registries.ITEM, new Identifier(StarsMod.MOD_ID, "iron_plate"), IRON_PLATE);
        Registry.register(Registries.ITEM, new Identifier(StarsMod.MOD_ID, "iron_ring"), IRON_RING);
        Registry.register(Registries.ITEM, new Identifier(StarsMod.MOD_ID, "bearing"), BEARING);
        Registry.register(Registries.ITEM, new Identifier(StarsMod.MOD_ID, "steel_ball"), STEEL_BALL);
        Registry.register(Registries.ITEM, new Identifier(StarsMod.MOD_ID, "low_oxygen_tanks"), LOW_OXYGEN_TANKS);
        Registry.register(Registries.ITEM, new Identifier(StarsMod.MOD_ID, "lunar_alloy"), LUNAR_ALLOY);
        Registry.register(Registries.ITEM, new Identifier(StarsMod.MOD_ID, "lunar_alloy_ingot"), LUNAR_ALLOY_INGOT);

        Registry.register(Registries.ITEM, new Identifier(StarsMod.MOD_ID, "test_item"), TEST_ITEM);
    }
}
