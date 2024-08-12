package cn.neko.starsmod.dimension;

import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.dimension.DimensionType;

/**
 * DimensionRegister类用于注册维度标识符
 */
public class DimensionRegister {
    //注册月球
    public static final RegistryKey<DimensionType> MOON_TYPE_KEY = RegistryKey.of(RegistryKeys.DIMENSION_TYPE,
            new Identifier("starsmod","moon"));
    //注册火星
    public static final RegistryKey<DimensionType> MARS_TYPE_KEY = RegistryKey.of(RegistryKeys.DIMENSION_TYPE,
            new Identifier("starsmod","mars"));
}
