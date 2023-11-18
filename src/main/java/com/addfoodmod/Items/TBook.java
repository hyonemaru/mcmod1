package com.addfoodmod.Items;

import com.sun.jna.platform.unix.X11;
import ibxm.Player;
import net.minecraft.client.resources.I18n;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemWrittenBook;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.nbt.NBTTagString;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;
import net.minecraftforge.client.event.RenderGameOverlayEvent;


public class TBook extends Item {
    public TBook(){
        super();
        this.setCreativeTab(CreativeTabs.MISC);
        this.setUnlocalizedName("t_book");
        this.setMaxStackSize(1);
    }
    public boolean isInventoryFull(EntityPlayer player) {
        for (int i = 0; i < player.inventory.getSizeInventory(); i++) {
            if (player.inventory.getStackInSlot(i).isEmpty()) {
                return false;
            }
        }
        return true;
    }
    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {

        ItemStack heldItem = playerIn.getHeldItem(handIn);

        if (!worldIn.isRemote) {

            ItemStack writtenBook = new ItemStack(Items.WRITTEN_BOOK);


            NBTTagCompound tag = new NBTTagCompound();
            tag.setString("title", "Tutorial Book");
            tag.setString("author", "Acacia");
            NBTTagList pages = new NBTTagList();
            String page1Text = "{\"text\":\"" + I18n.format("book.page1") + "\"}";
            String page2Text = "{\"text\":\"" + I18n.format("book.page2") + "\"}";
            String page3Text = "{\"text\":\"" + I18n.format("book.page3") + "\"}";

            pages.appendTag(new NBTTagString(page1Text));
            pages.appendTag(new NBTTagString(page2Text));
            pages.appendTag(new NBTTagString(page3Text));

            tag.setTag("pages", pages);
            writtenBook.setTagCompound(tag);

            if(!isInventoryFull(playerIn)) {
                boolean wasAdded = playerIn.inventory.addItemStackToInventory(writtenBook);
                if (wasAdded && !playerIn.capabilities.isCreativeMode) {
                    heldItem.shrink(1);
                }else if(!playerIn.capabilities.isCreativeMode){
                    playerIn.sendMessage(new TextComponentString("MAX Inventory"));
                }
            }
        }

        return new ActionResult<>(EnumActionResult.SUCCESS, heldItem);
    }
}
