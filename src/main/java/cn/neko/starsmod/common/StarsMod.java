package cn.neko.starsmod.common;

import cn.neko.starsmod.common.blocks.BlockRegister;
import cn.neko.starsmod.common.dimension.DimensionVelocity;
import cn.neko.starsmod.common.dimension.SpaceSuitChecker;
import cn.neko.starsmod.common.entity.rocket_t1.Rocket_t1_entity;
import cn.neko.starsmod.common.items.ItemRegister;
import cn.neko.starsmod.common.network.ModPackets;
import cn.neko.starsmod.common.screens.ScreenHandlerRegister;
import cn.neko.starsmod.common.tabs.BlocksTabRegister;
import cn.neko.starsmod.common.tabs.ItemsTabRegister;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static cn.neko.starsmod.common.entity.EntityRegister.Rocket_T1;

public class StarsMod implements ModInitializer {
    public static String MOD_ID = "starsmod";
    public static Logger LOGGER = LoggerFactory.getLogger(StarsMod.class);

    @Override
    public void onInitialize() {
        // Register Blocks and BlockItems
        BlockRegister.register();

        // Register Items
        ItemRegister.register();

        // Register CreativeTabs
        BlocksTabRegister.register();
        ItemsTabRegister.register();

        // Events
        ServerTickEvents.END_SERVER_TICK.register(DimensionVelocity::onServerTick); //注册玩家重力(Tick)事件
        ServerTickEvents.START_SERVER_TICK.register(SpaceSuitChecker::onServerTick);

        // Entity
        FabricDefaultAttributeRegistry.register(Rocket_T1, Rocket_t1_entity.createMobAttributes());

        // Network Packets
        ModPackets.registerServerReceivers();

        // ScreenHandlers
        ScreenHandlerRegister.register();
    }
}
