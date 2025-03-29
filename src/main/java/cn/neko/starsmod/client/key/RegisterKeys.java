package cn.neko.starsmod.client.key;

import cn.neko.starsmod.client.key.listener.RocketFireListener;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.option.KeyBinding;
import org.lwjgl.glfw.GLFW;

public class RegisterKeys {
    public static KeyBinding rocketFire;

    public static void register() {
        //注册按键
        rocketFire = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                "key.starsmod.rocket_fire",
                GLFW.GLFW_KEY_SPACE,
                "category.starsmod"
        ));

        //注册按键监听
        new RocketFireListener();
    }
}
