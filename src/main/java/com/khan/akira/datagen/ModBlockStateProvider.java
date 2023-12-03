package com.khan.akira.datagen;

import com.google.common.base.Function;
import com.khan.akira.akira;
import com.khan.akira.block.ModBlocks;
import com.khan.akira.block.custom.CornCropBlock;
import com.khan.akira.block.custom.StrawberryCropBlock;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.ButtonBlock;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.DoorBlock;
import net.minecraft.world.level.block.FenceBlock;
import net.minecraft.world.level.block.FenceGateBlock;
import net.minecraft.world.level.block.PressurePlateBlock;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.TrapDoorBlock;
import net.minecraft.world.level.block.WallBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockStateProvider extends BlockStateProvider {
        public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
                super(output, akira.MODID, exFileHelper);
        }

        @Override
        protected void registerStatesAndModels() {
                blockWithItem(ModBlocks.SAPPHIRE_BLOCK);
                blockWithItem(ModBlocks.RAW_SAPPHIRE_BLOCK);

                blockWithItem(ModBlocks.SAPPHIRE_ORE);
                blockWithItem(ModBlocks.DEEPSLATE_SAPPHIRE_ORE);
                blockWithItem(ModBlocks.END_STONE_SAPPHIRE_ORE);
                blockWithItem(ModBlocks.NETHER_SAPPHIRE_ORE);

                stairsBlock(((StairBlock) ModBlocks.SAPPHIRE_STAIRS.get()),
                                blockTexture(ModBlocks.SAPPHIRE_BLOCK.get()));
                slabBlock(((SlabBlock) ModBlocks.SAPPHIRE_SLAB.get()), blockTexture(ModBlocks.SAPPHIRE_BLOCK.get()),
                                blockTexture(ModBlocks.SAPPHIRE_BLOCK.get()));

                buttonBlock(((ButtonBlock) ModBlocks.SAPPHIRE_BUTTON.get()),
                                blockTexture(ModBlocks.SAPPHIRE_BLOCK.get()));
                pressurePlateBlock(((PressurePlateBlock) ModBlocks.SAPPHIRE_PRESSURE_PLATE.get()),
                                blockTexture(ModBlocks.SAPPHIRE_BLOCK.get()));

                fenceBlock(((FenceBlock) ModBlocks.SAPPHIRE_FENCE.get()), blockTexture(ModBlocks.SAPPHIRE_BLOCK.get()));
                fenceGateBlock(((FenceGateBlock) ModBlocks.SAPPHIRE_FENCE_GATE.get()),
                                blockTexture(ModBlocks.SAPPHIRE_BLOCK.get()));
                wallBlock(((WallBlock) ModBlocks.SAPPHIRE_WALL.get()), blockTexture(ModBlocks.SAPPHIRE_BLOCK.get()));

                doorBlockWithRenderType(((DoorBlock) ModBlocks.SAPPHIRE_DOOR.get()),
                                modLoc("block/sapphire_door_bottom"),
                                modLoc("block/sapphire_door_top"), "cutout");
                trapdoorBlockWithRenderType(((TrapDoorBlock) ModBlocks.SAPPHIRE_TRAPDOOR.get()),
                                modLoc("block/sapphire_trapdoor"), true, "cutout");

                blockWithItem(ModBlocks.SOUND_BLOCK);
                makeStrawberryCrop((CropBlock) ModBlocks.STRAWBERRY_CROP.get(), "strawberry_stage", "strawberry_stage");
                makeCornCrop(((CropBlock) ModBlocks.CORN_CROP.get()), "corn_stage_", "corn_stage_");

                simpleBlockWithItem(ModBlocks.CATMINT.get(),
                                models().cross(blockTexture(ModBlocks.CATMINT.get()).getPath(),
                                                blockTexture(ModBlocks.CATMINT.get())).renderType("cutout"));
                simpleBlockWithItem(ModBlocks.POTTED_CATMINT.get(),
                                models().singleTexture("potted_catmint", new ResourceLocation("flower_pot_cross"),
                                                "plant",
                                                blockTexture(ModBlocks.CATMINT.get())).renderType("cutout"));
        }

        public void makeStrawberryCrop(CropBlock block, String modelName, String textureName) {
                Function<BlockState, ConfiguredModel[]> function = state -> strawberryStates(state, block, modelName,
                                textureName);

                getVariantBuilder(block).forAllStates(function);
        }

        private ConfiguredModel[] strawberryStates(BlockState state, CropBlock block, String modelName,
                        String textureName) {
                ConfiguredModel[] models = new ConfiguredModel[1];
                models[0] = new ConfiguredModel(models()
                                .crop(modelName + state.getValue(((StrawberryCropBlock) block).getAgeProperty()),
                                                new ResourceLocation(akira.MODID, "block/" + textureName
                                                                + state.getValue(((StrawberryCropBlock) block)
                                                                                .getAgeProperty())))
                                .renderType("cutout"));

                return models;
        }

        public void makeCornCrop(CropBlock block, String modelName, String textureName) {
                Function<BlockState, ConfiguredModel[]> function = state -> cornStates(state, block, modelName,
                                textureName);

                getVariantBuilder(block).forAllStates(function);
        }

        private ConfiguredModel[] cornStates(BlockState state, CropBlock block, String modelName, String textureName) {
                ConfiguredModel[] models = new ConfiguredModel[1];
                models[0] = new ConfiguredModel(models()
                                .crop(modelName + state.getValue(((CornCropBlock) block).getAgeProperty()),
                                                new ResourceLocation(akira.MODID,
                                                                "block/" + textureName
                                                                                + state.getValue(((CornCropBlock) block)
                                                                                                .getAgeProperty())))
                                .renderType("cutout"));

                return models;
        }

        private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
                simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
        }
}