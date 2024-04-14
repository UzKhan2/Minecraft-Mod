package com.khan.akira.worldgen.biome;

import com.khan.akira.akira;
import net.minecraft.resources.ResourceLocation;
import terrablender.api.Regions;

public class ModTerrablender {
    public static void registerBiomes() {
        Regions.register(new ModOverworldRegion(new ResourceLocation(akira.MODID, "overworld"), 5));
    }
}