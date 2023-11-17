package com.addfoodmod.Blocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;

public class JumpBlock extends Block {
    public JumpBlock(){
        super(Material.IRON);
        this.setCreativeTab(CreativeTabs.TRANSPORTATION);
        this.setSoundType(SoundType.SLIME);
        this.setHardness(3.0f);
        this.setResistance(5.0f);
        this.setUnlocalizedName("jump_block");
    }

    @Override
    public void onEntityWalk(World worldIn, BlockPos pos, Entity entityIn) {
        if (!worldIn.isRemote) {
            entityIn.addVelocity(0,20,0);
        }
    }

    @Override
    public void onFallenUpon(World worldIn, BlockPos pos, Entity entityIn, float fallDistance) {

    }
}
