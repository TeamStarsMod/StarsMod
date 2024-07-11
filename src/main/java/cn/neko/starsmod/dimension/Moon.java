package cn.neko.starsmod.dimension;

import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;
import net.minecraft.world.dimension.DimensionType;

public class Moon {
    //注册维度
    public static final RegistryKey<World> MOON = RegistryKey.of(RegistryKeys.WORLD,
            new Identifier("starsmod","moon"));
    //注册维度类型
    public static final RegistryKey<DimensionType> MOON_TYPE_KEY = RegistryKey.of(RegistryKeys.DIMENSION_TYPE,
            new Identifier("starsmod","moon"));
}
