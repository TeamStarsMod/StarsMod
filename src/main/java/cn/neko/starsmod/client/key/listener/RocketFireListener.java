package cn.neko.starsmod.client.key.listener;

import cn.neko.starsmod.client.key.RegisterKeys;
import cn.neko.starsmod.common.entity.rocket_t1.Rocket_t1_entity;
import cn.neko.starsmod.common.network.ModPackets;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.entity.Entity;
import net.minecraft.network.PacketByteBuf;

public class RocketFireListener {
    public RocketFireListener() {
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            while (RegisterKeys.ROCKET_FIRE.wasPressed()) {
                ClientPlayerEntity player = client.player;
                if (player != null && player.getVehicle() instanceof Rocket_t1_entity rocket) {
                    PacketByteBuf buf = PacketByteBufs.create();
                    buf.writeInt(rocket.getId());
                    ClientPlayNetworking.send(ModPackets.ROCKET_FIRE_PACKET, buf);
                }
            }
        });

        // 接收状态同步
        ClientPlayNetworking.registerGlobalReceiver(ModPackets.ROCKET_SYNC_PACKET,
                (client, handler, buf, responseSender) -> {
                    int entityId = buf.readInt();
                    boolean firing = buf.readBoolean();
                    float speed = buf.readFloat();

                    client.execute(() -> {
                        Entity entity = null;
                        if (client.world != null) {
                            entity = client.world.getEntityById(entityId);
                        }
                        if (entity instanceof Rocket_t1_entity rocket) {
                            rocket.getDataTracker().set(Rocket_t1_entity.FIRING, firing);
                            rocket.getDataTracker().set(Rocket_t1_entity.CURRENT_SPEED, speed);
                        }
                    });
                }
        );
    }
}