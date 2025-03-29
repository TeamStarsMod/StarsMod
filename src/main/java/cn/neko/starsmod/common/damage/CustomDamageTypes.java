package cn.neko.starsmod.common.damage;

import cn.neko.starsmod.common.StarsMod;
import net.minecraft.entity.damage.DamageType;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

public class CustomDamageTypes {
    public static final RegistryKey<DamageType> NO_OXYGEN_DAMAGE = RegistryKey.of(RegistryKeys.DAMAGE_TYPE, Identifier.of(StarsMod.MOD_ID, "nooxygen"));
}
