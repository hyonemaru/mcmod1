package com.addfoodmod.Items;

import net.minecraft.block.Block;
import net.minecraft.block.BlockCrops;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemSeeds;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;
import scala.collection.parallel.ParIterableLike;

import javax.annotation.Nullable;
import java.util.Iterator;
import java.util.List;

public class IumpOfLife extends Item {
    public IumpOfLife(){
        this.setCreativeTab(CreativeTabs.MISC);
        this.setMaxStackSize(64);
        this.setUnlocalizedName("iump_of_life");
    }

    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        tooltip.add(I18n.format("item.tutorial.iumo_of_life"));
    }

    @Override
    public EnumActionResult onItemUse(EntityPlayer player, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        if (!worldIn.isRemote) {
            IBlockState state = worldIn.getBlockState(pos);
            Block block = state.getBlock();
            ItemStack heldItem = player.getHeldItem(hand);
            if(block instanceof BlockCrops){

                BlockCrops crop = (BlockCrops) block;
                worldIn.setBlockState(pos, crop.withAge(7));

                NonNullList<ItemStack> drops = NonNullList.create();
                crop.getDrops(drops, worldIn, pos, state, 5);

                ItemStack cropItem = null;
                int seedCount = 0;

                for (ItemStack drop : drops) {
                    if (drop.getItem() instanceof ItemSeeds) {
                        seedCount++;
                    } else {
                        cropItem = drop;
                    }
                }

                if (seedCount > 0) {
                    seedCount--;
                }

                if (cropItem != null) {
                    for (int i = 0; i < seedCount; i++) {
                        drops.add(cropItem);
                    }
                }

                Iterator<ItemStack> iterator = drops.iterator();
                while (iterator.hasNext()) {
                    ItemStack drop = iterator.next();
                    if (drop.getItem() instanceof ItemSeeds && seedCount > 0) {
                        iterator.remove();
                        seedCount--;
                    }
                }

                for (ItemStack drop : drops) {
                    Block.spawnAsEntity(worldIn, pos, drop);
                }
                heldItem.shrink(1);
            }
        }
        return EnumActionResult.SUCCESS;
    }
}
