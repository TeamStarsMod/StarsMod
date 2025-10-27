package cn.neko.starsmod.common.items.customItems;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

import java.util.List;

public class TestItem extends Item {

    public TestItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack stack = user.getStackInHand(hand);

        if (!world.isClient) {
            NbtCompound nbt = stack.getOrCreateNbt();
            int count = nbt.getInt("use_count");
            nbt.putInt("use_count", count + 1);
            user.sendMessage(Text.literal("使用次数：" + (count + 1)));
        }

        return TypedActionResult.success(stack);
    }

    @Override
    public void appendTooltip(ItemStack stack, World world, List<Text> tooltip, TooltipContext context) {
        NbtCompound nbt = stack.getNbt();
        if (nbt != null) {
            tooltip.add(Text.literal("已使用次数：" + nbt.getInt("use_count")));
        }
    }

    @Override
    public ItemStack getDefaultStack() {
        ItemStack stack = super.getDefaultStack();
        NbtCompound nbt = stack.getOrCreateNbt();
        nbt.putInt("use_count", 0);
        stack.setNbt(nbt);
        return stack;
    }
}
