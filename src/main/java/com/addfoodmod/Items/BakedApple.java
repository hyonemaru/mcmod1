package com.addfoodmod.Items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

import javax.annotation.Nonnull;


public class BakedApple extends ItemFood {
public BakedApple(int amount, float saturation, boolean isWolfFood){

    super(amount,saturation,isWolfFood);
            this.setCreativeTab(CreativeTabs.FOOD);
            this.setMaxStackSize(64);
            this.setUnlocalizedName("baked_apple");
    GameRegistry.addSmelting(Items.APPLE,new ItemStack(BakedApple.this),10.0f);
}
}
