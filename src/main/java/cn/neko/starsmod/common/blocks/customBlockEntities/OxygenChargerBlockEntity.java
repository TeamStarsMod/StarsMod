package cn.neko.starsmod.common.blocks.customBlockEntities;

import cn.neko.starsmod.common.blocks.BlockRegister;
import cn.neko.starsmod.common.items.customItems.oxygenTanks.OxygenTankItem;
import cn.neko.starsmod.common.screens.customScreenHandlers.OxygenChargerScreenHandler;
import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerFactory;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventories;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class OxygenChargerBlockEntity extends BlockEntity implements ExtendedScreenHandlerFactory, Inventory {
    private final DefaultedList<ItemStack> inventory = DefaultedList.ofSize(2, ItemStack.EMPTY);

    public OxygenChargerBlockEntity(BlockPos pos, BlockState state) {
        super(BlockRegister.OXYGEN_CHARGER_BLOCK_ENTITY, pos, state);
    }

    public DefaultedList<ItemStack> getItems() {
        return inventory;
    }

    public static void tick(World world, BlockPos pos, BlockState state, OxygenChargerBlockEntity entity) {
        if (world.isClient) return;

        ItemStack stack = entity.getItems().get(1); // 获取氧气罐
        if (!stack.isEmpty() && stack.getItem() instanceof OxygenTankItem tank) {
            NbtCompound nbt = stack.getOrCreateNbt();
            int currentOxygen = nbt.getInt("oxygen");
            int maxOxygen = tank.getMaxOxygen();

            if (currentOxygen < maxOxygen) {
                nbt.putInt("oxygen", currentOxygen + 10);
                stack.setNbt(nbt);
                markDirty(world, pos, state);
            }
        }
    }

    @Override
    public void writeScreenOpeningData(ServerPlayerEntity player, PacketByteBuf buf) {
        buf.writeBlockPos(pos);
    }

    @Override
    public Text getDisplayName() {
        return Text.of("Oxygen Charger");
    }

    @Nullable
    @Override
    public ScreenHandler createMenu(int syncId, PlayerInventory playerInventory, PlayerEntity player) {
        return new OxygenChargerScreenHandler(syncId, playerInventory, this);
    }

    @Override
    public int size() {
        return inventory.size();
    }

    @Override
    public boolean isEmpty() {
        for (ItemStack stack : inventory) {
            if (!stack.isEmpty()) {
                return false;
            }
        }
        return true;
    }

    @Override
    public ItemStack getStack(int slot) {
        return inventory.get(slot);
    }

    @Override
    public ItemStack removeStack(int slot, int amount) {
        return Inventories.splitStack(inventory, slot, amount);
    }

    @Override
    public ItemStack removeStack(int slot) {
        return Inventories.removeStack(inventory, slot);
    }

    @Override
    public void setStack(int slot, ItemStack stack) {
        inventory.set(slot, stack);
    }

    @Override
    public boolean canPlayerUse(PlayerEntity player) {
        if (this.world != null) {
            if (this.world.getBlockEntity(this.pos) != this) {
                return false;
            } else {
                return player.squaredDistanceTo((double) this.pos.getX() + 0.5D, (double) this.pos.getY() + 0.5D, (double) this.pos.getZ() + 0.5D) <= 64.0D;
            }
        }
        return false;
    }

    @Override
    public void clear() {
        inventory.clear();
    }
}
