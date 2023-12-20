package com.khan.akira.util;

import com.khan.akira.akira;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.WoodType;

public class ModWoodTypes {
    public static final WoodType PINE = WoodType.register(new WoodType(akira.MODID + ":pine", BlockSetType.OAK));
}