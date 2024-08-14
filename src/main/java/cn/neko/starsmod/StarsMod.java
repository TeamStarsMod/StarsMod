package cn.neko.starsmod;

import cn.neko.starsmod.blocks.BlockRegister;
import cn.neko.starsmod.dimension.DimensionVelocity;
import cn.neko.starsmod.entity.rocket_t1.rocket_t1_entity;
import cn.neko.starsmod.items.ItemRegister;
import cn.neko.starsmod.tabs.BlocksTab;
import cn.neko.starsmod.tabs.ItemsTab;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;

import static cn.neko.starsmod.entity.EntityRegister.Rocket_T1;

public class StarsMod implements ModInitializer {
    @Override
    public void onInitialize() {
        //Register Blocks and BlockItems
        BlockRegister.register();

        //Register Items
        ItemRegister.register();

        //Register CreativeTabs
        BlocksTab.register();
        ItemsTab.register();

        //Events
        ServerTickEvents.START_SERVER_TICK.register(DimensionVelocity::onServerTick); //注册玩家重力(Tick)事件

        //Entity
        FabricDefaultAttributeRegistry.register(Rocket_T1, rocket_t1_entity.createMobAttributes());
    }
}
