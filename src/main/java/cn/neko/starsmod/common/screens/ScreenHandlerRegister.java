package cn.neko.starsmod.common.screens;

import cn.neko.starsmod.common.StarsMod;
import cn.neko.starsmod.common.screens.customScreenHandlers.OxygenChargerScreenHandler;
import cn.neko.starsmod.common.screens.customScreenHandlers.PowerFurnaceScreenHandler;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.resource.featuretoggle.FeatureSet;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;

public class ScreenHandlerRegister {
    public static ScreenHandlerType<PowerFurnaceScreenHandler> POWER_FURNACE_SCREEN_HANDLER;
    public static ScreenHandlerType<OxygenChargerScreenHandler> OXYGEN_CHARGER_SCREEN_HANDLER;

    public static void register() {
        POWER_FURNACE_SCREEN_HANDLER = Registry.register(
                Registries.SCREEN_HANDLER,
                new Identifier(StarsMod.MOD_ID, "power_furnace"),
                new ScreenHandlerType<>(PowerFurnaceScreenHandler::new, FeatureSet.empty())
        );

        OXYGEN_CHARGER_SCREEN_HANDLER = Registry.register(
                Registries.SCREEN_HANDLER,
                new Identifier(StarsMod.MOD_ID, "oxygen_charger"),
                new ScreenHandlerType<>(OxygenChargerScreenHandler::new, FeatureSet.empty())
        );
    }
}