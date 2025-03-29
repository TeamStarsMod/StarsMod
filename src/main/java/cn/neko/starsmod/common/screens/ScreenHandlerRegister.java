package cn.neko.starsmod.common.screens;

import cn.neko.starsmod.common.StarsMod;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.resource.featuretoggle.FeatureSet;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;

public class ScreenHandlerRegister {
    public static final ScreenHandlerType<PowerFurnaceScreenHandler> POWER_FURNACE_SCREEN_HANDLER = Registry.register(
            Registries.SCREEN_HANDLER,
            new Identifier(StarsMod.MOD_ID, "power_furnace"),
            new ScreenHandlerType<>(PowerFurnaceScreenHandler::new, FeatureSet.empty())
    );
}