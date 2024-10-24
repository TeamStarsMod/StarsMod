package cn.neko.starsmod.screens.blocks.electricFurnace;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.text.Text;

public class ElectricFurnace extends Screen {
    protected ElectricFurnace(Text title) {
        super(title);
    }

    public ButtonWidget button1;

    @Override
    protected void init() {
        button1 = ButtonWidget.builder(Text.translatable("screens.starsmod.electricfurnace"), button -> {

                })
                .dimensions(width / 2 - 205, 20, 200, 20)
                .build();

        addDrawableChild(button1);
    }
}
