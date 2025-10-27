package cn.neko.starsmod.common.items.customItems.oxygenTanks;

import cn.neko.starsmod.common.StarsMod;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;

public class LowOxygenTankItem extends Item implements OxygenTankItem {
    public LowOxygenTankItem(Settings settings) {
        super(settings);
    }

    @Override
    public ItemStack getDefaultStack() {
        ItemStack stack = super.getDefaultStack();
        NbtCompound nbtCompound = stack.getOrCreateNbt();
        nbtCompound.putInt("oxygen", 0);
        stack.setNbt(nbtCompound);
        return stack;
    }

    public static void setOxygen(ItemStack stack, int oxygen) {
        NbtCompound nbtCompound = stack.getNbt();
        if (nbtCompound == null) {
            StarsMod.LOGGER.warn("NBT is null for item stack: {}", stack);
            return;
        }
        nbtCompound.putInt("oxygen", oxygen);
        stack.setNbt(nbtCompound);
    }

    public static int getOxygen(ItemStack stack) {
        NbtCompound nbtCompound = stack.getNbt();
        if (nbtCompound == null) {
            StarsMod.LOGGER.warn("NBT is null for item stack: {}", stack);
            return -1;
        }
        return nbtCompound.getInt("oxygen");
    }

    @Override
    public int getMaxOxygen() {
        return 2500;
    }
}
