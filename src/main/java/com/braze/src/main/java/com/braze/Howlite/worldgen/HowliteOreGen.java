package com.braze.Howlite.worldgen;

import com.braze.Howlite.init.BlockInit;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.placement.ConfiguredPlacement;
import net.minecraft.world.gen.placement.CountRangeConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.registries.ForgeRegistries;

public class HowliteOreGen {

    public static void generateOre() {
        for(Biome biome : ForgeRegistries.BIOMES) {
            ConfiguredPlacement customConfig = Placement.COUNT_RANGE.configure(new CountRangeConfig(1, 0, 0, 16));
            biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE
                    .withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, BlockInit.howlite_ore.getDefaultState(), 10))
                    .withPlacement(customConfig));
        }
    }
}
