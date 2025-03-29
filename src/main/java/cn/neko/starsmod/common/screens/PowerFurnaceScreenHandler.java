package cn.neko.starsmod.common.screens;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.slot.Slot;

public class PowerFurnaceScreenHandler extends ScreenHandler {
    private final Inventory inventory;

    public PowerFurnaceScreenHandler(int syncId, PlayerInventory playerInventory, Inventory inventory) {
        super(ScreenHandlerRegister.POWER_FURNACE_SCREEN_HANDLER, syncId);
        this.inventory = inventory;

        // 添加玩家物品栏
        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 9; ++j) {
                this.addSlot(new Slot(playerInventory, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
            }
        }

        // 添加玩家快捷栏
        for (int i = 0; i < 9; ++i) {
            this.addSlot(new Slot(playerInventory, i, 8 + i * 18, 142));
        }

        // 添加自定义槽位
        this.addSlot(new Slot(inventory, 0, 56, 17)); // 输入槽
        this.addSlot(new Slot(inventory, 1, 56, 53)); // 燃料槽
        this.addSlot(new Slot(inventory, 2, 116, 35)); // 输出槽
    }
    public PowerFurnaceScreenHandler(int syncId, PlayerInventory playerInventory) {
        this(syncId, playerInventory, new SimpleInventory(3));
    }

    @Override
    public boolean canUse(PlayerEntity player) {
        return this.inventory.canPlayerUse(player);
    }

    @Override
    public ItemStack quickMove(PlayerEntity player, int slot) {
        // 实现快速移动逻辑
        return ItemStack.EMPTY;
    }
}