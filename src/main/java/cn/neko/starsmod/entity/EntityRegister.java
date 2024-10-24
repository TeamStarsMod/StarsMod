package cn.neko.starsmod.entity;

import cn.neko.starsmod.entity.rocket_t1.rocket_t1_entity;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

/**
 * EntityRegister类用于注册实体
 */

public class EntityRegister {
    //注册1级火箭
    public static final EntityType<rocket_t1_entity> Rocket_T1 = Registry.register(
            Registries.ENTITY_TYPE,
            new Identifier("starsmod", "rocket_t1"),                                                        //碰撞箱大小
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, rocket_t1_entity::new).dimensions(EntityDimensions.fixed(1.9f, 3.0f)).build()
    );
}
