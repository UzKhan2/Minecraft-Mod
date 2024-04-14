package com.khan.akira.worldgen.tree;

import com.khan.akira.akira;
import com.khan.akira.worldgen.tree.custom.PineTrunkPlacer;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacerType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModTrunkPlacerTypes {
    public static final DeferredRegister<TrunkPlacerType<?>> TRUNK_PLACER = DeferredRegister
            .create(Registries.TRUNK_PLACER_TYPE, akira.MODID);

    public static final RegistryObject<TrunkPlacerType<PineTrunkPlacer>> PINE_TRUNK_PLACER = TRUNK_PLACER
            .register("pine_trunk_placer", () -> new TrunkPlacerType<>(PineTrunkPlacer.CODEC));

    public static void register(IEventBus eventBus) {
        TRUNK_PLACER.register(eventBus);
    }
}