package cn.neko.starsmod.common.dimension;

import cn.neko.starsmod.common.damage.CustomDamageTypes;
import cn.neko.starsmod.common.items.ItemRegister;
import cn.neko.starsmod.common.network.ModPackets;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.damage.DamageTypes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.world.World;
import net.minecraft.world.dimension.DimensionType;

public class SpaceSuitChecker {

    private static final long CHECK_INTERVAL = 40;

    public static void onServerTick(MinecraftServer server) {
        if (server.getTicks() % CHECK_INTERVAL != 0) return;

        for (World world : server.getWorlds()) {
            if (!isSpaceDimension(world)) continue;

            for (PlayerEntity player : world.getPlayers()) {
                checkProtection(player);
            }
        }
    }

    private static void checkProtection(PlayerEntity player) {
        if (player.isCreative() || player.isSpectator()) return;

        if (!isWearingFullSpaceSuit(player)) {
            applyOxygenDamage(player);
        }
    }

    private static boolean isWearingFullSpaceSuit(PlayerEntity player) {
        return player.getEquippedStack(EquipmentSlot.HEAD).isOf(ItemRegister.SPACE_HELMET) &&
                player.getEquippedStack(EquipmentSlot.CHEST).isOf(ItemRegister.SPACE_CHESTPLATE) &&
                player.getEquippedStack(EquipmentSlot.LEGS).isOf(ItemRegister.SPACE_LEGGINGS) &&
                player.getEquippedStack(EquipmentSlot.FEET).isOf(ItemRegister.SPACE_BOOTS);
    }

    private static void applyOxygenDamage(PlayerEntity player) {
        if (player.timeUntilRegen > 10) return;

        // 获取缺氧伤害类型
        DamageSource noOxygenDamage = new DamageSource(
                player.getWorld().getRegistryManager()
                        .get(RegistryKeys.DAMAGE_TYPE)
                        .entryOf(CustomDamageTypes.NO_OXYGEN_DAMAGE));

        player.damage(noOxygenDamage, 6.0f);

        // 发送警告状态到客户端
        PacketByteBuf warnBuf = PacketByteBufs.create();
        warnBuf.writeBoolean(true);
        ServerPlayNetworking.send(
                (ServerPlayerEntity) player,
                ModPackets.OXYGEN_WARNING_PACKET,
                warnBuf
        );

        // 取消警告
        if (isWearingFullSpaceSuit(player)) {
            PacketByteBuf warnBuf1 = PacketByteBufs.create();
            warnBuf1.writeBoolean(false);
            ServerPlayNetworking.send(
                    (ServerPlayerEntity) player,
                    ModPackets.OXYGEN_WARNING_PACKET,
                    warnBuf1
            );
        }
    }

    private static boolean isSpaceDimension(World world) {
        RegistryKey<DimensionType> dimensionKey = world.getDimensionKey();
        return dimensionKey == DimensionRegister.MOON_TYPE_KEY ||
                dimensionKey == DimensionRegister.MARS_TYPE_KEY;
    }
}