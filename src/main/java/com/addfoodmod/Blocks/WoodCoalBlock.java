package com.addfoodmod.Blocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.common.IFuelHandler;
public class WoodCoalBlock extends Block {
    public WoodCoalBlock(){
        super(Material.WOOD);
        this.setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
        this.setHardness(6.0f);
        this.setResistance(5.0f);
        this.setSoundType(SoundType.WOOD);
        this.setUnlocalizedName("wood_coal_block");

        GameRegistry.registerFuelHandler(new IFuelHandler(){
        @Override
        public int getBurnTime(ItemStack fuel){
            if(fuel.getItem() == Item.getItemFromBlock(WoodCoalBlock.this)){
                return 16000;
            }
            return 0;
        }
    });
    }
}

