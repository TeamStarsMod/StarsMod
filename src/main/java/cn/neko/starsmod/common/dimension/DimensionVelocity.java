package cn.neko.starsmod.common.dimension;

import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.registry.RegistryKey;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraft.world.dimension.DimensionType;

public class DimensionVelocity {

    public static void onServerTick(MinecraftServer server) {
        for (World world : server.getWorlds()) {
            RegistryKey<DimensionType> dimensionType = world.getDimensionKey();
            if (needsCustomGravity(dimensionType)) {
                for (Entity entity : world.getPlayers()) {
                    applyCustomGravity(entity, dimensionType);
                }
            }
        }
    }

    private static void applyCustomGravity(Entity entity, RegistryKey<DimensionType> dimension) {
        // 排除坐骑或飞行玩家
        if (entity.getVehicle() != null) return;
        if (entity instanceof PlayerEntity player && player.getAbilities().flying) return;

        Vec3d velocity = entity.getVelocity();
        double gravityReduction = getGravityReduction(dimension);

        // 对不同类型实体调整增量
        if (entity instanceof LivingEntity) {
            gravityReduction *= 0.0755; // 玩家/生物
        } else {
            gravityReduction *= 0.04; // 物品/其他实体
        }

        // 只在空中减少下落速度
        if (!entity.isOnGround() && velocity.y <= 0) {
            // 累加 y 方向速度，减缓下落
            entity.getVelocity().add(0, gravityReduction, 0);
        }
    }

    private static double getGravityReduction(RegistryKey<DimensionType> dimension) {
        if (dimension.equals(DimensionRegister.MOON_TYPE_KEY)) {
            return 0.065; // 月球低重力
        } else if (dimension.equals(DimensionRegister.MARS_TYPE_KEY)) {
            return 0.025; // 火星低重力
        }
        return 0.0;
    }

    private static boolean needsCustomGravity(RegistryKey<DimensionType> dimension) {
        return dimension.equals(DimensionRegister.MOON_TYPE_KEY) ||
                dimension.equals(DimensionRegister.MARS_TYPE_KEY);
    }
}
