package cn.neko.starsmod.entity;

import cn.neko.starsmod.blocks.BlockRegister;
import cn.neko.starsmod.blocks.customBlockEntities.PowerFurnaceBlockEntity;
import cn.neko.starsmod.entity.rocket_t1.rocket_t1_entity;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntityType;
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
    //注册火箭
    //注册1级火箭
    public static final EntityType<rocket_t1_entity> Rocket_T1 = Registry.register(
            Registries.ENTITY_TYPE,
            new Identifier("starsmod", "rocket_t1"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, rocket_t1_entity::new).dimensions(EntityDimensions.fixed(1.9f, 3.0f)).build()
    );

    //注册方块实体
    //电力熔炉
    public static final BlockEntityType<PowerFurnaceBlockEntity> POWER_FURNACE_BLOCK_ENTITY = Registry.register(
            Registries.BLOCK_ENTITY_TYPE,
            new Identifier("starsmod", "power_furnace_block_entity"),
            FabricBlockEntityTypeBuilder.create(PowerFurnaceBlockEntity::new, BlockRegister.POWER_FURNACE).build()
    );
}
