package cn.neko.starsmod.client.key.listener;

import cn.neko.starsmod.client.key.RegisterKeys;
import cn.neko.starsmod.common.entity.rocket_t1.Rocket_t1_entity;
import cn.neko.starsmod.common.screens.customScreenHandlers.RocketScreen;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.minecraft.entity.player.PlayerEntity;

public class RocketConfigureListener {
    public RocketConfigureListener() {
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            while (RegisterKeys.ROCKEY_CONFIGURE.wasPressed()) {
                PlayerEntity player = client.player;
                if (player != null && (player.getVehicle() instanceof Rocket_t1_entity)) {
                    client.setScreen(new RocketScreen());
                }
            }
        });
    }
}