package cn.neko.starsmod.common.network;

import cn.neko.starsmod.client.gui.OxygenHudRenderer;
import cn.neko.starsmod.common.StarsMod;
import cn.neko.starsmod.common.entity.rocket_t1.Rocket_t1_entity;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.entity.Entity;
import net.minecraft.util.Identifier;

public class ModPackets {
    public static final Identifier OXYGEN_WARNING_PACKET = new Identifier(StarsMod.MOD_ID, "oxygen_warning");

    public static final Identifier ROCKET_FIRE_PACKET = new Identifier("starsmod", "rocket_fire");
    public static final Identifier ROCKET_SYNC_PACKET = new Identifier("starsmod", "rocket_sync");

    public static void registerClientReceivers() {
        // GUI缺氧更新包
        ClientPlayNetworking.registerGlobalReceiver(OXYGEN_WARNING_PACKET, (client, handler, buf, responseSender) -> {
            boolean state = buf.readBoolean();
            client.execute(() -> OxygenHudRenderer.setWarningState(state));
        });
    }

    public static void registerServerReceivers() {
        // 火箭发射包
        ServerPlayNetworking.registerGlobalReceiver(ROCKET_FIRE_PACKET,
                (server, player, handler, buf, responseSender) -> {
                    int entityId = buf.readInt();
                    server.execute(() -> {
                        Entity entity = player.getWorld().getEntityById(entityId);
                        if (entity instanceof Rocket_t1_entity rocket) {
                            rocket.handleFireRequest();
                        }
                    });
                }
        );
    }
}