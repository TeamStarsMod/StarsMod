package cn.neko.starsmod.client.key.listener;

import cn.neko.starsmod.client.key.RegisterKeys;
import cn.neko.starsmod.common.entity.rocket_t1.Rocket_t1_entity;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.entity.Entity;
import net.minecraft.text.Text;
import net.minecraft.util.math.Vec3d;

public class RocketFireListener {
    // 当前速度
    private double currentUpwardVelocity = 0.0;
    // 防止二次起飞
    private boolean isAlreadyFire = false;
    // 火箭是否应该加速
    private boolean shouldAccelerate = false;

    public RocketFireListener() {
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            // 检测空格键是否被按下
            while (RegisterKeys.rocketFire.wasPressed()) {
                ClientPlayerEntity player = client.player;
                if (player != null) {
                    player.sendMessage(Text.of("正在准备起飞！"));
                    if (!isAlreadyFire) {
                        Entity entity = player.getVehicle();
                        if (entity instanceof Rocket_t1_entity) {
                            // 开始加速火箭
                            player.sendMessage(Text.of("飞起来！"));
                            shouldAccelerate = true;
                            isAlreadyFire = true;
                        }else {
                            player.sendMessage(Text.of("这不是火箭！"));
                        }
                    } else {
                        player.sendMessage(Text.of("你不能二次起飞！"));
                    }
                }
            }

            // 如果火箭应该加速，则更新速度
            if (shouldAccelerate) {
                System.out.println("更新速度");
                ClientPlayerEntity player = client.player;
                if (player != null && player.getVehicle() instanceof Rocket_t1_entity rocket) {
                    updateRocketVelocity(rocket);
                    // 如果达到目标速度，停止加速
                    if (currentUpwardVelocity >= 1.0) {
                        shouldAccelerate = false;
                    }
                } else {
                    // 如果玩家不再骑乘火箭，重置状态
                    resetRocketState();
                }
            }
        });
    }

    private void updateRocketVelocity(Rocket_t1_entity rocket) {
        // 标定速度
        double targetUpwardVelocity = 1.0;
        // 加速度
        double acceleration = 0.01;

        if (currentUpwardVelocity < targetUpwardVelocity) {
            currentUpwardVelocity += acceleration;
            // 限制当前速度不超过标定速度
            if (currentUpwardVelocity > targetUpwardVelocity) {
                currentUpwardVelocity = targetUpwardVelocity;
            }
        }

        // 获取火箭当前速度
        Vec3d currentVelocity = rocket.getVelocity();

        // 设置新的速度
        Vec3d newVelocity = currentVelocity.add(0, currentUpwardVelocity, 0);

        // 应用新的速度到火箭
        rocket.setVelocity(newVelocity);
        rocket.velocityModified = true;

        // 调试输出，确认速度是否更新
        System.out.println("火箭新速度: " + newVelocity);
    }

    private void resetRocketState() {
        currentUpwardVelocity = 0.0;
        isAlreadyFire = false;
        shouldAccelerate = false;
        // 调试输出，确认状态是否重置
        System.out.println("火箭状态已重置");
    }
}