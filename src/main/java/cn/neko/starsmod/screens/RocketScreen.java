package cn.neko.starsmod.screens;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.text.Text;

@Environment(EnvType.CLIENT)
public class RocketScreen extends Screen {

    public RocketScreen() {
        super(Text.translatable("screens.starsmod.rocket_ui"));
    }

    public ButtonWidget button1;

    @Override
    protected void init() {
        button1 = ButtonWidget.builder(Text.translatable("screens.starsmod.rocket_ui.dismantle"), button -> {
            //这里是点击按钮执行的内容
            close();
        })
                .dimensions(width / 2 - 205, 20, 200, 20)
                .build();

        addDrawableChild(button1);
    }
}
