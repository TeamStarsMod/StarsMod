package cn.neko.starsmod.common.network;

import cn.neko.starsmod.client.gui.OxygenHudRenderer;
import cn.neko.starsmod.common.StarsMod;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.minecraft.util.Identifier;

public class ModPackets {
    public static final Identifier OXYGEN_WARNING_PACKET = new Identifier(StarsMod.MOD_ID, "oxygen_warning");

    public static void registerClientReceivers() {
        ClientPlayNetworking.registerGlobalReceiver(OXYGEN_WARNING_PACKET, (client, handler, buf, responseSender) -> {
            boolean state = buf.readBoolean();
            client.execute(() -> OxygenHudRenderer.setWarningState(state));
        });
    }
}