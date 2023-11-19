package com.addfoodmod;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

public class MyOreDictionary {
    public static void init(){
        OreDictionary.registerOre("meat", new ItemStack(Items.BEEF,1,OreDictionary.WILDCARD_VALUE));
        OreDictionary.registerOre("meat", new ItemStack(Items.CHICKEN,1,OreDictionary.WILDCARD_VALUE));
        OreDictionary.registerOre("meat", new ItemStack(Items.PORKCHOP,1,OreDictionary.WILDCARD_VALUE));
        OreDictionary.registerOre("meat", new ItemStack(Items.MUTTON,1,OreDictionary.WILDCARD_VALUE));
        OreDictionary.registerOre("meat", new ItemStack(Items.RABBIT,1,OreDictionary.WILDCARD_VALUE));
    }
}
