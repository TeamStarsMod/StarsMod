package cn.neko.starsmod.blocks.customBlocks;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.FurnaceBlock;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.Properties;

public class PowerFurnaceBlock extends FurnaceBlock {
    public static final BooleanProperty LIT = Properties.LIT;

    public PowerFurnaceBlock() {
        super(FabricBlockSettings.copy(Blocks.FURNACE));
        setDefaultState(getStateManager().getDefaultState().with(LIT, false));
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        super.appendProperties(builder);
    }
}
