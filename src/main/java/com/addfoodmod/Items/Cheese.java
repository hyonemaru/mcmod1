package com.addfoodmod.Items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemFood;

public class Cheese extends ItemFood {
    public Cheese(int amount, float saturation, boolean isWolfFood){
        super(amount,saturation,isWolfFood);
        this.setCreativeTab(CreativeTabs.FOOD);
        this.setMaxStackSize(64);
        this.setUnlocalizedName("cheese");

    }
}
