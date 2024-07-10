package cn.neko.starsmod.items;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ItemRegister {
    public static final Item FAN_BLADE = new Item(new FabricItemSettings());
    public static final Item SMALL_BATTERY = new Item(new FabricItemSettings());
    public static final Item FILTER = new Item(new FabricItemSettings());
    public static final Item IRON_PLATE = new Item(new FabricItemSettings());
    public static final Item IRON_RING = new Item(new FabricItemSettings());
    public static final Item BEARING = new Item(new FabricItemSettings());
    public static final Item STEEL_BALL = new Item(new FabricItemSettings());
    public static final Item HIGH_PRESSURE_TANK = new Item(new FabricItemSettings());
    public static final Item LUNAR_ALLOY = new Item(new FabricItemSettings());
    public static final Item LUNAR_ALLOY_INGOT = new Item(new FabricItemSettings());

    public static void register(){
        Registry.register(Registries.ITEM, new Identifier("starsmod", "fan_blade"), FAN_BLADE);
        Registry.register(Registries.ITEM, new Identifier("starsmod", "small_battery"), SMALL_BATTERY);
        Registry.register(Registries.ITEM, new Identifier("starsmod", "filter"), FILTER);
        Registry.register(Registries.ITEM, new Identifier("starsmod", "iron_plate"), IRON_PLATE);
        Registry.register(Registries.ITEM, new Identifier("starsmod", "iron_ring"), IRON_RING);
        Registry.register(Registries.ITEM, new Identifier("starsmod", "bearing"), BEARING);
        Registry.register(Registries.ITEM, new Identifier("starsmod", "steel_ball"), STEEL_BALL);
        Registry.register(Registries.ITEM, new Identifier("starsmod", "high_pressure_tank"), HIGH_PRESSURE_TANK);
        Registry.register(Registries.ITEM, new Identifier("starsmod", "lunar_alloy"), LUNAR_ALLOY);
        Registry.register(Registries.ITEM, new Identifier("starsmod", "lunar_alloy_ingot"), LUNAR_ALLOY_INGOT);
    }
}
