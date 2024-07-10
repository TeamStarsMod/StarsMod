package cn.neko.starsmod.items;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ItemRegister {
    public static final Item FAN_BLADE = new Item(new FabricItemSettings());
    public static final Item SMALL_BATTERY = new Item(new FabricItemSettings());

    public static void register(){
        Registry.register(Registries.ITEM, new Identifier("starsmod", "fan_blade"), FAN_BLADE);
        Registry.register(Registries.ITEM, new Identifier("starsmod", "small_battery"), SMALL_BATTERY);
    }
}
