package com.khan.akira.block;

import java.util.function.Supplier;

import com.khan.akira.akira;
import com.khan.akira.block.custom.SoundBlock;
import com.khan.akira.item.ModItems;

import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlocks {
        public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS,
                        akira.MODID);

        public static final RegistryObject<Block> SAPPHIRE_BLOCK = registerBlock("sapphire_block",
                        () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).sound(SoundType.AMETHYST)));

        public static final RegistryObject<Block> RAW_SAPPHIRE_BLOCK = registerBlock("raw_sapphire_block",
                        () -> new Block(BlockBehaviour.Properties.copy(Blocks.RAW_IRON_BLOCK)
                                        .sound(SoundType.AMETHYST)));

        public static final RegistryObject<Block> SAPPHIRE_ORE = registerBlock("sapphire_ore",
                        () -> new DropExperienceBlock(
                                        BlockBehaviour.Properties.copy(Blocks.STONE).strength(2f)
                                                        .requiresCorrectToolForDrops(),
                                        UniformInt.of(3, 6)));
        public static final RegistryObject<Block> DEEPSLATE_SAPPHIRE_ORE = registerBlock("deepslate_sapphire_ore",
                        () -> new DropExperienceBlock(
                                        BlockBehaviour.Properties.copy(Blocks.DEEPSLATE).strength(3f)
                                                        .requiresCorrectToolForDrops(),
                                        UniformInt.of(3, 7)));
        public static final RegistryObject<Block> NETHER_SAPPHIRE_ORE = registerBlock("nether_sapphire_ore",
                        () -> new DropExperienceBlock(
                                        BlockBehaviour.Properties.copy(Blocks.NETHERRACK).strength(1f)
                                                        .requiresCorrectToolForDrops(),
                                        UniformInt.of(3, 6)));
        public static final RegistryObject<Block> END_STONE_SAPPHIRE_ORE = registerBlock("end_stone_sapphire_ore",
                        () -> new DropExperienceBlock(
                                        BlockBehaviour.Properties.copy(Blocks.END_STONE).strength(5f)
                                                        .requiresCorrectToolForDrops(),
                                        UniformInt.of(3, 6)));

        public static final RegistryObject<Block> SOUND_BLOCK = registerBlock("sound_block",
                        () -> new SoundBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));

        private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
                RegistryObject<T> toRetrun = BLOCKS.register(name, block);
                registerBlockItem(name, toRetrun);
                return toRetrun;
        }

        private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
                return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));

        }

        public static void register(IEventBus eventBus) {
                BLOCKS.register(eventBus);
        }

}
