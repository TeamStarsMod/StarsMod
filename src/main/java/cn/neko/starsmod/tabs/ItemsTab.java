package cn.neko.starsmod.tabs;

import cn.neko.starsmod.items.ItemRegister;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ItemsTab {
    private static final ItemGroup ITEM_GROUP = FabricItemGroup.builder()
            .icon(() -> new ItemStack(ItemRegister.FAN_BLADE))
            .displayName(Text.translatable("itemGroup.starsmod.item_tab"))
            .entries((context, entries) -> {
                entries.add(ItemRegister.FAN_BLADE);
                entries.add(ItemRegister.SMALL_BATTERY);
                entries.add(ItemRegister.BEARING);
                entries.add(ItemRegister.FILTER);
                entries.add(ItemRegister.IRON_PLATE);
                entries.add(ItemRegister.HIGH_PRESSURE_TANK);
                entries.add(ItemRegister.IRON_RING);
                entries.add(ItemRegister.STEEL_BALL);
                entries.add(ItemRegister.LUNAR_ALLOY);
                entries.add(ItemRegister.LUNAR_ALLOY_INGOT);
            })
            .build();

    public static void register(){
        Registry.register(Registries.ITEM_GROUP, new Identifier("starsmod", "item_group"), ITEM_GROUP);
    }
}
