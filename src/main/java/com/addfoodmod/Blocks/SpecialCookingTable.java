package com.addfoodmod.Blocks;

import com.addfoodmod.AddFoodMod;
import com.addfoodmod.Items.Cheese;
import net.minecraft.block.BlockHorizontal;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.world.World;

import java.util.Random;

public class SpecialCookingTable extends BlockHorizontal {
    public SpecialCookingTable() {
        super(Material.ROCK);
        this.setCreativeTab(CreativeTabs.DECORATIONS);
        this.setSoundType(SoundType.STONE);
        this.setHardness(3.0f);
        this.setResistance(5.0f);
        this.setUnlocalizedName("special_cooking_table");
    }

    @Override
    public void onBlockPlacedBy(World world, BlockPos pos, IBlockState state, EntityLivingBase placer, net.minecraft.item.ItemStack stack) {
        world.setBlockState(pos, state.withProperty(FACING, placer.getHorizontalFacing().getOpposite()), 2);
    }
    @Override
    protected BlockStateContainer createBlockState() {

        return new BlockStateContainer(this, FACING);
    }
    @Override
    public IBlockState getStateFromMeta(int meta) {

        EnumFacing facing = EnumFacing.getHorizontal(meta);
        return this.getDefaultState().withProperty(FACING, facing);
    }
    @Override
    public int getMetaFromState(IBlockState state) {

        EnumFacing facing = state.getValue(FACING);
        return facing.getHorizontalIndex();
    }

    @Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
    {
        if (!worldIn.isRemote) {
        Random random = new Random();
        int randomInt = random.nextInt(3);
        ItemStack itemStackToDrop;
        switch (randomInt){
            case 0:
            itemStackToDrop = new ItemStack(AddFoodMod.CHEESE, 1);
            break;
            case 1:
            itemStackToDrop = new ItemStack(AddFoodMod.COOKIE, 1);
            break;
            case 2:
            itemStackToDrop = new ItemStack(AddFoodMod.BAKED_APPLE, 1);
            break;
            default:
                itemStackToDrop = new ItemStack(Items.APPLE, 1);
        }
            EntityItem itemDrop = new EntityItem(worldIn, pos.getX(), pos.getY(), pos.getZ(), itemStackToDrop);
            worldIn.spawnEntity(itemDrop);
        }
        return true;
    }
    @Override
    public void onBlockClicked(World worldIn, BlockPos pos, EntityPlayer playerIn) {
        if (!worldIn.isRemote) {
            playerIn.sendMessage(new TextComponentString("You left-clicked on my block!"));
        }
    }

    @Override
    public void onBlockDestroyedByPlayer(World worldIn, BlockPos pos, IBlockState state) {
        if(!worldIn.isRemote){
            EntityPlayer playerIn = worldIn.getClosestPlayer(pos.getX(),pos.getY(), pos.getZ(), 5,false);
            String PlayerNeme = playerIn.getName();
            if(playerIn != null){
                playerIn.sendMessage(new TextComponentTranslation("message.destroyed",PlayerNeme));
            }
        }
    }

    @Override
    public void onBlockAdded(World worldIn, BlockPos pos, IBlockState state) {
        if(!worldIn.isRemote){
            EntityPlayer playerIn = worldIn.getClosestPlayer(pos.getX(),pos.getY(), pos.getZ(), 5,false);
            if(playerIn != null){
                if(playerIn.isSneaking()){
                playerIn.sendMessage(new TextComponentString("You set my block!"));
                }
            }
        }
    }
}
