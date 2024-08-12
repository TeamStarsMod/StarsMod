package cn.neko.starsmod.dimension;

import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.registry.RegistryKey;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraft.world.dimension.DimensionType;

/**
 * DimensionVelocity类用于模拟各种星球上的重力效果。
 */
public class DimensionVelocity {

    public static void onServerTick(MinecraftServer server) {
        for (World world : server.getWorlds()) {
            for (PlayerEntity entity : world.getPlayers()) {
                DimensionVelocity.applyGravity(entity);
            }
        }
    }

    public static void applyGravity(Entity entity) {
        // 重力加速度值
        double gravMultiplier;

        // 获取实体所在的星球
        RegistryKey<DimensionType> planet = entity.getEntityWorld().getDimensionKey();
        // 调节各个星球上的重力加速度值
        if (planet.equals(DimensionRegister.MOON_TYPE_KEY)) {
            gravMultiplier = -0.8333333333;
        } else if (planet.equals(DimensionRegister.MARS_TYPE_KEY)){
            gravMultiplier = -0.6666666666;
        }else {
            gravMultiplier = 0.0;
        }

        // 检测实体是否有骑乘物
        if (entity.getVehicle() != null) {
            return;
        }

        // 获取玩家当前重力(Velocity)值
        Vec3d velocity = entity.getVelocity();

        // 检测玩家是否在飞行
        if (entity instanceof PlayerEntity player){
            if (player.getAbilities().flying){
                return;
            }
        }

        //调整并应用重力
        if (entity instanceof LivingEntity) {
            gravMultiplier *= 0.0755;
        } else {
            gravMultiplier *= 0.04;
        }


        entity.setVelocity(velocity.add(0, -gravMultiplier, 0));
    }
}

