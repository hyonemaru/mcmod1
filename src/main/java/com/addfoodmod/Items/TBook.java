package com.addfoodmod.Items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.nbt.NBTTagString;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

public class TBook extends Item {
    public TBook(){
        super();
        this.setCreativeTab(CreativeTabs.MISC);
        this.setUnlocalizedName("t_book");
        this.setMaxStackSize(1);
    }
    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {

        ItemStack heldItem = playerIn.getHeldItem(handIn);

        if (!worldIn.isRemote) {

            ItemStack writtenBook = new ItemStack(Items.WRITTEN_BOOK);


            NBTTagCompound tag = new NBTTagCompound();
            tag.setString("title", "Tutorial Book");
            tag.setString("author", "Acacia");
            NBTTagList pages = new NBTTagList();
            pages.appendTag(new NBTTagString("Banana \n Tomato"));
            pages.appendTag(new NBTTagString("Page 2 content"));

            tag.setTag("pages", pages);
            writtenBook.setTagCompound(tag);


            playerIn.addItemStackToInventory(writtenBook);

            if (!playerIn.capabilities.isCreativeMode) {
                heldItem.shrink(1);
            }
        }

        return new ActionResult<>(EnumActionResult.SUCCESS, heldItem);
    }
}
