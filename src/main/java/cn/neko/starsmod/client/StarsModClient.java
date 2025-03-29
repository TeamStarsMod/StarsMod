package cn.neko.starsmod.client;

import cn.neko.starsmod.client.gui.OxygenHudRenderer;
import cn.neko.starsmod.client.key.RegisterKeys;
import cn.neko.starsmod.common.entity.EntityRegister;
import cn.neko.starsmod.common.entity.rocket_t1.Rocket_t1_render;
import cn.neko.starsmod.common.network.ModPackets;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;

/**
 * 客户端加载类
 */
public class StarsModClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        EntityRendererRegistry.register(EntityRegister.Rocket_T1, Rocket_t1_render::new);

        RegisterKeys.register();

        // 注册GUI渲染器
        HudRenderCallback.EVENT.register(new OxygenHudRenderer());
        ModPackets.registerClientReceivers();
    }
}
