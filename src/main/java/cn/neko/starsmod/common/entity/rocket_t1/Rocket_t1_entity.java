package cn.neko.starsmod.common.entity.rocket_t1;

import cn.neko.starsmod.common.blocks.BlockRegister;
import cn.neko.starsmod.common.network.ModPackets;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.fabricmc.fabric.api.networking.v1.PlayerLookup;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class Rocket_t1_entity extends MobEntity {

    public static final TrackedData<Boolean> FIRING = DataTracker.registerData(Rocket_t1_entity.class, TrackedDataHandlerRegistry.BOOLEAN);
    public static final TrackedData<Float> CURRENT_SPEED = DataTracker.registerData(Rocket_t1_entity.class, TrackedDataHandlerRegistry.FLOAT);

    private static final float MAX_SPEED = 0.25f;       // 最大速度 (m/tick)
    private static final float ACCELERATION = 0.002f;  // 基础加速度
    private static final float DAMPING = 0.98f;        // 空气阻力系数

    public Rocket_t1_entity(EntityType<? extends MobEntity> entityType, World world) {
        super(entityType, world);
        //blockPos = getBlockPos();
        //world1 = getWorld();
    }

    @Override
    protected ActionResult interactMob(PlayerEntity player, Hand hand) {
        //检测玩家是否蹲下互动(Shift + 右键)
        if (!player.getWorld().isClient) {
            // 非客户端交互
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
                return ActionResult.CONSUME;
                /*} else {
                    player.sendMessage(Text.of("There is already has a player riding this rocket!"));
                    return ActionResult.FAIL;
                }*/
            }
        }
        return super.interactMob(player, hand);
    }

    @Override
    public boolean isInvulnerableTo(DamageSource damageSource) {
        return true;
    }

    @Override
    protected void initDataTracker() {
        super.initDataTracker();
        this.dataTracker.startTracking(FIRING, false);
        this.dataTracker.startTracking(CURRENT_SPEED, 0.0f);
    }

    public void handleFireRequest() {
        if (!this.dataTracker.get(FIRING)) {
            this.dataTracker.set(FIRING, true);
            this.dataTracker.set(CURRENT_SPEED, 0.0f);
        }
    }

    @Override
    public void tick() {
        super.tick();

        if (!this.getWorld().isClient) {
            boolean isFiring = this.dataTracker.get(FIRING);
            float currentSpeed = this.dataTracker.get(CURRENT_SPEED);

            if (isFiring && currentSpeed < MAX_SPEED) {
                float effectiveAccel = ACCELERATION * (1 - (currentSpeed / MAX_SPEED));
                currentSpeed = Math.min(currentSpeed + effectiveAccel, MAX_SPEED);
            } else if (!isFiring && currentSpeed > 0) {
                currentSpeed *= DAMPING;
                if (currentSpeed < 0.01f) currentSpeed = 0;
            }

            Vec3d velocity = this.getVelocity();
            this.setVelocity(velocity.x, velocity.y + currentSpeed, velocity.z);
            this.velocityModified = true;

            this.dataTracker.set(CURRENT_SPEED, currentSpeed);
            this.dataTracker.set(FIRING, isFiring && currentSpeed < MAX_SPEED);

            // 同步给所有客户端
            if (this.age % 5 == 0) {
                PacketByteBuf buf = PacketByteBufs.create();
                buf.writeInt(this.getId());
                buf.writeBoolean(this.dataTracker.get(FIRING));
                buf.writeFloat(this.dataTracker.get(CURRENT_SPEED));
                PlayerLookup.tracking(this).forEach(p ->
                        ServerPlayNetworking.send(p, ModPackets.ROCKET_SYNC_PACKET, buf)
                );
            }
        }
    }
}
