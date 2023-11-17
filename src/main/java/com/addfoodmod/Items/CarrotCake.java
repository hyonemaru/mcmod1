package com.addfoodmod.Items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemFood;

public class CarrotCake extends ItemFood {
    public CarrotCake(int amount, float saturation, boolean isWolfFood){
        super(amount,saturation,isWolfFood);
        this.setCreativeTab(CreativeTabs.FOOD);
        this.setMaxStackSize(64);
        this.setUnlocalizedName("carrot_cake");
    }
}
