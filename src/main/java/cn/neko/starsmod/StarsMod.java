package cn.neko.starsmod;

import cn.neko.starsmod.blocks.BlockRegister;
import cn.neko.starsmod.items.ItemRegister;
import cn.neko.starsmod.tabs.BlocksTab;
import cn.neko.starsmod.tabs.ItemsTab;
import net.fabricmc.api.ModInitializer;

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
    }
}
