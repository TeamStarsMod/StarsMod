package cn.neko.starsmod.blocks.customBlocks;

import cn.neko.starsmod.entity.EntityRegister;
import cn.neko.starsmod.entity.rocket_t1.rocket_t1_entity;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class Rocket_t1_Block extends Block {
    public Rocket_t1_Block(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        Entity rocket = new rocket_t1_entity(EntityRegister.Rocket_T1, world);
        rocket.setPosition(pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5);
        world.setBlockState(pos, Blocks.AIR.getDefaultState(), 3);
        world.spawnEntity(rocket);
        return ActionResult.SUCCESS;
    }
}
