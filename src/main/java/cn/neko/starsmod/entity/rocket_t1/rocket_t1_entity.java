package cn.neko.starsmod.entity.rocket_t1;

import cn.neko.starsmod.blocks.BlockRegister;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class rocket_t1_entity extends MobEntity {
    public static BlockPos blockPos;
    public static World world1;

    boolean hasPlayer = false;

    public rocket_t1_entity(EntityType<? extends MobEntity> entityType, World world) {
        super(entityType, world);
        //blockPos = getBlockPos();
        //world1 = getWorld();
    }

        @Override
        protected ActionResult interactMob(PlayerEntity player, Hand hand) {
        //检测玩家是否蹲下互动(Shift + 右键)
            if (player.isSneaking()) {
                //player.sendMessage(Text.of("Open GUI"));
                /*
                MinecraftClient.getInstance().execute(() -> {
                    MinecraftClient client = MinecraftClient.getInstance();
                    client.setScreen(new RocketScreen());
                });
                */
                player.sendMessage(Text.of("Blocked!"));
                remove(RemovalReason.KILLED);
                Block block = BlockRegister.ROCKET_T1;
                BlockState State = block.getDefaultState();
                getWorld().setBlockState(getBlockPos(), State, 3);
                return ActionResult.SUCCESS; //返回成功交互状态
            } else {
                //if (!hasPlayer) {
                    player.startRiding(this);
                    //hasPlayer = true;
                    return ActionResult.SUCCESS;
                /*} else {
                    player.sendMessage(Text.of("There is already has a player riding this rocket!"));
                    return ActionResult.FAIL;
                }*/
            }
        }

    @Override
    public boolean isInvulnerableTo(DamageSource damageSource) {
        return true;
    }
}
