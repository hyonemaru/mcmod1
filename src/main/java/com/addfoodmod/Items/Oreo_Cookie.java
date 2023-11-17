package com.addfoodmod.Items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemFood;

public class Oreo_Cookie extends ItemFood {
    public Oreo_Cookie(int amount, float saturation, boolean isWolfFood){
        super(amount,saturation,isWolfFood);
        this.setCreativeTab(CreativeTabs.FOOD);
        this.setMaxStackSize(64);
        this.setUnlocalizedName("oreo_cookie");
    }
}
