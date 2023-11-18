package com.addfoodmod.Blocks;

import com.addfoodmod.AddFoodMod;
import net.minecraft.block.Block;
import net.minecraft.block.BlockCrops;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.Random;

public class AddCrop01 extends BlockCrops {

    public AddCrop01() {

    }

    @Override
    protected Item getSeed() {
        return AddFoodMod.ADD_SEED_01;
    }

    @Override
    protected Item getCrop() {
        return AddFoodMod.ITEM_ADD_CROP_01;
    }
    @Override
    public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand) {
        super.updateTick(worldIn, pos, state, rand);


        BlockPos down = pos.down();
        IBlockState downState = worldIn.getBlockState(down);

        if (downState.getBlock() != Blocks.FARMLAND) {

            dropBlockAsItem(worldIn, pos, state, 0);
            worldIn.setBlockToAir(pos);
        }
    }
    @Override
    public void neighborChanged(IBlockState state, World worldIn, BlockPos pos, Block blockIn, BlockPos fromPos) {
        super.neighborChanged(state, worldIn, pos, blockIn, fromPos);


        BlockPos down = pos.down();
        IBlockState downState = worldIn.getBlockState(down);


        if (downState.getBlock() != Blocks.FARMLAND) {

            dropBlockAsItem(worldIn, pos, state, 0);
            worldIn.setBlockToAir(pos);
        }
    }
}
