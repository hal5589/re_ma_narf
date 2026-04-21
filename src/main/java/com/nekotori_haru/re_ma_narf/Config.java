package com.nekotori_haru.re_ma_narf;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.config.ModConfigEvent;

@Mod.EventBusSubscriber(modid = Re_ma_narf.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class Config {
    private static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();

    // 設定項目の定義
    public static final ForgeConfigSpec.DoubleValue DROP_CHANCE = BUILDER
            .comment("エッセンスがドロップする確率 (0.1 = 10%, 1.0 = 100%)")
            .defineInRange("dropChance", 0.1, 0.0, 1.0);

    static final ForgeConfigSpec SPEC = BUILDER.build();

    @SubscribeEvent
    static void onLoad(final ModConfigEvent event) {
    }
}