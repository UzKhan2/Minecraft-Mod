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
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.StandingSignBlock;
import net.minecraft.world.level.block.TrapDoorBlock;
import net.minecraft.world.level.block.WallBlock;
import net.minecraft.world.level.block.WallSignBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
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

                simpleBlockWithItem(ModBlocks.GEM_POLISHING_STATION.get(),
                                new ModelFile.UncheckedModelFile(modLoc("block/gem_polishing_station")));

                logBlock(((RotatedPillarBlock) ModBlocks.PINE_LOG.get()));
                axisBlock(((RotatedPillarBlock) ModBlocks.PINE_WOOD.get()), blockTexture(ModBlocks.PINE_LOG.get()),
                                blockTexture(ModBlocks.PINE_LOG.get()));

                axisBlock(((RotatedPillarBlock) ModBlocks.STRIPPED_PINE_LOG.get()),
                                blockTexture(ModBlocks.STRIPPED_PINE_LOG.get()),
                                new ResourceLocation(akira.MODID, "block/stripped_pine_log_top"));
                axisBlock(((RotatedPillarBlock) ModBlocks.STRIPPED_PINE_WOOD.get()),
                                blockTexture(ModBlocks.STRIPPED_PINE_LOG.get()),
                                blockTexture(ModBlocks.STRIPPED_PINE_LOG.get()));

                blockItem(ModBlocks.PINE_LOG);
                blockItem(ModBlocks.PINE_WOOD);
                blockItem(ModBlocks.STRIPPED_PINE_LOG);
                blockItem(ModBlocks.STRIPPED_PINE_WOOD);

                blockWithItem(ModBlocks.PINE_PLANKS);

                leavesBlock(ModBlocks.PINE_LEAVES);

                signBlock(((StandingSignBlock) ModBlocks.PINE_SIGN.get()),
                                ((WallSignBlock) ModBlocks.PINE_WALL_SIGN.get()),
                                blockTexture(ModBlocks.PINE_PLANKS.get()));

                hangingSignBlock(ModBlocks.PINE_HANGING_SIGN.get(), ModBlocks.PINE_WALL_HANGING_SIGN.get(),
                                blockTexture(ModBlocks.PINE_PLANKS.get()));

                saplingBlock(ModBlocks.PINE_SAPLING);

                blockWithItem(ModBlocks.MOD_PORTAL);
        }

        private void saplingBlock(RegistryObject<Block> blockRegistryObject) {
                simpleBlock(blockRegistryObject.get(),
                                models().cross(ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath(),
                                                blockTexture(blockRegistryObject.get())).renderType("cutout"));
        }

        public void hangingSignBlock(Block signBlock, Block wallSignBlock, ResourceLocation texture) {
                ModelFile sign = models().sign(name(signBlock), texture);
                hangingSignBlock(signBlock, wallSignBlock, sign);
        }

        public void hangingSignBlock(Block signBlock, Block wallSignBlock, ModelFile sign) {
                simpleBlock(signBlock, sign);
                simpleBlock(wallSignBlock, sign);
        }

        private String name(Block block) {
                return key(block).getPath();
        }

        private ResourceLocation key(Block block) {
                return ForgeRegistries.BLOCKS.getKey(block);
        }

        private void leavesBlock(RegistryObject<Block> blockRegistryObject) {
                simpleBlockWithItem(blockRegistryObject.get(),
                                models().singleTexture(
                                                ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath(),
                                                new ResourceLocation("minecraft:block/leaves"),
                                                "all", blockTexture(blockRegistryObject.get())).renderType("cutout"));
        }

        private void blockItem(RegistryObject<Block> blockRegistryObject) {
                simpleBlockItem(blockRegistryObject.get(), new ModelFile.UncheckedModelFile(akira.MODID +
                                ":block/" + ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath()));
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