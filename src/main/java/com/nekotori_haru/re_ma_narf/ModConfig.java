package com.nekotori_haru.re_ma_narf;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Re_ma_narf.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModConfig {
    private static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec SPEC;

    // 確率設定の変数
    public static final ForgeConfigSpec.DoubleValue DROP_CHANCE;

    static {
        BUILDER.push("Mystical Agriculture Nerf Settings");

        DROP_CHANCE = BUILDER
                .comment("エッセンスがドロップする確率 (0.1 = 10%, 1.0 = 100%)")
                .defineInRange("dropChance", 0.1, 0.0, 1.0);

        BUILDER.pop();
        SPEC = BUILDER.build();
    }
}