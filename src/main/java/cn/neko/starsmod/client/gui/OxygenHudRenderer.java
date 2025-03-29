package cn.neko.starsmod.client.gui;

import cn.neko.starsmod.common.StarsMod;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class OxygenHudRenderer implements HudRenderCallback {
    private static final Identifier WARNING_ICON = new Identifier(StarsMod.MOD_ID, "textures/gui/oxygen_warning.png");
    private static boolean showWarning = false;

    @Override
    public void onHudRender(DrawContext drawContext, float tickDelta) {
        MinecraftClient client = MinecraftClient.getInstance();
        if (client.player == null || !showWarning) return;

        // 获取屏幕尺寸
        int width = client.getWindow().getScaledWidth();
        int height = client.getWindow().getScaledHeight();

        // 渲染文字（带阴影）
        Text warningText = Text.translatable("gameplay.starsmod.nooxygen");
        int textWidth = client.textRenderer.getWidth(warningText);
        drawContext.drawTextWithShadow(
                client.textRenderer,
                warningText,
                (width - textWidth) / 2,
                height / 4,
                0xFF2222 // 红色
        );

        // 可选：渲染图标
        /*drawContext.drawTexture(
                WARNING_ICON,
                (width - 16) / 2,
                height / 4 - 20,
                0, 0,
                16, 16,
                16, 16
        );*/
    }

    public static void setWarningState(boolean state) {
        showWarning = state;
    }
}