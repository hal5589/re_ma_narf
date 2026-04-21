package com.nekotori_haru.re_ma_narf.mixin;

import com.blakebr0.mysticalagriculture.block.MysticalCropBlock;
import com.llamalad7.mixinextras.sugar.Local;
import com.nekotori_haru.re_ma_narf.Config;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.storage.loot.LootParams;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.List;

@Mixin(MysticalCropBlock.class)
public abstract class mamixin {

    @Inject(
            method = "getDrops",
            at = @At("RETURN"),
            remap = true
    )
    public void onGetDrops(BlockState state,
                           LootParams.Builder builder,
                           CallbackInfoReturnable<List<ItemStack>> cir,@Local(name = "drops") List<ItemStack> drops) {

        if (!state.getBlock().getClass().getName().contains("MysticalCropBlock")) {
            return;
        }

        double chance = Config.DROP_CHANCE.get();

        if (Math.random() > chance) {
            drops.removeIf(stack -> {
                String itemName = stack.getItem().toString().toLowerCase();
                return itemName.contains("essence") && !itemName.contains("seed");
            });
        }

        for (ItemStack stack : drops) {
            String itemName = stack.getItem().toString().toLowerCase();
            if (itemName.contains("essence") && !itemName.contains("seed")) {
                stack.setCount(1);
            }
        }
    }
}