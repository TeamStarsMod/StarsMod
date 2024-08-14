package cn.neko.starsmod.client;

import cn.neko.starsmod.entity.EntityRegister;
import cn.neko.starsmod.entity.rocket_t1.rocket_t1_render;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;

/**
 * 客户端加载类
 */
public class StarsModClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        EntityRendererRegistry.register(EntityRegister.Rocket_T1, rocket_t1_render::new);
    }
}
