package com.addfoodmod.Items;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemWrittenBook;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.nbt.NBTTagString;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.common.util.Constants;

import javax.annotation.Nullable;
import java.util.List;

public class MyCustomBook extends ItemWrittenBook {

    public MyCustomBook() {
        setCreativeTab(CreativeTabs.MISC);
        setMaxStackSize(1);
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
        ItemStack heldItem = playerIn.getHeldItem(handIn);
        if (!worldIn.isRemote) {
            readBookContents(heldItem, playerIn);
        }
        return super.onItemRightClick(worldIn, playerIn, handIn);
    }

    public void readBookContents(ItemStack bookStack, EntityPlayer player) {
        NBTTagCompound tagCompound = bookStack.getTagCompound();
        if (tagCompound != null && ItemWrittenBook.validBookTagContents(tagCompound)) {
            NBTTagList bookPages = tagCompound.getTagList("pages", Constants.NBT.TAG_STRING);

            for (int i = 0; i < bookPages.tagCount(); i++) {
                String pageText = bookPages.getStringTagAt(i);

                // Send the pageText to the player's chat
                player.sendMessage(new TextComponentString(TextFormatting.GOLD + "Page " + (i + 1) + ": " + TextFormatting.RESET + pageText));
            }
        }
    }

    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        readBookContents(stack, null); // Display book contents in item tooltip
    }
}

