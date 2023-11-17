package com.addfoodmod.Items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class Cookie extends ItemFood {
    public Cookie(int amount, float saturation, boolean isWolfFood){
        super(amount,saturation,isWolfFood);
        this.setCreativeTab(CreativeTabs.FOOD);
        this.setMaxStackSize(64);
        this.setUnlocalizedName("plain_cookie");
        GameRegistry.addSmelting(Items.WHEAT,new ItemStack(Cookie.this),10.0f);
    }
}
